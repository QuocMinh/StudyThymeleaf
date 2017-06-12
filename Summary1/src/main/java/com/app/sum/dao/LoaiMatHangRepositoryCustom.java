package com.app.sum.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.sum.model.LoaiMatHang;

public interface LoaiMatHangRepositoryCustom {
	
	Page<LoaiMatHang> findAllPageable(Pageable pageable);
	
	public LoaiMatHang printHello(LoaiMatHang loaiMH);

}
