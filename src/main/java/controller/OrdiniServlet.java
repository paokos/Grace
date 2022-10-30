package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ordini")
public class OrdiniServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utente u= (Utente) session.getAttribute("utente");
        if(u==null){
            response.sendRedirect(".");
        }
        OrdineDAO od=new OrdineDAO();
        ArrayList<Ordine> ordini;
        ordini=od.doRetriveByUtente(u.getId());
        RequestDispatcher rd;
        request.setAttribute("ordini", ordini);
        rd = request.getRequestDispatcher("ordini.jsp");
        rd.forward(request, response);
    }
}
