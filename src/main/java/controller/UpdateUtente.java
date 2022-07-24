package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update-customer")
/*user preferiti*/
public class UpdateUtente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        UtenteDAO ud = new UtenteDAO();
        String address="/WEB-INF/results/utente-sconosciuto.jsp";

        int userId= Integer.parseInt(req.getParameter("id"));
        String aggPrefer = req.getParameter("aggPrefer");
        String togliPrefer = req.getParameter("togliPrefer");
        Utente u = ud.doRetrieveById(Integer.parseInt(req.getParameter("id")));
        if(u == null) {
            address = "/WEB-INF/results/utente-sconosciuto.jsp";
        }
        else{
            HttpSession session = req.getSession();
            List<Integer> preferiti = (List<Integer>) session.getAttribute("Preferiti");
            if(preferiti==null){
                preferiti=new ArrayList<Integer>();
            }
            if(aggPrefer == null && togliPrefer==null){
                address = "/WEB-INF/results/updateCustomer.jsp";
                req.setAttribute("utente", u);
            }   else{
                if(aggPrefer!=null){
                    if(!preferiti.contains(userId))
                        preferiti.add(userId);
                }   else {
                    if(preferiti.contains(userId))
                        preferiti.remove(Integer.valueOf(userId));
                }
            }

                req.setAttribute("customer", u);
        }

        rd = req.getRequestDispatcher(address);

        rd.forward(req, resp);
    }
}
