package com.app.sum.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class MatHang {
	
	@Id
	private String id;
	
	@Indexed(unique=true)
	private String maMH;
	@DBRef
	private LoaiMatHang loaiMH;
	private String tenMH;
	private long donGia;
	private int soLuong;
	
	public MatHang() {
		super();
	}

	public MatHang(String id, String maMH, LoaiMatHang loaiMH, String tenMH,
			long donGia, int soLuong) {
		super();
		this.id = id;
		this.maMH = maMH;
		this.loaiMH = loaiMH;
		this.tenMH = tenMH;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public MatHang(String maMH, LoaiMatHang loaiMH, String tenMH, long donGia,
			int soLuong) {
		super();
		this.maMH = maMH;
		this.loaiMH = loaiMH;
		this.tenMH = tenMH;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public LoaiMatHang getLoaiMH() {
		return loaiMH;
	}

	public void setLoaiMH(LoaiMatHang loaiMH) {
		this.loaiMH = loaiMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public long getDonGia() {
		return donGia;
	}

	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}
