package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CustomerDAO;

import java.io.IOException;

@WebServlet("/insert-servlet")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");

        String lastName = req.getParameter("lastName");

        // qui manca il controllo sull'input balance, se non è un double bisogna rispondere al client con pagina di errore
        // come fatto per customerId in ShowBalance
        double balance=Double.parseDouble(req.getParameter("balance"));

        CustomerDAO service= new CustomerDAO();

        service.doSave(new Customer(firstName,lastName,balance));

        String address="/index.html";

        RequestDispatcher dispatcher = req.getRequestDispatcher(address);

        dispatcher.forward(req, resp);
    }
}
