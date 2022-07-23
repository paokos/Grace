package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Categoria;
import model.CategoriaDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name="MyInit", urlPatterns="/MyInit", loadOnStartup=0)
public class InitServlet extends HttpServlet {
    @Override
    public void initCategorie() throws ServletException {
        super.init();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorie = categoriaDAO.doRetrieveAll();
        getServletContext().setAttribute("categorie", categorie);
    }

    public void initCarrello() throws ServletException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorie = categoriaDAO.doRetrieveAll();
        getServletContext().setAttribute("categorie", categorie);
        super.init();
    }
// non è necessario né doGet né doPost. La usiamo solo per inserire le categorie
// nel livello servlet context al caricamento dell’applicazione
// (perché servlet context e non Sessione?)
}
