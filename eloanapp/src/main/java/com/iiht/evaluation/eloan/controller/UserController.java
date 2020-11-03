package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.mysql.cj.xdevapi.Statement;




@WebServlet("/user")
public class UserController extends HttpServlet {
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
		String action = request.getParameter("action");
		
		String viewName = "";
		try {
			switch (action) {
			case "editLoanProcess"  :
				viewName=editLoanProcess(request,response);
				break;
			case "registerNewUser":
			viewName=registerNewUser(request,response);
			break;
			
			case "registeruser":
				viewName=registerUser(request,response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;	
			case  "displaystatus" :
				viewName=displaystatus(request,response);
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
	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String applno = request.getParameter("applno");
		String sql = "select * from loaninfo where applno=?";
		Connection con = connDao.connect();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,applno);
		ResultSet rs = pst.executeQuery();
		rs.next();
		LoanInfo loanInfo = new LoanInfo();
		loanInfo.setApplno(rs.getString(1));
		loanInfo.setPurpose(rs.getString(2));
		loanInfo.setAmtrequest(rs.getInt(3));
		loanInfo.setDoa(rs.getString(4));
		loanInfo.setBstructure(rs.getString(5));
		loanInfo.setBindicator(rs.getString(6));
		loanInfo.setAddress(rs.getString(7));
		loanInfo.setEmail(rs.getString(8));
		loanInfo.setMobile(rs.getString(9));
		loanInfo.setStatus(rs.getString(10));
		
		request.setAttribute("loaninfo", loanInfo);
		return "editloanui.jsp";
	}
	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("loginid");
		String pwd = request.getParameter("password");
		Connection conn=connDao.connect();
		String sql = "insert into user values (?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, uname);
		pst.setString(2, pwd);
		pst.executeUpdate();
		return "index.jsp";
	}
	private String registerNewUserPage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		return "newuserui.jsp";
	}
	private String registerNewUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("loginid");
		String pwd = request.getParameter("password");
		Connection conn=connDao.connect();
		String sql = "insert into user values (?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, uname);
		pst.setString(2, pwd);
		pst.executeUpdate();
		
		
		
		return "index.jsp";
	}
	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "register.jsp";
	}
	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String applno = request.getParameter("applno");
		System.out.println(applno);
		String viewPage=null;
		Connection conn = connDao.connect();
		String sql = "select * from loaninfo where applno =?";
		String sql1 = "select * from approvedloans where applno =?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, applno);
		ResultSet rs = pst.executeQuery();
		rs.next();
		String status = rs.getString(10);
		System.out.println(status);
		if(status.equals("processing")) {
			request.setAttribute("result", "Loan is in processing");
			viewPage="userhome1.jsp";
		}
		else
		{
			PreparedStatement pst1 = conn.prepareStatement(sql1);
			pst1.setString(1, applno);
			ResultSet rs1 = pst1.executeQuery();
			rs1.next();
			String tapplno= rs1.getString(1);
			int tamtsanctioned  = rs1.getInt(2);
			int tloanterm = rs1.getInt(3);
			String tpsd = rs1.getString(4);
			String tlcd = rs1.getString(5);
			int temi  = rs1.getInt(6);
			ApprovedLoan aloan = new ApprovedLoan(tapplno,tamtsanctioned,tloanterm,tpsd,tlcd,temi);
			System.out.println(aloan);
			request.setAttribute("aloan", aloan);
			viewPage="loanDetails.jsp";
		}
		return viewPage;
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "editloan.jsp";
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "trackloan.jsp";
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "application.jsp";
	}
}