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

@WebServlet("/updateUtenteServlet")
public class UpdateUtenteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher rd;

        Utente /*user,*/ u = new Utente();
        u.setId(Integer.parseInt(req.getParameter("id")));
        u.setNome(req.getParameter("nome"));
        u.setCognome(req.getParameter("cognome"));
        u.setEmail(req.getParameter("email"));
        u.setAdmin(Boolean.parseBoolean(req.getParameter("admin")));
        u.setIndirizzo(req.getParameter("indirizzo"));
        u.setPass(req.getParameter("pass"));

        UtenteDAO ud = new UtenteDAO();
        ud.doUpdateUtente(u);
//        user = ud.doRetrieveById(u.getId());
//        req.setAttribute("utente", user);
        resp.sendRedirect("showAllUtenti");
//        rd = req.getRequestDispatcher("showAllUtenti");
//        rd.forward(req, resp);
    }
}
