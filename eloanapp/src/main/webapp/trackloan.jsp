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
<h3 align=center>Track Application Status</h3>
<div align="right"><a href="index.jsp">Logout</a></div>
<div align="right"><a href="userhome.jsp">UserHome</a></div>
<form action="user?action=displaystatus" method="post">
Enter Application Number <input type="text" name="applno"/>
<input type="submit" value="Track Application" />
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>