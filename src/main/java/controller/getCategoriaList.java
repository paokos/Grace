package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class getComuneList
 */
@WebServlet("/getCategoriaList")
public class getCategoriaList extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCategoriaList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String categoria = request.getParameter("provincia");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
