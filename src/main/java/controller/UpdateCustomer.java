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

@WebServlet("/update-customer")
public class UpdateCustomer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd;

        CustomerDAO cd = new CustomerDAO();

        String address;

        Customer c = cd.doRetrieveById(Integer.parseInt(req.getParameter("id")));

        if(c != null) {

            address = "/WEB-INF/results/updateCustomer.jsp";

            req.setAttribute("customer", c);
        }

        else

            address = "/WEB-INF/results/unknown-customer.jsp";

        rd = req.getRequestDispatcher(address);

        rd.forward(req, resp);
    }
}
