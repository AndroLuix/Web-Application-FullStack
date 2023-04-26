package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Os;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoMySql;

/**
 * Servlet implementation class OsServlet
 */
public class OsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoMySql dao = null;
		try {
			dao = new DaoMySql();
			
			if(dao!=null) {
				if( request.getParameter("selectAll")!=null) {
					ArrayList<Os> osList = dao.getAllOs();
					
					request.setAttribute("osList", osList); //creazione attributo
					
					RequestDispatcher rd = request.getRequestDispatcher("allOs.jsp");
					rd.forward(request, response);
				}
				else if(request.getParameter("selectOsById")!=null) {
					int id = Integer.parseInt(request.getParameter("selectOsById"));
					
					Os os = dao.getOsById(id);
					request.setAttribute("os", os);
					RequestDispatcher rd = request.getRequestDispatcher("osById.jsp");
					rd.forward(request, response);
					
					
				}else if(request.getParameter("selectOsByCompany")!=null) {
					String company = request.getParameter("selectOsByCompany");
					ArrayList<Os> companyList = dao.getOsByCompany(company);
					
					//Os company = dao.getOsByCompany(company);
					request.setAttribute("companyList", companyList);
					RequestDispatcher rd = request.getRequestDispatcher("osByCompany.jsp");
					rd.forward(request, response);
					
					
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
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
