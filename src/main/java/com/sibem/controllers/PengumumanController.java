package com.sibem.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sibem.models.Mahasiswa;
import com.sibem.models.Pengumuman;
import com.sibem.models.Pengurus;
import com.sibem.repositories.MahasiswaRepo;
import com.sibem.repositories.PengurusRepo;
import com.sibem.services.PengumumanService;
import com.sibem.services.PengurusService;

@Controller
public class PengumumanController {

	Mahasiswa mahasiswaAktif;
	
	@Autowired
	PengumumanService ps;
	
	@Autowired
	PengurusRepo pr;
	
	@Autowired
	PengurusService prs;
	
	@Autowired
	MahasiswaRepo mr;
	

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 dateFormat.setLenient(false);
	 webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	 }

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();
	
	@RequestMapping(value = "/create/pengumuman", method=RequestMethod.GET)
	String createPengumuman(@Valid Pengumuman pengumuman, Principal p){
		
		mahasiswaAktif = mr.findByNim(p.getName());
		System.out.println("NIM : "+mahasiswaAktif.getNim());
		System.out.println("WAKTU : "+dateFormat.format(date));
		System.out.println("ID PENGURUS : "+pr.findByMahasiswaNim(mahasiswaAktif.getNim()).getId_pengurus());
		return "/pengumuman/create-pengumuman";
	
	}
	
	@RequestMapping(value = "/lihat/pengumuman/{id}", method=RequestMethod.GET)
	String viewPengumuman(@PathVariable int id,@Valid Pengumuman pengumuman, Principal p,Model model){
		
		model.addAttribute("pengumuman", ps.findPengumumanById(id));
		return "/pengumuman/view-pengumuman";
	
	}
	
	@RequestMapping(value = "/list/pengumuman", method=RequestMethod.GET)
	String listPengumuman(@Valid Pengumuman pengumuman, Principal p,Model model){
		
		model.addAttribute("pengumuman", ps.getAllPengumuman());
		return "/pengumuman/list-pengumuman";
	
	}
	
	@RequestMapping(value = "/create/pengumuman", method=RequestMethod.POST)
	String createPengumuman(@Valid Pengumuman pengumuman,BindingResult bindingResult,@RequestParam("file") MultipartFile file,Pengurus pengurus, Model model, Mahasiswa mahasiswa){
		
		if (!file.isEmpty()) {
			pengumuman.setFile(file.getOriginalFilename());
			String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File("C:/Users/BOKVLT/Documents/workspace-sts-3.8.4.RELEASE/SIBEM/src/main/resources/static/file/pengumuman/"+name)));
				stream.write(bytes);
				stream.close();
				System.out.println(stream);
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
				
		System.out.println("ID PENGURUS : "+mahasiswaAktif.getNim());
		pengumuman.setPengurus(pr.findByMahasiswaNim(mahasiswaAktif.getNim()));
		pengumuman.setDate_upload(dateFormat.format(date));
		ps.save(pengumuman);
		return "redirect:/create/pengumuman";
	}
	
	
}
