<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Lista de Productos Disponibles</h1>

	<table style="text-align: center">
		<tr>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Categoria ID</th>
			<th>Categoria Nombre</th>
			<th>Marca ID</th>
			<th>Marca Nombre</th>
			<th>Fecha</th>
			<th>Actualizar</th>
			<th>Eliminar</th>
		</tr>

		<c:forEach var="producto" items="${listaDeProductos}">

			<c:url var="linkEdicionProducto" value="ControladorDeProductos">
				<c:param name="instruccion" value="editar_producto"></c:param>
				<c:param name="idProdEditar" value="${producto.id}"></c:param>
			</c:url>

			<c:url var="linkEliminarProducto" value="ControladorDeProductos">
				<c:param name="instruccion" value="eliminar_producto"></c:param>
				<c:param name="idProdEliminar" value="${producto.id}"></c:param>
			</c:url>
			<tr>
				<td>${producto.name}</td>
				<td>${producto.description}</td>
				<td>${producto.price}</td>
				<td>${producto.stock}</td>
				<td>${producto.categoryId}</td>
				<td>${producto.categoryName}</td>
				<td>${producto.trademarkId}</td>
				<td>${producto.trademarkName}</td>
				<td>${producto.created_at}</td>
				<td><a href="${linkEdicionProducto}"> Editar</a></td>
				<td><a href="${linkEliminarProducto}"> Eliminar</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td><input type="submit" value="Insertar Producto"
				onclick="window.location.href='VistaInsertarProducto.jsp'"></td>
		</tr>

	</table>

</body>
</html>