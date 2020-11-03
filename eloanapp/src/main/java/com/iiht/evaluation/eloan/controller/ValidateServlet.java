package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
private ConnectionDao connDao;
	
	
	public void setLoginDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);

	}
	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname = request.getParameter("loginid");
		String pwd = request.getParameter("password");
		Connection connection=null;
		boolean isUser = false;
		try {
			connection = connDao.connect();
			String sql = "select * from user";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String tid = rs.getString(1);
				String tpwd = rs.getString(2);
				if(tid.equals(uname) && tpwd.equals(pwd)) {
					isUser=true;
					break;
				}
			}
			if(isUser) {
				if(uname.equals("admin") ) {
					RequestDispatcher dispatch = 
							request.getRequestDispatcher("adminhome1.jsp");
				dispatch.forward(request, response);
			}
				else {
				RequestDispatcher dispatch = 
						request.getRequestDispatcher("userhome1.jsp");
			dispatch.forward(request, response);
				}
			}
			else {
				RequestDispatcher dispatch = 
						request.getRequestDispatcher("index.jsp");
			dispatch.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
