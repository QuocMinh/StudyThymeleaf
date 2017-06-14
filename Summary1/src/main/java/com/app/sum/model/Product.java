package com.app.sum.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Product {
	
	@Id
	private String productId;
	
	private String productName;
	private String category;
	private String unit;
	private float volume;
	private String describe;
	
	@DBRef
	private UnitPrice unitPrice;
	
	public Product() {
		super();
	}

	public Product(String productId, String productName, String category,
			String unit, float volume, String describe, UnitPrice unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.unit = unit;
		this.volume = volume;
		this.describe = describe;
		this.unitPrice = unitPrice;
	}

	public Product(String productName, String category, String unit,
			float volume, String describe, UnitPrice unitPrice) {
		super();
		this.productName = productName;
		this.category = category;
		this.unit = unit;
		this.volume = volume;
		this.describe = describe;
		this.unitPrice = unitPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public UnitPrice getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(UnitPrice unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", category=" + category + ", unit=" + unit
				+ ", volume=" + volume + ", describe=" + describe
				+ ", unitPrice=" + unitPrice + "]";
	}

}