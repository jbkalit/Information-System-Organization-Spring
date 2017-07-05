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
@Table(name="programkerja")
public class ProgramKerja {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idprogramkerja")
	private int idprogramkerja;	

	@Column(name="id_organisasi")
	private String id_organisasi;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pengurus")
	private Pengurus pengurus;
	
	@OneToMany(mappedBy = "programkerja")
    private Set<Proposal> proposal;
	
	@Column(name="judul")
	private String judul;

	@Column(name="jenis_program_kerja")
	private String jenis_program_kerja;

	
	@Column(name="deskripsi")
	private String deskripsi;
	
	@Column(name="date_upload")
	private String date_upload;

	

	public int getIdprogramkerja() {
		return idprogramkerja;
	}

	public void setIdprogramkerja(int idprogramkerja) {
		this.idprogramkerja = idprogramkerja;
	}

	public String getId_organisasi() {
		return id_organisasi;
	}

	public void setId_organisasi(String id_organisasi) {
		this.id_organisasi = id_organisasi;
	}

	public Pengurus getPengurus() {
		return pengurus;
	}

	public void setPengurus(Pengurus pengurus) {
		this.pengurus = pengurus;
	}

	public Set<Proposal> getProposal() {
		return proposal;
	}

	public void setProposal(Set<Proposal> proposal) {
		this.proposal = proposal;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getDate_upload() {
		return date_upload;
	}

	public void setDate_upload(String date_upload) {
		this.date_upload = date_upload;
	}

	public String getJenis_program_kerja() {
		return jenis_program_kerja;
	}

	public void setJenis_program_kerja(String jenis_program_kerja) {
		this.jenis_program_kerja = jenis_program_kerja;
	}

	
	
	
}
