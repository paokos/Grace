package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/ordina")
public class EseguiOrdine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Carrello c=(Carrello) session.getAttribute("carrello"), cFix=new Carrello();    //ottengo il carrello e
            // creo un nuovo carrello con cui fixare gli elementi in eccesso
        CarrelloDAO cd=new CarrelloDAO();
        ProdottoDAO pd=new ProdottoDAO();
        HashMap<Prodotto, Integer> prodotti=c.getContenuto(), prodottiFix=new HashMap<>();
        Prodotto pt;    //prodotto temporaneo da aggiunger
        for(Prodotto p: prodotti.keySet()){
            pt=pd.doRetrieveByCodice(p.getCodice());
            if(prodotti.get(p)<=pt.getDisponibili())
                prodottiFix.put(p, prodotti.get(p));
            else
                prodottiFix.put(p, pt.getDisponibili());
        }
        OrdineDAO od=new OrdineDAO();
        cFix.setCartId(c.getCartId());
        cFix.setContenuto(prodottiFix);
        od.doSaveByCart(cFix);
        cd.svuotaCart(c);
        c.svuotaCarrello();
        session.setAttribute("carrello", c);
        resp.sendRedirect("ordini.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
