package com.sibem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sibem.models.Mahasiswa;
import com.sibem.models.Pengumuman;
import com.sibem.repositories.MahasiswaRepo;
import com.sibem.repositories.PengumumanRepo;

@Service
public class PengumumanServiceImpl implements PengumumanService {

	@Autowired
	private MahasiswaRepo ur;
	
	@Autowired
	private PengumumanRepo pr;
	

	@Override
	public Pengumuman save(Pengumuman pengumuman) {
		return pr.save(pengumuman);
	}

	@Override
	public Pengumuman findPengumumanById(int id) {
		return pr.getOne(id);
	}

	@Override
	public List<Pengumuman> getAllPengumuman() {
		return pr.findAll();
	}
	
	 private Sort sortByIdAsc() {
	        return new Sort(Sort.Direction.ASC,"id_pengumuman");
	 }

	@Override
	public Pengumuman getPengumumanByJudul(String judul) {
		// TODO Auto-generated method stub
		return null;
	}

}
