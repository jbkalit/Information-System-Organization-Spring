package com.sibem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibem.models.Prodi;
import com.sibem.repositories.ProdiRepo;

@Service	
public class ProdiServiceImpl implements ProdiService {

	@Autowired
	private ProdiRepo pr;
	
	@Override
	public void save(Prodi prodi) {
		pr.save(prodi);
	}

	@Override
	public Prodi findProdiById(String id) {
		return pr.findOne(id);
	}

	@Override
	public List<Prodi> getAllProdi() {
		return pr.findAll();
	}

}
