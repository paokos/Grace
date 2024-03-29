package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello;
import model.CarrelloDAO;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet("/insertUser")
public class InsertUtenteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String indirizzo = req.getParameter("indirizzo");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        boolean admin = false;
//        Carrello c=((Carrello) req.getSession().getAttribute("Carrello"));
//        if(c==null)
//
        String dest;

        if (nome.equals("") || cognome.equals("") || indirizzo.equals("") || email.equals("") || pass.equals("")) {
            dest="signup.jsp";
            req.setAttribute("registerErr", "Credenziali non valide");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }
        else {
            pass=PassHash.PasswordHasher(pass);
            Utente u = new Utente();
            UtenteDAO ud= new UtenteDAO();
            u.setNome(nome);
            u.setCognome(cognome);
            u.setIndirizzo(indirizzo);
            u.setEmail(email);
            u.setPass(pass);
            u.setAdmin(admin);
            if(req.getSession().getAttribute("Carrello")!=null)
                u.setCarrello(((Carrello) req.getSession().getAttribute("Carrello")).getCartId());
            else{
                Carrello c= new CarrelloDAO().doCreateCarrello();
                u.setCarrello(c.getCartId());
                req.getSession().setAttribute("carrello", c);
            }
            ud.doSave(u);
            req.getSession().setAttribute("utente", u);
            dest="index.jsp";
            resp.sendRedirect(dest);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
