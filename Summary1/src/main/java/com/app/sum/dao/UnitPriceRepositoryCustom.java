package com.app.sum.dao;

import com.app.sum.model.UnitPrice;

public interface UnitPriceRepositoryCustom {
	
	public UnitPrice findByCustomerType(String customerType);

}
