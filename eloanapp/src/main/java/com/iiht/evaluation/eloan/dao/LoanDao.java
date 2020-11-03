package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.iiht.evaluation.eloan.model.LoanInfo;

public class LoanDao {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public LoanDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	protected  Connection  connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public int registerLoan(LoanInfo loaninfo) throws SQLException {
		Connection conn = connect();
		String sql = "insert into loaninfo(applno,purpose,amtrequest,doa,bstructure,bindicator,address,email,mobile) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, loaninfo.getApplno());
		pst.setString(2, loaninfo.getPurpose());
		pst.setInt(3, loaninfo.getAmtrequest());
		pst.setString(4, loaninfo.getDoa());
		pst.setString(5, loaninfo.getBstructure());
		pst.setString(6, loaninfo.getBindicator());
		pst.setString(7, loaninfo.getAddress());
		pst.setString(8, loaninfo.getEmail());
		pst.setString(9, loaninfo.getMobile());
		int k = pst.executeUpdate();
		return k;
	}
}
