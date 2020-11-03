<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="admin?action=updatestatus" method="post">
Loan Application Number: <input type="text" name="applno" value="${lid}"  /><br>
<c:set var = "tid" scope = "session" value = "${lid}"/>
Requested Amount: <c:out value="${ramount}" /><br>


Enter Sanctioned Amount <input type=text name="samount" /><br>
Loan Term <input type=text name="term" value=20 /><br>
Loan Payment Start Date <input type="text" name="startdate" /><br>
Loan Payment End Date <input type="text" name="enddate" /><br>
Monthly EMI <input type=text name="emi" /><br>
<input type="submit" value="Accept" />
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>