package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Carrello;

import java.io.IOException;

@WebServlet("/carrello-servlet")
public class CarrelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
        if(cart!=null){
            response.sendRedirect("carrello.jsp");
        }
    }
}