package com.sibem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sibem.models.Jabatan;
import com.sibem.models.Mahasiswa;
import com.sibem.models.Pengurus;
import com.sibem.models.Prodi;
import com.sibem.services.AuthService;
import com.sibem.services.JabatanService;
import com.sibem.services.MahasiswaService;
import com.sibem.services.PengurusService;
import com.sibem.services.ProdiService;

@Controller
public class AdminController {

	@Autowired
	AuthService authService;

	@Autowired
	MahasiswaService ms;
	
	@Autowired
	JabatanService js;
	
	@Autowired
	PengurusService pengsus;
	
	@Autowired
	ProdiService ps;
	
	@RequestMapping(value = "/create/mahasiswa", method = RequestMethod.GET)
	String adminTambahMahasiswa(Model model, @Valid Mahasiswa mahasiswa) {
		model.addAttribute("mahasiswa", mahasiswa);
		return "/admin/tambah-mahasiswa";
	}
	
	@RequestMapping(value = "/create/mahasiswa", method = RequestMethod.POST )
	String simpanMahasiswa(Model model, @Valid @ModelAttribute("mahasiswa") Mahasiswa mahasiswa) {
		ms.save(mahasiswa);
		return "redirect:/create/mahasiswa";
	}

	@RequestMapping(value = "/create/jabatan", method = RequestMethod.GET)
	String adminTambahJabatan(Model model) {
		model.addAttribute("jabatan", new Jabatan());
		return "/admin/tambah-jabatan";
	}
	
	@RequestMapping(value = "/create/jabatan", method = RequestMethod.POST)
	String simpanJabatan(Model model, @Valid @ModelAttribute("jabatan") Jabatan jabatan) {
		js.save(jabatan);
		return "redirect:/create/jabatan";
	}

	@RequestMapping(value = "/create/prodi", method = RequestMethod.GET)
	String adminTambahProdi(Model model) {
		model.addAttribute("prodi", new Prodi());
		return "/admin/tambah-prodi";
	}
	
	@RequestMapping(value = "/create/prodi", method = RequestMethod.POST)
	String simpanProdi(@Valid @ModelAttribute("prodi") Prodi prodi,Mahasiswa mahasiswa) {
		mahasiswa = ms.findUserById(prodi.getMahasiswa().getNim());
		mahasiswa.setRole("ROLE_BEKEL");
		ps.save(prodi);
		return "redirect:/create/prodi";
	}
	
	@RequestMapping(value = "/create/pengurus", method = RequestMethod.GET)
	String adminTambahPengurus(Model model) {
		model.addAttribute("pengurus", new Pengurus());
		return "/admin/tambah-pengurus";
	}
	
	@RequestMapping(value = "/create/pengurus", method = RequestMethod.POST)
	String simpanPengurus(@Valid @ModelAttribute("pengurus") Pengurus pengurus) {
		pengsus.save(pengurus);
		return "redirect:/create/pengurus";
	}
}
