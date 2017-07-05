package com.sibem.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="prodi")
public class Prodi {

	@Id
	@Column(name="id_prodi")
	private String id_prodi;
	
	@Column(name="nama_prodi")
	private String nama_prodi;
	
	@Column(name="jumlah_anggota")
	private int jumlah_anggota;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nim")
    private Mahasiswa mahasiswa;

	@OneToMany(mappedBy = "prodi")
    private Set<Transaksi> transaksi;

	
	public String getId_prodi() {
		return id_prodi;
	}

	public void setId_prodi(String id_prodi) {
		this.id_prodi = id_prodi;
	}

	public Set<Transaksi> getTransaksi() {
		return transaksi;
	}

	public void setTransaksi(Set<Transaksi> transaksi) {
		this.transaksi = transaksi;
	}

	public String getNama_prodi() {
		return nama_prodi;
	}

	public void setNama_prodi(String nama_prodi) {
		this.nama_prodi = nama_prodi;
	}

	public int getJumlah_anggota() {
		return jumlah_anggota;
	}

	public void setJumlah_anggota(int jumlah_anggota) {
		this.jumlah_anggota = jumlah_anggota;
	}

	public Mahasiswa getMahasiswa() {
		return mahasiswa;
	}

	public void setMahasiswa(Mahasiswa mahasiswa) {
		this.mahasiswa = mahasiswa;
	}
	
	

}
