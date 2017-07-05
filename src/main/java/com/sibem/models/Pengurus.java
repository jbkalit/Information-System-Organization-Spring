package com.sibem.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="pengurus")
public class Pengurus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_pengurus")
    private Integer id_pengurus;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nim")
    private Mahasiswa mahasiswa;
	
	@OneToMany(mappedBy = "pengurus")
    private Set<ProgramKerja> programkerja;
	
	@OneToMany(mappedBy = "pengurus")
    private Set<Pengumuman> pengumuman;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jabatan")
    private Jabatan jabatan;
	
	
	public Integer getId_pengurus() {
		return id_pengurus;
	}

	public void setId_pengurus(Integer id_pengurus) {
		this.id_pengurus = id_pengurus;
	}

	public Mahasiswa getMahasiswa() {
		return mahasiswa;
	}

	public void setMahasiswa(Mahasiswa mahasiswa) {
		this.mahasiswa = mahasiswa;
	}

	public Set<ProgramKerja> getProgramkerja() {
		return programkerja;
	}

	public void setProgramkerja(Set<ProgramKerja> programkerja) {
		this.programkerja = programkerja;
	}

	public Set<Pengumuman> getPengumuman() {
		return pengumuman;
	}

	public void setPengumuman(Set<Pengumuman> pengumuman) {
		this.pengumuman = pengumuman;
	}

	public Jabatan getJabatan() {
		return jabatan;
	}

	public void setJabatan(Jabatan jabatan) {
		this.jabatan = jabatan;
	}
	
}
