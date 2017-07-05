package com.sibem.models;

import java.sql.Date;
import java.time.DateTimeException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="pengumuman")
public class Pengumuman {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pengumuman")
	private int id_pengumuman;
	
	
	@Column(name="date_update")
	private String date_update;
	
	@DateTimeFormat
	@Column(name="date_upload")
	private String date_upload;
	
	@Column(name="date_expired")
	private String date_expired;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pengurus")
	private Pengurus pengurus;

	@Column(name="deskripsi")
	private String deskripsi;
	
	@Column(name="file")
	private String file;
	
	@Column(name="link")
	private String link;
	
	@Column(name="judul")
	private String judul;

	@Column(name="status")
	private String status;
	
	@Column(name="viewer")
	private int viewer;
	
	public int getId_pengumuman() {
		return id_pengumuman;
	}

	public void setId_pengumuman(int id_pengumuman) {
		this.id_pengumuman = id_pengumuman;
	}

	
	public String getDate_update() {
		return date_update;
	}

	public void setDate_update(String date_update) {
		this.date_update = date_update;
	}

	public String getDate_upload() {
		return date_upload;
	}

	public void setDate_upload(String date_upload) {
		this.date_upload = date_upload;
	}

	public String getDate_expired() {
		return date_expired;
	}

	public void setDate_expired(String date_expired) {
		this.date_expired = date_expired;
	}

	public Pengurus getPengurus() {
		return pengurus;
	}

	public void setPengurus(Pengurus pengurus) {
		this.pengurus = pengurus;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getViewer() {
		return viewer;
	}

	public void setViewer(int viewer) {
		this.viewer = viewer;
	}
	
	
}
