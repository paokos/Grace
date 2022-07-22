package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;

@WebServlet("/update-servlet")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd;

        Customer c1, c = new Customer(Integer.parseInt(req.getParameter("id")), req.getParameter("name"),
                req.getParameter("lastname"), Double.parseDouble(req.getParameter("balance")));

        CustomerDAO cd = new CustomerDAO();

        cd.doUpdateCustomer(c);

        c1 = cd.doRetrieveById(c.getId());

        req.setAttribute("customer", c1);

        rd = req.getRequestDispatcher("WEB-INF/results/updateResult.jsp");

        rd.forward(req, resp);
    }
}
