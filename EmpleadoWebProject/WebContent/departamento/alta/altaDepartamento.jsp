<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Departamento - Alta</h1>
<h2>Ingresa los datos para el nuevo Departamento</h2>
		<form method="post"
			action="${pageContext.request.contextPath}/departamento/DepartamentoAltaServlet">
			<ul>
				<li><label>Nombre del Departamento</label></li>
				<li><input type="text" name="nombreDepartamento"
					value="${index.nombreDepartamento}" /></li>
				<li><input type="submit" value="Enviar" /></li>
			</ul>
		</form>		
</body>
</html>