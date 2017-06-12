package com.app.sum.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.sum.dao.LoaiMatHangRepositoryCustom;
import com.app.sum.model.LoaiMatHang;

public interface LoaiMatHangRepository extends MongoRepository<LoaiMatHang, String>, LoaiMatHangRepositoryCustom {
	
	@Query("{maLoai : ?0}")
	public LoaiMatHang findByMaLoai(String maLoai);
	
	@Query("{'limit' : ?0}")
	public List<LoaiMatHang> get10LoaiMatHang(int start);
	
}
