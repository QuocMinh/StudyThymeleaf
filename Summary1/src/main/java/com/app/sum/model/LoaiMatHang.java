package com.app.sum.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class LoaiMatHang {
	
	@Id
	private String id;
	
	@Indexed(unique=true, sparse=true)
	private String maLoai;
	private String tenLoai;
	private String moTa;
	
	public LoaiMatHang() {
		super();
	}

	public LoaiMatHang(String id, String maLoai, String tenLoai, String moTa) {
		super();
		this.id = id;
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.moTa = moTa;
	}

	public LoaiMatHang(String maLoai, String tenLoai, String moTa) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.moTa = moTa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}
