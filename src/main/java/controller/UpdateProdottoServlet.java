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
@WebServlet("/updateProdottoServlet")
public class UpdateProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        RequestDispatcher rd;

        Prodotto p = new Prodotto();
        p.setCodice(Integer.parseInt(req.getParameter("codice")));
        p.setNome(req.getParameter("nome"));
        p.setImgsrc(req.getParameter("imgsrc"));
        p.setDescrizione(req.getParameter("descrizione"));
        p.setPrezzo(Double.parseDouble(req.getParameter("prezzo")));
        p.setTaglia(req.getParameter("taglia"));
        p.setDisponibili(Integer.parseInt(req.getParameter("disponibili")));
        p.setColore(req.getParameter("colore"));

        ProdottoDAO pd = new ProdottoDAO();
        pd.doUpdateProdotto(p);
        resp.sendRedirect("showAllProdotti");
    }

}
