package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Categoria;
import model.CategoriaDAO;
import model.Prodotto;
import model.ProdottoDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//CategoriaServlet.java: legge l’id della categoria dalla request e recupera gli oggetti categoria dal
//        servlet context. Usando l’id ottiene l’oggetto categoria corrispondente e recupera tutti i prodotti nel
//        db che fanno parte di quella categoria. Inserisce nella request la categoria ed i prodotti
//        corrispondenti e passa il controllo a categoria.jsp
@WebServlet("/prodotto")
public class ProdottoServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getServletContext().getAttribute("categorie");
        ProdottoDAO pd=new ProdottoDAO();
//        Categoria c=cd.getCategoriaByNome(req.getParameter("Categoria"));
        Prodotto p=pd.doRetrieveByCodice(Integer.parseInt(req.getParameter("codice")));
        if(p!=null) {
//            ProdottoDAO pd = new ProdottoDAO();
//            List<Prodotto> prodotti;
            String address = "prodotto.jsp";
            req.setAttribute("prodotto", p);
//            req.setAttribute("categoria",);
            RequestDispatcher rd;
            rd = req.getRequestDispatcher(address);
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}