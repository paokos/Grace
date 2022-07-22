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
import java.util.List;

@WebServlet(urlPatterns = {"/show-all"})
public class ShowAll extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Customer> customers;

        CustomerDAO cd = new CustomerDAO();

        String address = "/WEB-INF/results/showAll.jsp";

        RequestDispatcher rd;

        customers = cd.doRetrieveAll();

        req.setAttribute("customers", customers);

        rd = req.getRequestDispatcher(address);

        rd.forward(req, resp);
    }
}
