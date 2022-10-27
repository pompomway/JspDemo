<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set PassWord</title>
</head>
<body>
	<form>
		<label for="pk">Pk:</label>
		<input type="text" id="pk" name="pk"/><br>
		<label for="olepass">old password:</label>
		<input type="password" id="olepass" name="olepass"/><br>
		<label for="newpass">new password:</label>
		<input type="password" id="newpass" name="newpass"/><br>
		<input type="submit" value="Change Password"/>
		
		<br><br>
	</form>
	<label>${message}</label>
	<form action="home">
		<input type="submit" value="Back"/>
	</form>
	
	
</body>
</html>