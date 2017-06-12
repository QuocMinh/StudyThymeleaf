package com.app.sum.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.app.sum.model.LoaiMatHang;
import com.app.sum.repository.LoaiMatHangRepository;

public class LoaiMatHangRepositoryImpl implements LoaiMatHangRepositoryCustom {
	
	@Autowired
	MongoTemplate template;
	@Autowired
	LoaiMatHangRepository loaiMHRepo;
	
//	public LoaiMatHangRepositoryImpl(LoaiMatHangRepository loaiMHRepo) {
//		this.loaiMHRepo = loaiMHRepo;
//	}

	@Override
	public LoaiMatHang printHello(LoaiMatHang loaiMH) {
		
		return null;
	}

	@Override
	public Page<LoaiMatHang> findAllPageable(Pageable pageable) {
		return loaiMHRepo.findAll(pageable);
	}

}
