package com.sibem.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sibem.models.ProgramKerja;
import com.sibem.models.Proposal;
import com.sibem.repositories.ProgramKerjaRepo;
import com.sibem.repositories.ProposalRepo;

@Service
public class ProposalServiceImpl implements ProposalService {

	@Autowired
	private ProposalRepo PRepo;
	
	@Override
	public void save(Proposal programkerja) {
		PRepo.save(programkerja);
	}

	@Override
	public List<Proposal> getAllProposal() {
		return PRepo.findAll();
	}


	@Override
	public Proposal findProposalById(int id) {	
		return PRepo.findOne(id);
	}
	
	

}
