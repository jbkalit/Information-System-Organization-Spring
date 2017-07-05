package com.sibem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sibem.models.Proposal;

@Repository
public interface ProposalRepo extends JpaRepository<Proposal, Integer>{
	
	List<Proposal> findByProgramkerjaIdprogramkerja(int id);
	  	
}
