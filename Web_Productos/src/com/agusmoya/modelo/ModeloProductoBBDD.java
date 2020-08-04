package com.agusmoya.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductoBBDD {

	private DataSource origenDatos;
	private Connection conexion;
	private Statement st;
	private PreparedStatement prepSt;
	private ResultSet rs;

	public ModeloProductoBBDD(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	public List<Producto> getProductos() {

		List<Producto> productos = new ArrayList<Producto>();

		try {
			conexion = origenDatos.getConnection();
			st = conexion.createStatement();
			/* rs = st.executeQuery("SELECT * FROM Products"); */
			rs = st.executeQuery("SELECT P.*, C.name AS cName, T.name AS tName FROM Products AS P "
					+ "INNER JOIN Trademarks AS T " + "ON P.trademarkId=T.id " + "INNER JOIN Categories AS C "
					+ "ON P.categoryId=C.id " + "ORDER BY P.id ASC");

			while (rs.next()) {
				productos.add(new Producto(rs.getString("name"), rs.getString("description"), rs.getString("cName"),
						rs.getString("tName"), rs.getInt("id"), rs.getInt("stock"), rs.getInt("categoryId"),
						rs.getInt("trademarkId"), rs.getDouble("price"), rs.getDate("created_at")));
				/*
				 * productos.add(new Producto(rs.getString("name"), rs.getString("description"),
				 * rs.getInt("id"), rs.getInt("stock"), rs.getInt("categoryId"),
				 * rs.getInt("trademarkId"), rs.getDouble("price"), rs.getDate("created_at")));
				 */
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return productos;

	}

	public void insertar_productoBBDD(Producto p) {

		try {
			conexion = origenDatos.getConnection();
			prepSt = conexion.prepareStatement(
					"INSERT INTO Products " + "(created_at, categoryId, trademarkId, name, description, stock, price) "
							+ "VALUES (?,?,?,?,?,?,?)");
			java.util.Date utilDate = p.getCreated_at();
			java.sql.Date sqlDate = new Date(utilDate.getTime());
			prepSt.setDate(1, sqlDate);
			prepSt.setInt(2, p.getCategoryId());
			prepSt.setInt(3, p.getTrademarkId());
			prepSt.setString(4, p.getName());
			prepSt.setString(5, p.getDescription());
			prepSt.setInt(6, p.getStock());
			prepSt.setDouble(7, p.getPrice());

			prepSt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conexion.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public Producto getProducto(String idProdEditar) throws Exception {
		Producto productoAeditar = null;

		conexion = origenDatos.getConnection();
		prepSt = conexion.prepareStatement("SELECT * FROM Products WHERE id=?");
		prepSt.setString(1, idProdEditar);
		rs = prepSt.executeQuery();

		if (rs.next()) {
			productoAeditar = new Producto(rs.getString("name"), rs.getString("description"), rs.getInt("id"),
					rs.getInt("stock"), rs.getInt("categoryId"), rs.getInt("trademarkId"), rs.getDouble("price"),
					rs.getDate("created_at"));
		} else {
			throw new Exception("No se encontró el producto solicitado");
		}

		conexion.close();
		prepSt.close();
		rs.close();

		return productoAeditar;
	}

	public void actualizarProductoBBDD(Producto prod) {

		try {
			conexion = origenDatos.getConnection();
			prepSt = conexion.prepareStatement(
					"UPDATE Products SET name=?,description=?,stock=?,price=?,created_at=? WHERE id=?");
			prepSt.setString(1, prod.getName());
			prepSt.setString(2, prod.getDescription());
			prepSt.setInt(3, prod.getStock());
			prepSt.setDouble(4, prod.getPrice());

			java.util.Date utilDate = prod.getCreated_at();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			prepSt.setDate(5, sqlDate);
			prepSt.setInt(6, prod.getId());

			prepSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void eliminarProductoBBDD(String idProdEliminar) {

		try {
			conexion = origenDatos.getConnection();
			prepSt = conexion.prepareStatement("DELETE FROM Products WHERE id=?");
			prepSt.setString(1, idProdEliminar);
			prepSt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
