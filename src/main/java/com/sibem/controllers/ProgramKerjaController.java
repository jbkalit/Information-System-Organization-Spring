package com.sibem.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;

import java.util.Calendar;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;

import javax.validation.Valid;

import org.apache.tomcat.jni.Local;
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

import com.sibem.models.LaporanKeuangan;
import com.sibem.models.Mahasiswa;
import com.sibem.models.ProgramKerja;
import com.sibem.models.Proposal;
import com.sibem.models.Saldo;
import com.sibem.models.Transaksi;
import com.sibem.repositories.MahasiswaRepo;
import com.sibem.repositories.PengurusRepo;
import com.sibem.repositories.ProposalRepo;
import com.sibem.repositories.TransaksiRepo;
import com.sibem.services.LaporanKeuanganService;
import com.sibem.services.ProdiService;
import com.sibem.services.ProgramKerjaService;
import com.sibem.services.ProposalService;
import com.sibem.services.SaldoService;
import com.sibem.services.TransaksiService;

@Controller
public class ProgramKerjaController {

	@Autowired
	TransaksiService ts;
	
	@Autowired
	TransaksiRepo tr;
	
	@Autowired
	ProdiService ps;
	
	@Autowired
	PengurusRepo pr;
	
	@Autowired
	SaldoService ss;
	
	@Autowired
	LaporanKeuanganService lks;
	
	@Autowired
	ProgramKerjaService pks;
	
	@Autowired
	ProposalService pps;

	@Autowired
	ProposalRepo ppr;
	
	@Autowired
	MahasiswaRepo mr;
	
	Mahasiswa mahasiswaAktif;
	
	ProgramKerja prokers;
	
	int idpropo;
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	DateFormat dateFormatMonth = new SimpleDateFormat("MM");
	

	 //Calendar c = Calendar.getInstance();
	int monthNumber = Integer.parseInt(dateFormatMonth.format(date));
	String bulan = Month.of(monthNumber).getDisplayName(TextStyle.FULL, new Locale("in", "ID"));
	
	@RequestMapping(value = "/create/proposal/{id}", method=RequestMethod.GET)
	String createProposal(@PathVariable int id, Model model, Principal p){
		prokers = pks.findProgramKerjaById(id);
		mahasiswaAktif = mr.findByNim(p.getName());
		idpropo = id;
		model.addAttribute("proposal", new Proposal());
		model.addAttribute("proposals",ppr.findByProgramkerjaIdprogramkerja(id));
		
		System.out.println("NIM :: "+mahasiswaAktif.getNim());
		return "/programkerja/tambah-proposal";
	}
	
