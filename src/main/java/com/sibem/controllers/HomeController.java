package com.sibem.controllers;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sibem.models.Saldo;
import com.sibem.repositories.MahasiswaRepo;
import com.sibem.services.MahasiswaService;
import com.sibem.services.PengumumanService;
import com.sibem.services.SaldoService;


@Controller
public class HomeController {

	@Autowired
	PengumumanService ps;
	
	@Autowired
	MahasiswaService ms;
	
	@Autowired
	SaldoService ss;
	
	
	@Autowired
	MahasiswaRepo mr;
	
	float total_saldo;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(Model model){  
		
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		System.out.println(df.format(date)); //2016/11/16 12:08:43
		model.addAttribute("pengumuman",ps.getAllPengumuman());		
		model.addAttribute("ultah",mr.findByTanggallahir(df.format(date)));		
		date = ms.convertDate(df.format(date));	
		System.out.println("YEAR : "+ms.convertDate(mr.findByNim("iss14029").getTanggallahir()));
		
		

		
		return "home";
		
    }
	
	@RequestMapping(value = {"/tentang-bem"}, method = RequestMethod.GET)
    public String kominfo(Model model,Principal p){    	    	
    
    	return "profilBEM";
    }
	
	@RequestMapping(value = {"/create/keuangan"}, method = RequestMethod.GET)
    public String createKeuangan(Model model,Principal p){    	    	
    
    	return "/keuangan/createLaporanKeuangan";
    }
	
	@RequestMapping(value = {"/view/list/keuangan"}, method = RequestMethod.GET)
    public String viewListKeuangan(Model model,Principal p){    	    	
    
    	return "/keuangan/viewListKeuangan";
    }
	
	@RequestMapping(value = {"/view/keuangan"}, method = RequestMethod.GET)
    public String viewKeuangan(Model model,Principal p){    	    	
    
    	return "/keuangan/viewLaporanKeuangan";
    }
	
	@RequestMapping(value = {"/view/profil/bem"}, method = RequestMethod.GET)
    public String profilBEM(Model model,Principal p){    	    	
    
    	return "profilBEM";
    }
	
	
}
