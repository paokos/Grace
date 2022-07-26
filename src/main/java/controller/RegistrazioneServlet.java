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
@WebServlet("/signup")
public class RegistrazioneServlet  extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Utente utente = new Utente();
        UtenteDAO utenteDAO = new UtenteDAO();
        utente.setNome(request.getParameter("nome"));
        utente.setCognome(request.getParameter("cognome"));
        utente.setIndirizzo(request.getParameter("email"));
        utente.setEmail(request.getParameter("email"));
        utente.setPass(request.getParameter("pass"));
        utente.setAdmin(Boolean.parseBoolean(request.getParameter("admin")));

        utenteDAO.doSave(utente);
        request.getSession().setAttribute("utente", utente);
        String address="/index.html";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