	@RequestMapping(value = "/create/proposal",method=RequestMethod.POST)
	String createProposal(@Valid Proposal proposal,BindingResult bindingResult, @RequestParam("file") MultipartFile file){
		

		if (!file.isEmpty()) {
			proposal.setFile(file.getOriginalFilename());
			String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File("C:/Users/BOKVLT/Documents/workspace-sts-3.8.4.RELEASE/SIBEM/src/main/resources/static/file/"+name)));
				stream.write(bytes);
				stream.close();
				System.out.println(stream);
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}

		proposal.setStatus("Request");
		proposal.setDate_upload(dateFormat.format(date));
		proposal.setProgramkerja(prokers);
		pps.save(proposal);
		return "redirect:/create/program/kerja";
	}
	
	@RequestMapping(value = "/create/program/kerja",method=RequestMethod.POST)
	String createProgramKerja(@Valid ProgramKerja proker, Model model, Principal p){
		proker.setPengurus(pr.findByMahasiswaNim(mahasiswaAktif.getNim()));
		proker.setDate_upload(dateFormat.format(date));
		pks.save(proker);
		return "redirect:/create/program/kerja";
	}
	
	@RequestMapping(value = "/create/program/kerja", method=RequestMethod.GET)
	String createProgramKerja(@Valid Transaksi transaksi, Model model, Principal p){
		mahasiswaAktif = mr.findByNim(p.getName());
		model.addAttribute("proker", new ProgramKerja());
		model.addAttribute("prokers",pks.getAllProgramKerja()); //by siapa pengurus yang login
		System.out.println("NIM :: "+mahasiswaAktif.getNim());
		return "/programkerja/tambah-program-kerja";
	}
	
	@RequestMapping(value = "/lihat/program-kerja/{id}", method=RequestMethod.GET)
	String lihatProgramKerja(@PathVariable int id,@Valid Transaksi transaksi, Model model, Principal p){
		mahasiswaAktif = mr.findByNim(p.getName());
		model.addAttribute("proker", new ProgramKerja());
		model.addAttribute("prokers",pks.findProgramKerjaById(id));
		model.addAttribute("proposals",ppr.findByProgramkerjaIdprogramkerja(id));
		System.out.println("NIM :: "+mahasiswaAktif.getNim());
		
		
		return "/programkerja/lihat-program-kerja";
	}
	
	@RequestMapping(value = "/lihat/program-umum/{id}", method=RequestMethod.GET)
	String lihatProgramKerjaUmum(@PathVariable int id,@Valid Transaksi transaksi, Model model, Principal p){
		model.addAttribute("proker", new ProgramKerja());
		model.addAttribute("prokers",pks.findProgramKerjaById(id));
		model.addAttribute("proposals",ppr.findByProgramkerjaIdprogramkerja(id));
				
		return "/programkerja/lihat-program-umum";
	}
	
	@RequestMapping(value = "/lihat/proposal/{id}", method=RequestMethod.GET)
	String lihatProposal(@PathVariable int id,@Valid Transaksi transaksi, Model model, Principal p){
		mahasiswaAktif = mr.findByNim(p.getName());
		//model.addAttribute("proposals",ppr.findByProgramkerjaIdprogramkerja(id));
		model.addAttribute("pro",pps.findProposalById(id));
		System.out.println("NIM :: "+mahasiswaAktif.getNim());
		return "/programkerja/lihat-proposal";
	}
	
	
	@RequestMapping(value = "/semua/program-kerja", method=RequestMethod.GET)
	String semuaProgramKerja(@Valid Transaksi transaksi, Model model, Principal p){
		mahasiswaAktif = mr.findByNim(p.getName());
		model.addAttribute("proker", new ProgramKerja());
		model.addAttribute("prokers",pks.getAllProgramKerja());
		System.out.println("NIM :: "+mahasiswaAktif.getNim());
		
		System.out.println(bulan);
		return "/programkerja/semua-program-kerja";
	}
	

	@RequestMapping(value = "/semua/program-umum", method=RequestMethod.GET)
	String semuaProgramKerjaUmum(@Valid Transaksi transaksi, Model model, Principal p){
		model.addAttribute("proker", new ProgramKerja());
		model.addAttribute("prokers",pks.getAllProgramKerja());
		return "/programkerja/semua-program-umum";
	}
	
	@RequestMapping(value = "/terima/proposal/{id}")
	String terimaProposal(@Valid Transaksi transaksi,Saldo saldo,@Valid LaporanKeuangan lk,@PathVariable int id, Model model, Principal p){
		Proposal proposal = new Proposal();
		proposal = pps.findProposalById(id);	
		proposal.setStatus("Accepted");
		pps.save(proposal);
		
		lk.setDeskripsi("Pengeluaran dari Proposal "+proposal.getJudul());
		lk.setTanggal(bulan);
		lk.setTipe_laporan("Pengeluaran Proposal");
		lk.setPengurus(proposal.getProgramkerja().getPengurus());	
		lk.setTotal(proposal.getTotal_dana());
		lks.save(lk);
		
		saldo.setPengeluaran(proposal.getTotal_dana());
		saldo.setPemasukan(0);
		saldo.setTanggal_masuk(dateFormat.format(date));
		saldo.setLaporankeuangan(lk);;
		float totalsekarang = ss.getAllSaldo().get(ss.getAllSaldo().size() - 1 ).getTotal_saldo();
		saldo.setTotal_saldo(totalsekarang - proposal.getTotal_dana());

		
		ss.save(saldo);
	
		
		
		return "redirect:/semua/program-kerja";
	}
	@RequestMapping(value = "/tolak/proposal/{id}")
	String tolakProposal(@Valid Transaksi transaksi,@PathVariable int id, Model model, Principal p){
		Proposal proposal = new Proposal();
		
		proposal = pps.findProposalById(id);
		
		proposal.setStatus("Rejected");
		pps.save(proposal);
		return "redirect:/semua/program-kerja";
	}
}