<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Editar Principiante Detalle</h1>

<form:form commandName="principiante">
	<table>	
		<tr>
			<td>Nombre:</td>
			<td><form:input path="nombre"/></td>
			<td><form:errors path="nombre"/></td>
		</tr>
		<tr>
			<td>Estado:</td>
			<td><form:input path="estado.descripcion"/></td>
			<td><form:errors path="estado.descripcion"/></td>
		</tr>
		<tr>
			<td>Estado:</td>
			<td>
				<form:select path="estado.estadoId">
					<form:options items="${estados}" itemLabel="descripcion" itemValue="estadoId"/>
				</form:select>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>Fecha Creacion:</td>
			<td><form:input path="auditor.fechaCreacion"/></td>
			<td><form:errors path="auditor.fechaCreacion"/></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Actualizar Principiante"/></td>
		</tr>
	</table>
</form:form>

</body>

</html>
