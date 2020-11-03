<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="right"><a href="userhome.jsp">UserHome</a></div>
<div align="right"><a href="index.jsp">Logout</a></div>
<h3 align=center>Loan Details </h3>
<table border=1 align=center>
<tr>
	<td> Loan Number </td>
   <td> <c:out value="${aloan.applno}" /></td>
  </tr>
  <tr>
  	<td>Loan Amount Sanctioned</td>
  	<td><c:out value="${aloan.amotsanctioned}" /></td>
  </tr>
  <tr>
  	<td>Loan Tenure(years)</td>
  	<td> <c:out value="${aloan.loanterm}" /></td>
  </tr>
  <tr>
  <td> Payment Start Date </td>
  <td> <c:out value="${aloan.psd}" /></td>
  </tr>
  <tr>
  <td>Payment Close Date </td>
  <td> <c:out value="${aloan.lcd}" /></td>
  </tr>
  <tr>
  <td>EMI </td>
  <td><c:out value="${aloan.emi}" /></td>
  </tr>
  </table>  
 <jsp:include page="footer.jsp"/>
</body>
</html>