<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="alta.js"></script>
<title>Alta de empleados</title>
<<style>
body {
	background-color: #333;
	color: #FFF;
}
</style>
</head>
<body>

<h1>Alta  de empleados</h1>


<form id="formulario" name="formulario">

<h3>Ingrese los siguientes campos, todos son requeridos</h3>

<ul>
<li><label>Ingrese SSN</label> <input id="ssn" name="ssn" type="text" placehold="Ingrese ssn"  /></li> <br>
<li><label>Ingrese nombre</label> <input id="nombre" name="nombre" type="text" placehold="Ingrese nombre"  /></li> <br>
<li><label>Ingrese edad</label> <input id="edad" name="edad" type="text" placehold="Ingrese edad"  /></li> <br>
<li><label>Ingrese sueldo</label> <input id="sueldo" name="sueldo" type="text" placehold="Ingrese sueldo"  /></li> <br>
<li><label>Ingrese Curp</label> <input id="curp" name="curp" type="text" placehold="Ingrese Curp"  /></li> <br>
</ul>

<button id="submit" name="submit" type="button" >Aceptar</button>
</form>

</body>
</html>