package com.sibem.services;

import java.util.List;

import com.sibem.models.Prodi;

public interface ProdiService {
	
	void save(Prodi prodi);
    Prodi findProdiById(String id);    
    List<Prodi>getAllProdi();

}
