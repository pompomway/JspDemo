<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div>

		<form>
			<label for="id">ID  :</label>
			<input type="text" id="id" name="id"/><br>
			<label for="pass">Pw:</label>
			<input type="password" id="pass" name="pass"/><br>
			<input type="submit"/><br>
			
		</form>
		<label>${message}</label>

	</div>
</body>
</html>