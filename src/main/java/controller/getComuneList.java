package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/getComuneList")
public class getComuneList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provincia = request.getParameter("provincia");
		if (provincia.equalsIgnoreCase("salerno")){
			response.getWriter().append("<option>Agropoli</option>");
			response.getWriter().append("<option>Fisciano</option>");
			response.getWriter().append("<option>Nocera Superiore</option>");
			response.getWriter().append("<option>Salerno</option>");
			response.getWriter().append("<option>Vallo della Lucania</option>");
		}
		else if (provincia.equalsIgnoreCase("avellino")){
			response.getWriter().append("<option>Atripalda</option>");
			response.getWriter().append("<option>Avellino</option>");
			response.getWriter().append("<option>Grottaminarda</option>");
			response.getWriter().append("<option>Mirabella Eclano</option>");
			response.getWriter().append("<option>Taurasi</option>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
