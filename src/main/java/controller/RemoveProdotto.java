package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Carrello;
import model.CarrelloDAO;
import model.Prodotto;
import model.ProdottoDAO;

import java.io.IOException;

@WebServlet("/removeProdotto")
public class RemoveProdotto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Carrello c= (Carrello) session.getAttribute("carrello");
        ProdottoDAO pd =new ProdottoDAO();
        Prodotto p = pd.doRetrieveById(Integer.parseInt(req.getParameter("prodotto"))) ;
        CarrelloDAO cd=new CarrelloDAO();
        if(p!=null) {
             if(c!=null) {
                 c.removeContenuto(p);
                 cd.removeFromCart(p, c);
                 session.setAttribute("carrello", c);
             }
            resp.sendRedirect(".");
        }
        else {
            resp.sendRedirect("./index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
