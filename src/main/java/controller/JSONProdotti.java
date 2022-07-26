package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Prodotto;
import model.ProdottoDAO;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/JSONProdotti")
public class JSONProdotti extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdottoDAO pd=new ProdottoDAO();
        List<Prodotto> prodotti= pd.doRetrieveAll();
        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().append("[");
        for(Prodotto p : prodotti) {
            //    codice, nome, prezzo, colore, taglia, descrizione, disponibili, imgsrc
            response.getWriter().append("{\"codice\": \""+p.getCodice()+"\", \"nome\": \""+p.getNome()+"\",\"prezzo\": \""+p.getPrezzo()
                    +"\",\"colore\": \""+p.getColore()+"\", \"taglia\": \""+p.getTaglia()+"\",\"descrizione\": \""+p.getDescrizione()+
                    "\",\"disponibili\": \""+p.getDisponibili()+"\",\"imgsrc\": \""+p.getImgsrc()+"\"}");
        }
        response.getWriter().append("]");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
