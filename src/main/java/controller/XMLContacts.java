package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class XMLContacts
 */
@WebServlet("/XMLContacts")
public class XMLContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XMLContacts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml;charset=UTF-8");
		response.getWriter().append("<contacts>");
		response.getWriter().append("<contact><photo>img/pippo.jpg</photo><name>Goofy</name><number>329 4323143</number></contact>");
		response.getWriter().append("<contact><photo>img/topolino.jpg</photo><name>Mikey</name><number>333 3457349</number></contact>");
		response.getWriter().append("<contact><photo>img/minnie.jpg</photo><name>Minnie</name><number>339 3475983</number></contact>");
		response.getWriter().append("</contacts>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
