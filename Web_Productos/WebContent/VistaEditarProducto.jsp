<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Editar Producto</h1>
	<form action="ControladorDeProductos" method="get">
		<input type="hidden" name="instruccion" value="actualizar_producto">
		<input type="hidden" name="idProdActualizar" value="${prodAeditar.id}">
		<input type="hidden" name="categoryId" value="${prodAeditar.categoryId}">
		<input type="hidden" name="trademarkId" value="${prodAeditar.trademarkId}">
		
		<table>
			<tr>
				<td><label for="nombre">Nombre: </label></td>
				<td><input type="text" name="nombre"
					value="${prodAeditar.name}"></td>
			</tr>
			<tr>
				<td><label for="descripcion">Descripcion: </label></td>
				<td><input type="text" name="descripcion"
					value="${prodAeditar.description}"></td>
			</tr>
			<tr>
				<td><label for="precio">Precio: </label></td>
				<td><input type="number" name="precio"
					value="${prodAeditar.price}"></td>
			</tr>
			<tr>
				<td><label for="stock">Stock: </label></td>
				<td><input type="number" name="stock"
					value="${prodAeditar.stock}"></td>
			</tr>
			<%-- 			<tr>
				<td><label for="categoriaId">Categoria ID: </label></td>
				<td><input type="number" name="categoriaId"
					value="${prodAeditar.categoryId}"></td>
			</tr>
			<tr>
				<td><label for="marcaId">Marca ID: </label></td>
				<td><input type="number" name="marcaId"
					value="${prodAeditar.trademarkId}"></td>
			</tr> --%>
			<tr>
				<td><label for="fecha">Fecha: </label></td>
				<td><input type="date" name="fecha"
					value="${prodAeditar.created_at}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Actualizar Producto"></td>
				<td><input type="reset" value="Resetear Formulario"></td>
			</tr>
		</table>
	</form>

</body>
</html>