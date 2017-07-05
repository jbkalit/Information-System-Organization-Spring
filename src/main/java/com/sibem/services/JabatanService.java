package com.sibem.services;

import java.util.List;

import com.sibem.models.Jabatan;

public interface JabatanService {
	
	void save(Jabatan jabatan);
    Jabatan findJabatanById(int id);    
    List<Jabatan>getAllJabatan();

}
