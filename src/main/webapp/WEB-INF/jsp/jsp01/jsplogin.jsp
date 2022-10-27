<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>jsplogin</title>
</head>
<body>
	
	<sql:setDataSource var="dns"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://aws-tokyo.cmvw70di9ch0.ap-northeast-1.rds.amazonaws.com:3306/dbconnection?serverTimezone=UTC"
	user="admin"
	password="ai4a83ai4a83"/>
	
	<sql:query var="getData" dataSource="${dns}">
		select * from login where pk=1;
	</sql:query>
	
	
	<table border="1">
		<tr>
			<th>PK</th>
			<th>ID</th>
			<th>Pass</th>
		</tr>
		<c:forEach var="row" items="${getData.rows}">
			<tr>
				<td>${row.pk}</td>
				<td>${row.id}</td>
				<td>${row.pass}	</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>