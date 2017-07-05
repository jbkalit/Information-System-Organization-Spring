package com.sibem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibem.models.Mahasiswa;
import com.sibem.models.Pengumuman;
import com.sibem.models.Pengurus;
import com.sibem.repositories.MahasiswaRepo;
import com.sibem.repositories.PengumumanRepo;
import com.sibem.repositories.PengurusRepo;

@Service
public class PengurusServiceImpl implements PengurusService {

	@Autowired
	private PengurusRepo pr;

	
	@Override
	public Pengurus save(Pengurus pengurus) {
		return pr.save(pengurus);
	}

	@Override
	public Pengurus findByNim(String nim) {
		return null;
	}

	@Override
	public List<Pengurus> getAllPengurus() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Pengurus findPengurusById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
