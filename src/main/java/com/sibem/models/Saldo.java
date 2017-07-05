package com.sibem.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="saldo")
public class Saldo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_saldo")
	private int id_saldo;
	
	@Column(name="total_saldo")
	private float total_saldo;
	
	@Column(name="pemasukan")
	private float pemasukan;
	
	@Column(name="pengeluaran")
	private float pengeluaran;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idlaporanpengeluaran")
	private LaporanKeuangan laporankeuangan;
	
	@Column(name="tanggal_masuk")
	private String tanggal_masuk;

	
	public int getId_saldo() {
		return id_saldo;
	}

	public void setId_saldo(int id_saldo) {
		this.id_saldo = id_saldo;
	}

	public float getTotal_saldo() {
		return total_saldo;
	}

	public void setTotal_saldo(float total_saldo) {
		this.total_saldo = total_saldo;
	}

	public float getPemasukan() {
		return pemasukan;
	}

	public void setPemasukan(float pemasukan) {
		this.pemasukan = pemasukan;
	}

	public float getPengeluaran() {
		return pengeluaran;
	}

	public void setPengeluaran(float pengeluaran) {
		this.pengeluaran = pengeluaran;
	}

	public String getTanggal_masuk() {
		return tanggal_masuk;
	}

	public void setTanggal_masuk(String tanggal_masuk) {
		this.tanggal_masuk = tanggal_masuk;
	}

	public LaporanKeuangan getLaporankeuangan() {
		return laporankeuangan;
	}

	public void setLaporankeuangan(LaporanKeuangan laporankeuangan) {
		this.laporankeuangan = laporankeuangan;
	}

	
	
	
	
}
