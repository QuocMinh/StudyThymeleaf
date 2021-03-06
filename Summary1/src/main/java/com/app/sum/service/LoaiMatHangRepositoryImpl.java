package com.app.sum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.app.sum.dao.LoaiMatHangRepositoryCustom;
import com.app.sum.model.LoaiMatHang;
import com.app.sum.repository.LoaiMatHangRepository;

public class LoaiMatHangRepositoryImpl implements LoaiMatHangRepositoryCustom {
	
	@Autowired
	MongoTemplate template;
	@Autowired
	LoaiMatHangRepository loaiMHRepo;
	
	@Override
	public LoaiMatHang printHello(LoaiMatHang loaiMH) {
		
		return null;
	}

	@Override
	public Page<LoaiMatHang> findAllPageable(Pageable pageable) {
		return loaiMHRepo.findAll(pageable);
	}

}