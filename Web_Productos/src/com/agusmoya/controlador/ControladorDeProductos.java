package com.agusmoya.controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.agusmoya.modelo.ModeloProductoBBDD;
import com.agusmoya.modelo.Producto;

/**
 * Servlet implementation class ControladorDeProductos
 */
@WebServlet("/ControladorDeProductos")
public class ControladorDeProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/PoolDeConexiones")
	DataSource miPool;

	ModeloProductoBBDD modeloProducto;

	@Override
	public void init() throws ServletException {
		super.init();
		modeloProducto = new ModeloProductoBBDD(miPool);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String input_hidden_instruccion = request.getParameter("instruccion");

		if (input_hidden_instruccion == null) {
			input_hidden_instruccion = "listar_productos";
		}

		switch (input_hidden_instruccion) {
		case "listar_productos":
			listarProductos(request, response);
			break;
		case "insertar_producto":
			insertarProductos(request, response);
			break;
		case "editar_producto":
			editarProducto(request, response);
			break;
		case "actualizar_producto":
			actualizarProducto(request, response);
			break;
		case "eliminar_producto":
			eliminarProducto(request, response);
			break;
		default:
			listarProductos(request, response);
			break;
		}

	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
		String idProdEliminar = request.getParameter("idProdEliminar");
		modeloProducto.eliminarProductoBBDD(idProdEliminar);

		listarProductos(request, response);
	}

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) {

		int idProd = Integer.parseInt(request.getParameter("idProdActualizar"));
		String name = request.getParameter("nombre");
		String description = request.getParameter("descripcion");
		double price = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("precio"));
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int trademarkId = Integer.parseInt(request.getParameter("trademarkId"));

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate = null;

		try {
			utilDate = formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Producto p = new Producto(name, description, idProd, stock, categoryId, trademarkId, price, utilDate);
		modeloProducto.actualizarProductoBBDD(p);

		listarProductos(request, response);
	}

	private void editarProducto(HttpServletRequest request, HttpServletResponse response) {
		Producto prodEditar = null;
		String idProdEditar = request.getParameter("idProdEditar");
		try {
			prodEditar = modeloProducto.getProducto(idProdEditar);

			request.setAttribute("prodAeditar", prodEditar);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/VistaEditarProducto.jsp");

			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void insertarProductos(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("nombre");
		String description = request.getParameter("descripcion");
		double price = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int categoryId = Integer.parseInt(request.getParameter("categoriaId"));
		int trademarkId = Integer.parseInt(request.getParameter("marcaId"));

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate = null;

		try {
			utilDate = formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Producto p = new Producto(name, description, stock, categoryId, trademarkId, price, utilDate);

		modeloProducto.insertar_productoBBDD(p);

		listarProductos(request, response);

	}

	private void listarProductos(HttpServletRequest request, HttpServletResponse response) {

		List<Producto> productos = modeloProducto.getProductos();

		request.setAttribute("listaDeProductos", productos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/VistaListaProductos.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
