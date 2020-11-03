<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eLoan system</title>
</head>
<body>
<div>
<jsp:include page="header.jsp"/>
<hr/>
<div align=center>
	<h2>eLoan Login</h2>
	<form action="validate" method="post">
		<div>
			<div><label for="loginid">Enter login Id</label> </div>
			<div><input type="text" id="loginid" name="loginid"> </div>
		</div>
		<div>
			<div><label for="password">Enter password</label> </div>
			<div><input type="text" id="password" name="password"> </div>
		</div>
		<div>
			<div><input type="submit" value="Login"> </div>
		</div>
		<a href="user?action=registerNewUser"><button>New User? register here</button></a>
	</form>
	</div>
	</div>
<hr/>
<jsp:include page="footer.jsp"/>
</body>
</html>