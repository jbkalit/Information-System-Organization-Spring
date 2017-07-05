package com.sibem.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibem.models.LaporanKeuangan;

import com.sibem.repositories.LaporanKeuanganRepo;

@Service
public class LaporanKeuanganServiceImpl implements LaporanKeuanganService {

	@Autowired
	private LaporanKeuanganRepo LKRepo;
	
	@Override
	public void save(LaporanKeuangan laporankeuangan) {
		LKRepo.save(laporankeuangan);
	}

	@Override
	public List<LaporanKeuangan> getAllLaporanKeuangan() {
		return LKRepo.findAll();
	}
	@Override
	public List<LaporanKeuangan> findAllLaporanKeuanganById(int id) {
		return null;
	}

	@Override
	public LaporanKeuangan findLaporanKeuanganById(int id) {	
		return LKRepo.findOne(id);
	}
	
	

}
