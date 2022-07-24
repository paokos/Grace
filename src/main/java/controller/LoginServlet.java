package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;

public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String hash=PassHash.PasswordHasher(req.getParameter("pass"));
        UtenteDAO ud=new UtenteDAO();
        Utente u;
        u=ud.doRetrieveByEmailPassword(email, hash);
        req.setAttribute("Utente", u);
        String dest="/user-unknown";
        if(u!=null){
            HttpSession session= req.getSession();
            session.setAttribute("Utente", u);
            if(u.getAdmin()){
                dest="admin.jsp";
                req.getRequestDispatcher(dest).forward(req, resp);
            }
            else
                dest=".";
        }
        else {
            dest="login.jsp";
            req.getRequestDispatcher(dest).forward(req, resp);
        }
        resp.sendRedirect(dest);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
