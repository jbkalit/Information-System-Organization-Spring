package com.sibem.models;

import java.sql.Date;

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
@Table(name="proposal")
public class Proposal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idproposal")
	private int idproposal;	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_program_kerja")
	private ProgramKerja programkerja;
	
	@Column(name="judul")
	private String judul;

	@Column(name="deskripsi")
	private String deskripsi;
	
	@Column(name="date_upload")
	private String date_upload;
	
	@Column(name="status")
	private String status;
	
	@Column(name="file")
	private String file;

	@Column(name="total_dana")
	private int total_dana;
	
	
	public int getTotal_dana() {
		return total_dana;
	}

	public void setTotal_dana(int total_dana) {
		this.total_dana = total_dana;
	}

	
	public int getIdproposal() {
		return idproposal;
	}

	public void setIdproposal(int idproposal) {
		this.idproposal = idproposal;
	}

	public ProgramKerja getProgramkerja() {
		return programkerja;
	}

	public void setProgramkerja(ProgramKerja programkerja) {
		this.programkerja = programkerja;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	
	
}
