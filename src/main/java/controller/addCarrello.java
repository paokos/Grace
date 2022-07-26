package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello;
import model.CarrelloDAO;
import model.Prodotto;

import java.io.IOException;

@WebServlet("/addCarrello")
public class addCarrello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Carrello c = (Carrello) req.getSession().getAttribute("carrello");
        CarrelloDAO cd=new CarrelloDAO();
        if(c==null)
            c = cd.doCreateCarrello();
        Prodotto p=(Prodotto) req.getAttribute("prodotto");
        if(p.getDisponibili()<=(Integer) req.getAttribute("quantita")) {
            c.addContenuto(p, (Integer) req.getAttribute("quantita"));
            cd.addToCart(p, c, (Integer) req.getAttribute("quantita"));
        }
        req.getSession().setAttribute("carrello", c);
        resp.sendRedirect("carrello.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
