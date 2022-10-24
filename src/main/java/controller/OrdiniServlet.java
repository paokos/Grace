package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Carrello;
import model.Ordine;
import model.OrdineDAO;
import model.Utente;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ordini")
public class OrdiniServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utente u= (Utente) session.getAttribute("utente");
        if(u==null){
            response.sendRedirect(".");
        }
        OrdineDAO od=new OrdineDAO();
        ArrayList<Ordine> ordini;
        ordini=od.doRetriveByUtente(u.getId());
        session.setAttribute("ordini", ordini);
        response.sendRedirect("ordini.jsp");
    }
}
