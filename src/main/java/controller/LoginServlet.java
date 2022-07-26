package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Carrello;
import model.CarrelloDAO;
import model.Utente;
import model.UtenteDAO;
import static controller.PassHash.PasswordHasher;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String hash=PasswordHasher(req.getParameter("password"));
        UtenteDAO ud=new UtenteDAO();
        Utente u;
        u=ud.doRetrieveByEmailPassword(email, hash);
        String dest="index.jsp";
//        se l'utente esiste ed è valido
        if(u!=null){
            HttpSession session= req.getSession();
            session.setAttribute("utente", u);
            CarrelloDAO cd= new CarrelloDAO();
            Carrello c=cd.doRetrieveById(u.getCarrello());
            session.setAttribute("carrello", c);
//            se è un'amministratore è inviato alla pagina di amministrazione
            if(u.getAdmin()){
                dest="./WEB-INF/admin.jsp";
                req.getRequestDispatcher(dest).forward(req, resp);
//                resp.sendRedirect(dest);
            }
//          altrimenti alla homepage
            else {
                dest="index.jsp";
                resp.sendRedirect(dest);
            }
        }
        else {
//        altrimenti viene reinviato alla schermata di login
            dest="login.jsp";
            req.setAttribute("loginErr", "Credenziali non valide");
            req.getRequestDispatcher(dest).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
