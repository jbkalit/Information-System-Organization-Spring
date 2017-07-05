package com.sibem.services;

import java.util.List;

import com.sibem.models.ProgramKerja;
import com.sibem.models.Proposal;

public interface ProposalService {

	void save(Proposal proposal);
   
    List<Proposal>getAllProposal();
    
    Proposal findProposalById(int id);
 
}
