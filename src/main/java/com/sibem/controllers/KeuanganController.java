package com.sibem.controllers;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.dialect.function.StandardAnsiSqlAggregationFunctions.SumFunction;
import org.hibernate.jpa.criteria.expression.function.AggregationFunction.SUM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jayway.jsonpath.internal.function.numeric.Sum;
import com.sibem.models.LaporanKeuangan;
import com.sibem.models.Mahasiswa;
import com.sibem.models.Saldo;
import com.sibem.models.Transaksi;
import com.sibem.repositories.MahasiswaRepo;
import com.sibem.repositories.PengurusRepo;
import com.sibem.repositories.TransaksiRepo;
import com.sibem.services.LaporanKeuanganService;
import com.sibem.services.ProdiService;
import com.sibem.services.SaldoService;
import com.sibem.services.TransaksiService;

@Controller
public class KeuanganController {

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
	MahasiswaRepo mr;
	
	Mahasiswa mahasiswaAktif;
	
	LaporanKeuangan lk;
	
	int idlk;
	
	float total_saldo;
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	
	@RequestMapping(value = "/view/iuran", method=RequestMethod.GET)
	String viewIuran(@Valid Transaksi transaksi, Model model, Principal p){
		mahasiswaAktif = mr.findByNim(p.getName());
		model.addAttribute("prd",ps.getAllProdi());
		model.addAttribute("trans",tr.findByProdiMahasiswaNim(mahasiswaAktif.getNim()));
		System.out.println("Role :"+mahasiswaAktif.getNim());
		return "/keuangan/view-iuran";
	}
	
	@RequestMapping(value = "/view/rekapitulasi", method=RequestMethod.GET)
	String viewKeuangan(@Valid Transaksi transaksi, Model model, Principal p){
		model.addAttribute("saldo",ss.getAllSaldo());
		return "/keuangan/keuangan-bem";
	}
	
	@RequestMapping(value = "/view/laporan/keuangan", method=RequestMethod.GET)
	String viewLaporanKeuangan(@Valid Transaksi transaksi, Model model, Principal p){
		mahasiswaAktif = mr.findByNim(p.getName());
		model.addAttribute("laporan_keuangan",new LaporanKeuangan());
		model.addAttribute("lapke",lks.getAllLaporanKeuangan());
		System.out.println("Role :"+mahasiswaAktif.getNim());
		return "/keuangan/view-laporan-keuangan";
	}
	
	@RequestMapping(value = "/save/laporan", method=RequestMethod.POST)
	String saveLaporanKeuangan(@Valid LaporanKeuangan laporan_keuangan, @Valid Transaksi transaksi, Model model, Principal p){
		laporan_keuangan.setTotal(transaksi.getTotal_iuran());
		laporan_keuangan.setPengurus(pr.findByMahasiswaNim(mahasiswaAktif.getNim()));
		lks.save(laporan_keuangan);
		return "redirect:/view/laporan/keuangan";
	}
	
	
	@RequestMapping(value = "/request/iuran/{id}")
	String requestIuran(@Valid Transaksi transaksi,@PathVariable int id,Transaksi trans,BindingResult bindingResult, Model model, Principal p){
		
		transaksi = ts.findTransaksiById(id);
		
		System.out.println("ID Transaksi :: "+transaksi.getId_transaksi());
		System.out.println("Dibayarkan :: "+transaksi.getTotal_iuran());
		
		trans = ts.findTransaksiById(id);
		trans.setDibayarkan(trans.getTotal_iuran());
		trans.setStatus("Waiting");
		ts.save(trans);
		return "redirect:/view/iuran";
	}
	
	@RequestMapping(value = "/create/iuran/{id}", method=RequestMethod.GET)
	String createIuran(@PathVariable int id, @Valid Transaksi transaksi, Model model){
		model.addAttribute("prd",ps.getAllProdi());
		lk = lks.findLaporanKeuanganById(id);
		idlk = id;

		model.addAttribute("trans",tr.findByLaporankeuanganIdlaporankeuangan(id));
		return "/keuangan/create-iuran";
	}
	
	@RequestMapping(value = "/create/iuran", method=RequestMethod.GET)
	String createIuran( @Valid Transaksi transaksi, Model model){
		model.addAttribute("prd",ps.getAllProdi());
		lk = lks.findLaporanKeuanganById(idlk);

		model.addAttribute("trans",tr.findByLaporankeuanganIdlaporankeuangan(idlk));
		return "/keuangan/create-iuran";
	}
	
	
	@RequestMapping(value = "/accept/iuran/{id}")
	String acceptIuran(@PathVariable int id,Saldo saldo,Transaksi transaksi, Model model){
		transaksi = ts.findTransaksiById(id);
		int idla = transaksi.getLaporankeuangan().getIdlaporankeuangan();
		
		saldo.setPemasukan(transaksi.getTotal_iuran());		
		saldo.setPengeluaran(0);
		
		//float saldosebelumnya = ss.getAllSaldo().get(ss.getAllSaldo().size() - 1).getTotal_saldo();
		
		if(ss.getAllSaldo().size() == 0){
			saldo.setTotal_saldo(transaksi.getTotal_iuran());
		}else if( ss.getAllSaldo().size() >= 1){
			float saldosebelumnya = ss.getAllSaldo().get(ss.getAllSaldo().size() - 1).getTotal_saldo();
			saldo.setTotal_saldo(transaksi.getTotal_iuran() + saldosebelumnya);
		}
		
		
	
		saldo.setLaporankeuangan(transaksi.getLaporankeuangan());
		saldo.setTanggal_masuk(df.format(date));
		transaksi.setStatus("Accepted");
		
			
			
		ss.save(saldo);
		return "redirect:/create/iuran/"+idla;
	}
	
	@RequestMapping(value = "/edit/iuran", method=RequestMethod.GET)
	String editIuran(@Valid Transaksi transaksi, Model model){
		model.addAttribute("prd",ps.getAllProdi());
		model.addAttribute("trans",ts.getAllTransaksi());
		return "/keuangan/edit-iuran";
	}
	
	@RequestMapping(value = "/create/iuran")
	String createIuran(@Valid Transaksi transaksi,BindingResult bindingResult, Model model, Principal p){
		System.out.println("Jumlah Anggota : "+ ps.findProdiById(transaksi.getProdi().getId_prodi()).getJumlah_anggota());
		transaksi.setTotal_iuran(ps.findProdiById(transaksi.getProdi().getId_prodi()).getJumlah_anggota() * transaksi.getIuran());
		transaksi.setBulan(lk.getTanggal());
		transaksi.setLaporankeuangan(lk);
		transaksi.setStatus("Request");
		ts.save(transaksi);
		return "redirect:/view/laporan/keuangan";
	}
	
	
}