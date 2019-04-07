<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Metodo SOAP: ${message}</h2>
<form action="/solicitausuario" method="post">
Ingrese su nombre:
<input type="text" name="name" size="20">
<br>
<input type="submit" value="enviar">
</form>
<h2>Nombre solicitado: ${resp}</h2>
</body>
</html>