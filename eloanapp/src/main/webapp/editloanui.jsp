<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Loan Application</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="right"><a href="index.jsp">Logout</a></div>
<div align="right"><a href="userhome1.jsp">User Home</a></div>
<table>
<tr>
    <td><c:out value="${loanInfo.getApplno}" /></td>
    <td><c:out value="${loanInfo.getPurpose}" /></td>
    <td><c:out value="${loanInfo.getAmtrequest}" /></td>
    <td><c:out value="${loanInfo.getDoa}" /></td>
    <td><c:out value="${loanInfo.getBstructure}" /></td>
    <td><c:out value="${loanInfo.getBindicator}" /></td>
    <td><c:out value="${loanInfo.getAddress}" /></td>
    <td><c:out value="${loanInfo.getEmail}" /></td>
    <td><c:out value="${loanInfo.getMobile}" /></td>
    </tr>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>