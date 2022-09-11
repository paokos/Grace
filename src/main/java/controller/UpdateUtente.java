package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/updateUtente")
public class UpdateUtente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        UtenteDAO ud = new UtenteDAO();
        String address="/WEB-INF/results/utente-sconosciuto.jsp";
        Utente u = ud.doRetrieveById(Integer.parseInt(req.getParameter("id")));
        if(u != null) {
            address = "/WEB-INF/results/updateUtente.jsp";
            req.setAttribute("utenteMod", u);
        }
        else
            address = "/WEB-INF/results/unknown-customer.jsp";

        rd = req.getRequestDispatcher(address);
        rd.forward(req, resp);
    }
}
