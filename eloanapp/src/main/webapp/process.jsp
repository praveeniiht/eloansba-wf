<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="right"><a href="index.jsp">Logout</a></div>
<div align="right"><a href="adminhome1.jsp">Admin Home</a></div>
<form action="admin?action=callemi" method="post">
<h3 align=center>Loan processing page</h3>
Enter Loan Application <input type="text" name="lid" /><br>
<input type="submit" value="submit"/>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>