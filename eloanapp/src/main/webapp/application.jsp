<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Application Form</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body onload="myFunction()">
<script>

function myFunction() {
	date = new Date();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var year = date.getFullYear();

	if (document.getElementById('appliedDate').value == ''){
	document.getElementById('appliedDate').value = day + '-' + month + '-' + year;
	}

}
</script>
<jsp:include page="header.jsp"/>
<h4 align=center>Application form for Home Mortage</h4>
<div align="right"><a href="userhome.jsp">UserHome</a></div>
<div align="right"><a href="index.jsp">Logout</a></div>
<form action="user?action=placeloan">
<table align=center border=1>
	<tr>
		<td>Application Number </td>
		<td><input type="text" name="applno" >
	</tr>
	<tr>
		<td>Loan puporse </td>
		<td><input type="text" name="purpose" />
	</tr>
	<tr>
		<td>Loan Amount Requested </td>
		<td><input type="text" name="amount" />
	</tr>
	<tr>
		<td>Application Date </td>
		<td><input type="text" name="appliedDate"  id="appliedDate"/>
	</tr>
	<tr>
		<td>Business Structure</td>
		<td><select name="bstructrue"><option value="Individual" >Individual</option>
		<option value="Organization">Organization</option>
		</select></td>
	</tr>
	<tr>
		<td>Billing Indicator</td>
		<td><select  name="bindicator"><option value="salaried">Salaried</option>
		<option value="Self Employed">Non Salaried</option>
		</select></td>
	</tr>
	<tr>
		<td>Contact Address</td>
		<td><input type="text" name="address" />
	</tr>
	<tr>
		<td>Mobile</td>
		<td><input type="text" name="mobile" />
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="email" name="email" />
	</tr>
	<tr>
	
	<td> <input type="submit" value="Apply" /></td>
	</tr>

</table>

</form>
<jsp:include page="footer.jsp"/>

</body>
</html>