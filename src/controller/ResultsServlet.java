package controller;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResultsServlet
 */
@WebServlet("/ResultsServlet")
public class ResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		model.Model mod = (model.Model)getServletContext().getAttribute("model");

		String search=request.getParameter("search");
		request.setAttribute("search", search);
		List<model.Items> results=mod.smartSearch(search);
		request.setAttribute("results", results);
		
		request.setAttribute("title", "Results");
		request.setAttribute("page","content/Results.jsp");

		RequestDispatcher rd=request.getRequestDispatcher("template.jsp");  
        rd.forward(request, response); 
		out.close(); 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
