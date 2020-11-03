<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Loans</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="right"><a href="index.jsp">Logout</a></div>
<div align="right"><a href="adminhome1.jsp">Admin Home</a></div>
<table border=1 align=center>
<c:forEach items="${loans}" var="loanInfo">
  <tr>
    <td><c:out value="${loanInfo.getApplno()}" /></td>
    <td><c:out value="${loanInfo.getPurpose()}" /></td>
    <td><c:out value="${loanInfo.getAmtrequest()}" /></td>
    <td><c:out value="${loanInfo.getDoa()}" /></td>
    <td><c:out value="${loanInfo.getBstructure()}" /></td>
    <td><c:out value="${loanInfo.getBindicator()}" /></td>
    <td><c:out value="${loanInfo.getAddress()}" /></td>
    <td><c:out value="${loanInfo.getEmail()}" /></td>
    <td><c:out value="${loanInfo.getMobile()}" /></td>
    </tr>
</c:forEach>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>