package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CustomerDAO;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet("/update-servlet")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher rd;

        Utente user, u = new Utente();
        u.setId(Integer.parseInt(req.getParameter("nome")));
        u.setNome(req.getParameter("nome"));
        u.setCognome(req.getParameter("cognome"));
        u.setEmail(req.getParameter("email"));
        u.setAdmin(Boolean.parseBoolean(req.getParameter("admin")));
        u.setIndirizzo(req.getParameter("indirizzo"));
        u.setPass(req.getParameter("pass"));

        UtenteDAO ud = new UtenteDAO();

        ud.doUpdateUtente(u);

        user = ud.doRetrieveById(u.getId());

        req.setAttribute("customer", user);

        rd = req.getRequestDispatcher("WEB-INF/results/updateResult.jsp");

        rd.forward(req, resp);
    }
}
