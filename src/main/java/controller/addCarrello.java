package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello;
import model.CarrelloDAO;
import model.Prodotto;
import model.ProdottoDAO;

import java.io.IOException;

@WebServlet("/addCarrello")
public class addCarrello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Carrello c = (Carrello) req.getSession().getAttribute("carrello");
        CarrelloDAO cd=new CarrelloDAO();
        if(c==null)
            c = cd.doCreateCarrello();
        ProdottoDAO pd=new ProdottoDAO();
        Prodotto p=pd.doRetrieveByCodice(Integer.parseInt(req.getParameter("codice")));
        if(p.getDisponibili()<=Integer.parseInt(req.getParameter("quantita"))+c.getQuantProdotto(p)) {
            c.addContenuto(p, Integer.parseInt(req.getParameter("quantita")));
            cd.addToCart(p, c, Integer.parseInt(req.getParameter("quantita")));
        }
        req.getSession().setAttribute("carrello", c);
        resp.sendRedirect("carrello.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
