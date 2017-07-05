package com.sibem.models;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="jabatan")
public class Jabatan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_jabatan")
	private long id_jabatan;
	
	
	@Column(name="nama_jabatan")
	private String nama_jabatan;
	
	@Column(name="masa_jabatan")
	private String masa_jabatan;
	

	@OneToOne(mappedBy = "jabatan",cascade = CascadeType.ALL)
    private Pengurus pengurus;
	
	
	public long getId_jabatan() {
		return id_jabatan;
	}

	public void setId_jabatan(long id_jabatan) {
		this.id_jabatan = id_jabatan;
	}

	public String getNama_jabatan() {
		return nama_jabatan;
	}

	public void setNama_jabatan(String nama_jabatan) {
		this.nama_jabatan = nama_jabatan;
	}

	public String getMasa_jabatan() {
		return masa_jabatan;
	}

	public void setMasa_jabatan(String masa_jabatan) {
		this.masa_jabatan = masa_jabatan;
	}


	public Pengurus getPengurus() {
		return pengurus;
	}

	public void setPengurus(Pengurus pengurus) {
		this.pengurus = pengurus;
	}
	
	
	
}
