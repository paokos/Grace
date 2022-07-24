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
@WebServlet("/categoria-servlet")
public class CategoriaServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getAttribute("categorie");
        CategoriaDAO cd=new CategoriaDAO();
        Categoria c=cd.getCategoriaByNome(req.getParameter("Categoria"));
        ProdottoDAO pd=new ProdottoDAO();
        List<Prodotto> prodotti;
        String address="categoria.jsp";

        prodotti=pd.doRetrieveByCategoria(c);
        req.setAttribute("categoria", c);
        req.setAttribute("panama", "panama");
        req.setAttribute("prodotti", prodotti);
        RequestDispatcher rd;
        rd= req.getRequestDispatcher(address);
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
