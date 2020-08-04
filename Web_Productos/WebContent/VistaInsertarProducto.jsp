<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insertar Nuevo Producto</h1>
	<form action="ControladorDeProductos">
		<input type="hidden" name="instruccion" value="insertar_producto">
		<table>
			<tr>
				<td><label for="nombre">Nombre: </label></td>
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td><label for="descripcion">Descripcion: </label></td>
				<td><input type="text" name="descripcion"></td>
			</tr>
			<tr>
				<td><label for="precio">Precio: </label></td>
				<td><input type="number" name="precio"></td>
			</tr>
			<tr>
				<td><label for="stock">Stock: </label></td>
				<td><input type="number" name="stock"></td>
			</tr>
			<tr>
				<td><label for="categoriaId">Categoria ID: </label></td>
				<td><input type="number" name="categoriaId"></td>
			</tr>
			<tr>
				<td><label for="marcaId">Marca ID: </label></td>
				<td><input type="number" name="marcaId"></td>
			</tr>
			<tr>
				<td><label for="fecha">Fecha: </label></td>
				<td><input type="date" name="fecha"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Insertar Producto"></td>
				<td><input type="reset" value="Resetear Formulario"></td>
			</tr>
		</table>
	</form>

</body>
</html>