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

@WebServlet("/updateProdotto")
public class UpdateProdotto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        ProdottoDAO pd = new ProdottoDAO();
        String address="/WEB-INF/errorPage.jsp";
        Prodotto p = pd.doRetrieveByCodice(Integer.parseInt(req.getParameter("codice")));
        if(p != null) {
            address = "/WEB-INF/admin/updateProdotto.jsp";
            req.setAttribute("prodottoMod", p);
        }

        rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
