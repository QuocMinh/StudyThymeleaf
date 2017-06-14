package com.app.sum.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "unitPrices")
public class UnitPrice {
	
	@Id
	private String uniPriceId;
	
	@DBRef
	private CustomerType customerTypeId;
	private long price;
	private String decription;
	
	public UnitPrice() {
		super();
	}

	public UnitPrice(String uniPriceId, CustomerType customerTypeId,
			long price, String decription) {
		super();
		this.uniPriceId = uniPriceId;
		this.customerTypeId = customerTypeId;
		this.price = price;
		this.decription = decription;
	}

	public UnitPrice(CustomerType customerTypeId, long price, String decription) {
		super();
		this.customerTypeId = customerTypeId;
		this.price = price;
		this.decription = decription;
	}

	public String getUniPriceId() {
		return uniPriceId;
	}

	public void setUniPriceId(String uniPriceId) {
		this.uniPriceId = uniPriceId;
	}

	public CustomerType getCustomerTypeId() {
		return customerTypeId;
	}

	public void setCustomerTypeId(CustomerType customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	@Override
	public String toString() {
		return "UnitPrice [uniPriceId=" + uniPriceId + ", customerTypeId="
				+ customerTypeId + ", price=" + price + ", decription="
				+ decription + "]";
	}
	
}
