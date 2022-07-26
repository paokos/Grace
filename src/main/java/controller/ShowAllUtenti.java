package controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/show-all"})
public class ShowAllUtenti extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Utente> utenti;

        UtenteDAO ud = new UtenteDAO();

        String address = "/WEB-INF/results/showAllUtenti.jsp";

        RequestDispatcher rd;

        utenti = ud.doRetrieveAll();

        req.setAttribute("utenti", utenti);

        rd = req.getRequestDispatcher(address);

        rd.forward(req, resp);
    }
}
