package com.sibem.models;

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
import com.sibem.models.Transaksi;

@Entity
@Table(name="laporan_keuangan")
public class LaporanKeuangan {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idlaporankeuangan")
	private int idlaporankeuangan;
	
	private String deskripsi;
	
	private String tanggal;
	
	private String tipe_laporan;
	
	private long total;
	
	@OneToMany(mappedBy = "laporankeuangan")
    private Set<Transaksi> transaksi;
	
	@OneToMany(mappedBy = "laporankeuangan")
    private Set<Saldo> saldo;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pengurus")
	private Pengurus pengurus;

	
	public int getIdlaporankeuangan() {
		return idlaporankeuangan;
	}

	public void setIdlaporankeuangan(int idlaporankeuangan) {
		this.idlaporankeuangan = idlaporankeuangan;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getTipe_laporan() {
		return tipe_laporan;
	}

	public void setTipe_laporan(String tipe_laporan) {
		this.tipe_laporan = tipe_laporan;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Pengurus getPengurus() {
		return pengurus;
	}

	public void setPengurus(Pengurus pengurus) {
		this.pengurus = pengurus;
	}

	public Set<Transaksi> getTransaksi() {
		return transaksi;
	}

	public void setTransaksi(Set<Transaksi> transaksi) {
		this.transaksi = transaksi;
	}

	public Set<Saldo> getSaldo() {
		return saldo;
	}

	public void setSaldo(Set<Saldo> saldo) {
		this.saldo = saldo;
	}

	
}
