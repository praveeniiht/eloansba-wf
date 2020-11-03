package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.dao.LoanDao;
import com.iiht.evaluation.eloan.model.LoanInfo;


@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionDao connDao;
	
	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}
	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action =  request.getParameter("action");
		System.out.println(action);
		String viewName = "";
		try {
			switch (action) {
			case "listall" : 
				viewName = listall(request, response);
				break;
			case "process":
				viewName=process(request,response);
				break;
			case "callemi":
				viewName=calemi(request,response);
				break;
			case "updatestatus":
				viewName=updatestatus(request,response);
				break;
			case "logout":
				viewName = adminLogout(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;		
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
		
		
	}

	private String updatestatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
		String applno = request.getParameter("applno");
		System.out.println(applno);
		int samount = Integer.parseInt(request.getParameter("samount"));
		int term = Integer.parseInt(request.getParameter("term"));
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		int emi = Integer.parseInt(request.getParameter("emi"));
		Connection con = connDao.connect();
		String sql = "insert into approvedloans values(?,?,?,?,?,?)";
		String sql1 = "update loaninfo set status='processed' where applno=?";
		PreparedStatement pst = con.prepareStatement(sql);
		PreparedStatement pst1 = con.prepareStatement(sql1);
		pst1.setString(1, applno);
		pst.setString(1,applno);
		pst.setInt(2, samount);
		pst.setInt(3, term);
		pst.setString(4, startdate);
		pst.setString(5, enddate);
		pst.setInt(6, emi);
		pst.executeUpdate();
		pst1.executeUpdate();
		
		
		return "adminhome1.jsp";
	}
	private String calemi(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String lid = request.getParameter("lid");
		Connection con = connDao.connect();
		String sql = "select applno, amtrequest from loaninfo where applno=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, lid);
		ResultSet rs = pst.executeQuery();
		rs.next();
		request.setAttribute("lid", rs.getString(1));
		request.setAttribute("ramount", rs.getInt(2));
		return "calemi.jsp";
	}
	private String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		return "process.jsp";
	}
	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "index.jsp";
	}

	private String listall(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		Connection con = connDao.connect();
		List<LoanInfo> loans = new ArrayList<LoanInfo>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from loaninfo");
		while(rs.next()) {
			String applno = rs.getString(1);
			 String purpose = rs.getString(2);
			 int amtrequest = rs.getInt(3);
			 String doa= rs.getString(4);
			 String bstructure=rs.getString(5);
			 String bindicator=rs.getString(6);
			 String address=rs.getString(7);
			 String email=rs.getString(8);
			 String mobile=rs.getString(9);
			 String status = rs.getString(10);
			LoanInfo loan = new LoanInfo(applno,purpose,amtrequest,doa,bstructure,
					bindicator,address,email,mobile,status);
			loans.add(loan);
			
		}
		request.setAttribute("loans", loans);
		return "listall.jsp";
	}

	
}