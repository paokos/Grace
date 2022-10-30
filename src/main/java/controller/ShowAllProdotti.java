package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Prodotto;
import model.ProdottoDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/showAllProdotti"})
public class ShowAllProdotti extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Prodotto> prodotti;
        ProdottoDAO pd = new ProdottoDAO();
        String address = "/WEB-INF/admin/showAllProdotti.jsp";
        RequestDispatcher rd;
        prodotti = pd.doRetrieveAll();
        req.setAttribute("prodotti", prodotti);
        rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
