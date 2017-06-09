package com.app.sum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.sum.model.LoaiMatHang;

public interface LoaiMatHangRepository extends MongoRepository<LoaiMatHang, String> {
	
	@Query("{maLoai : ?0}")
	public LoaiMatHang findByMaLoai(String maLoai);
	
}
