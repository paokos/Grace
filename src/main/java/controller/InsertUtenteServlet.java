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

@WebServlet("/insert-user-servlet")
public class InsertUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("firstName");
        String cognome = req.getParameter("lastName");
        String indirizzo;
        String email;
        String pass;
        Boolean admin;

        double balance=Double.parseDouble(req.getParameter("balance"));

        Utente user = new Utente();

        UtenteDAO service= new UtenteDAO();

        service.doSave(user);

        String address="/index.html";

        RequestDispatcher dispatcher = req.getRequestDispatcher(address);

        dispatcher.forward(req, resp);
    }
}
