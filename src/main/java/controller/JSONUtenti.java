package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/JSONUtenti")
public class JSONUtenti extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteDAO ud=new UtenteDAO();
		List<Utente> utenti= ud.doRetrieveAll();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().append("[");
		for(Utente u : utenti) {
			response.getWriter().append("{\"id\": \""+u.getId()+"\", \"nome\": \""+u.getNome()+"\",\"cognome\": \""+u.getCognome()
					+"\",\"password\": \""+u.getPass()+"\", \"admin\": \""+u.getAdmin()+"\",\"carrello\": \""+u.getCarrello()+"\"}");
		}
		response.getWriter().append("]");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
