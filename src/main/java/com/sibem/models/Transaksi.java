package com.sibem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaksi")
public class Transaksi {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_transaksi")
	private int id_transaksi;
	
	private String bulan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prodi")
	private Prodi prodi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_laporan_keuangan")
	private LaporanKeuangan laporankeuangan;
	
	private int total_iuran;
	
	private int iuran;
	
	private int dibayarkan;
	
	private String komentar;
	
	private String status;

	
	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	
	public int getId_transaksi() {
		return id_transaksi;
	}

	public void setId_transaksi(int id_transaksi) {
		this.id_transaksi = id_transaksi;
	}

	public String getBulan() {
		return bulan;
	}

	public void setBulan(String bulan) {
		this.bulan = bulan;
	}


	public Prodi getProdi() {
		return prodi;
	}

	public void setProdi(Prodi prodi) {
		this.prodi = prodi;
	}


	public int getTotal_iuran() {
		return total_iuran;
	}

	public void setTotal_iuran(int total_iuran) {
		this.total_iuran = total_iuran;
	}

	public int getIuran() {
		return iuran;
	}

	public void setIuran(int iuran) {
		this.iuran = iuran;
	}

	public int getDibayarkan() {
		return dibayarkan;
	}

	public void setDibayarkan(int dibayarkan) {
		this.dibayarkan = dibayarkan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LaporanKeuangan getLaporankeuangan() {
		return laporankeuangan;
	}

	public void setLaporankeuangan(LaporanKeuangan laporankeuangan) {
		this.laporankeuangan = laporankeuangan;
	}
	
	
}
