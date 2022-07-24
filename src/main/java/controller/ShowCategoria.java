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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/show-categoria")
public class ShowCategoria extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Prodotto> prodotti = new ArrayList<>();

        ProdottoDAO pd = new ProdottoDAO();

        String address = "/WEB-INF/results/showAll.jsp";

        RequestDispatcher rd;
        String cat;
        cat = (req.getParameter("cat"));
        req.setAttribute("prodotti", prodotti);

        rd = req.getRequestDispatcher(address);

        rd.forward(req, resp);
    }
}
