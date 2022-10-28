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
        if(c==null) {
            c = cd.doCreateCarrello();
        }
        ProdottoDAO pd=new ProdottoDAO();
        Prodotto p=pd.doRetrieveByCodice(Integer.parseInt(req.getParameter("codice")));
        int presente = c.getQuantProdotto(p);
        int tot=Integer.parseInt(req.getParameter("quantita"))+presente;
        if(tot<=10 && p.getDisponibili()<=tot) {
            c.addProdotto(p, 1);
            cd.addToCart(p, c, 1);
        }
        req.getSession().setAttribute("carrello", c);
        resp.sendRedirect("carrello.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
