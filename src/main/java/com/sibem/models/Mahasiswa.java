package com.sibem.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="mahasiswa")
public class Mahasiswa {

	@Id
	@Column(name="nim", unique = true, nullable = false)
	private String nim;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="tanggallahir")
	private String tanggallahir;
	
	@Column(name="jeniskelamin")
	private String jeniskelamin;
	
	@Column(name="password")
	private String password;
	
	@Column(name="angkatan")
	private int angkatan;
	
	@Transient
	private String plainPassword;
	
	@Column(name="alamat")
	private String alamat;
	
	@Column(name="notlp")
	private String notlp;
	
	@Column(name="foto")
	private String foto;
	
	@Column(name="role")
	private String role;
	
	@Transient
	private String repeatPassword;
	
	@OneToOne(mappedBy = "mahasiswa",cascade = CascadeType.ALL)
    private Pengurus pengurus;

	@OneToOne(mappedBy = "mahasiswa",cascade = CascadeType.ALL)
    private Prodi prodi;


	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public Prodi getProdi() {
		return prodi;
	}

	public void setProdi(Prodi prodi) {
		this.prodi = prodi;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.password = new BCryptPasswordEncoder().encode(plainPassword);
		this.plainPassword = plainPassword;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getTanggallahir() {
		return tanggallahir;
	}

	public void setTanggallahir(String tanggallahir) {
		this.tanggallahir = tanggallahir;
	}

	public String getJeniskelamin() {
		return jeniskelamin;
	}

	public void setJeniskelamin(String jeniskelamin) {
		this.jeniskelamin = jeniskelamin;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNotlp() {
		return notlp;
	}

	public void setNotlp(String notlp) {
		this.notlp = notlp;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Pengurus getPengurus() {
		return pengurus;
	}

	public void setPengurus(Pengurus pengurus) {
		this.pengurus = pengurus;
	}

	public int getAngkatan() {
		return angkatan;
	}

	public void setAngkatan(int angkatan) {
		this.angkatan = angkatan;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	
}
