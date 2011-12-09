<%@ include file="/common/taglibs.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Principiante Detalle</h1>

	<table>
		<tr>
			<td>Id:</td>
			<td>${principiante.principianteId}</td>
		</tr>
		<tr>
			<td>Nombre:</td>
			<td>${principiante.nombre}</td>
		</tr>
		<tr>
			<td>Fecha Creacion:</td>
			<td>${principiante.fechaCreacion}</td>
		</tr>
	</table>

	<p>
		<a href="principianteEditar?principianteId=${principiante.principianteId}">Editar Principiante</a>
	</p>

</body>
</html>
