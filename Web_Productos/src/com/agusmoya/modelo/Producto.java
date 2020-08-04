package com.agusmoya.modelo;

import java.util.Date;

public class Producto {

	private String name, description, categoryName, trademarkName;
	private int id, stock, categoryId, trademarkId;
	private double price;
	private Date created_at;

	public Producto(String name, String description, String categoryName, String trademarkName, int id, int stock,
			int categoryId, int trademarkId, double price, Date created_at) {
		this.name = name;
		this.description = description;
		this.categoryName = categoryName;
		this.trademarkName = trademarkName;
		this.id = id;
		this.stock = stock;
		this.categoryId = categoryId;
		this.trademarkId = trademarkId;
		this.price = price;
		this.created_at = created_at;
	}

	public Producto(String name, String description, int id, int stock, int categoryId, int trademarkId, double price,
			Date created_at) {
		this.name = name;
		this.description = description;
		this.id = id;
		this.stock = stock;
		this.categoryId = categoryId;
		this.trademarkId = trademarkId;
		this.price = price;
		this.created_at = created_at;
	}

	public Producto(String name, String description, int stock, int categoryId, int trademarkId, double price,
			Date created_at) {
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.categoryId = categoryId;
		this.trademarkId = trademarkId;
		this.price = price;
		this.created_at = created_at;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getTrademarkId() {
		return trademarkId;
	}

	public void setTrademarkId(int trademarkId) {
		this.trademarkId = trademarkId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTrademarkName() {
		return trademarkName;
	}

	public void setTrademarkName(String trademarkName) {
		this.trademarkName = trademarkName;
	}

}
