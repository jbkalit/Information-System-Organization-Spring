package com.sibem.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sibem.models.ProgramKerja;
import com.sibem.repositories.ProgramKerjaRepo;

@Service
public class ProgramKerjaServiceImpl implements ProgramKerjaService {

	@Autowired
	private ProgramKerjaRepo PKRepo;
	
	@Override
	public void save(ProgramKerja programkerja) {
		PKRepo.save(programkerja);
	}

	@Override
	public List<ProgramKerja> getAllProgramKerja() {
		return PKRepo.findAll();
	}


	@Override
	public ProgramKerja findProgramKerjaById(int id) {	
		return PKRepo.findOne(id);
	}
	
	

}
