package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Categoria;
import model.CategoriaDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/getCategoriaList")
public class getCategoriaList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CategoriaDAO cd=new CategoriaDAO();
		List<Categoria> categorie;
		categorie=cd.doRetrieveAll();
		session.setAttribute("Categorie", categorie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
