<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Loan Application</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="right"><a href="userhome.jsp">UserHome</a></div>
<div align="right"><a href="index.jsp">Logout</a></div>
<h3 align=center>Edit Loan Application</h3>
<form action="user?action=editLoanProcess" method="post">
Enter Application Number <input type="text" name="applno"/>
<input type="submit" value="Track Application" />
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>