package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utente;
import model.UtenteDAO;

import javax.swing.*;
import java.io.IOException;

@WebServlet("/updateSelfUtente")
public class UpdateSelfUtente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utente u= (Utente) req.getSession().getAttribute("utente"), uMod=new Utente();
        UtenteDAO ud= new UtenteDAO();
        String dest = "/home";
        if(PassHash.PasswordHasher(req.getParameter("password")).equals(u.getPass())){
            uMod.setId(u.getId());
            uMod.setAdmin(u.getAdmin());
            uMod.setCarrello(u.getCarrello());
            if (!req.getParameter("nome").equals("")) {
                uMod.setNome(req.getParameter("nome"));
            }
            else
                uMod.setNome(u.getNome());
            if (!req.getParameter("cognome").equals("")) {
                uMod.setCognome(req.getParameter("cognome"));
            }
            else
                uMod.setCognome(u.getCognome());
            if (!req.getParameter("email").equals("")) {
                uMod.setEmail(req.getParameter("email"));
            }
            else
                uMod.setEmail(u.getEmail());
            if (!req.getParameter("indirizzo").equals("")) {
                uMod.setIndirizzo(req.getParameter("indirizzo"));
            }
            else
                uMod.setIndirizzo(u.getIndirizzo());
            if (!req.getParameter("newPassword").equals("")){
                uMod.setNome(PassHash.PasswordHasher(req.getParameter("newPassword")));
            }
            else
                uMod.setNome(u.getPass());
            ud.doUpdateUtente(uMod);
            req.getSession().setAttribute("utente", uMod);
            resp.sendRedirect(dest);
        }
        else{
            dest="profilo.jsp";
            req.setAttribute("updateErr", "Password non valida");
            req.getRequestDispatcher(dest).forward(req, resp);
        }
        resp.sendRedirect(dest);
    }
}
