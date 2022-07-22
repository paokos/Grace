package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class JSONServlet
 */
@WebServlet("/JSONContacts")
public class JSONContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONContacts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().append("[");
		response.getWriter().append("{\"photo\": \"img/pippo.jpg\", \"name\": \"Goofy\",\"number\": \"329 4323143\"},");
		response.getWriter().append("{\"photo\": \"img/topolino.jpg\", \"name\": \"Mickey\",\"number\": \"333 3457349\"},");
		response.getWriter().append("{\"photo\": \"img/minnie.jpg\", \"name\": \"Minnie\",\"number\": \"339 3475983\"}");
		response.getWriter().append("]");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
