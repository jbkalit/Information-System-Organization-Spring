package com.sibem.services;

import java.util.List;


import com.sibem.models.Mahasiswa;
import com.sibem.models.Pengurus;


public interface PengurusService {

	Pengurus save(Pengurus pengurus);

	Pengurus findByNim(String nim);
    
    List<Pengurus>getAllPengurus();
        
    Pengurus findPengurusById(Integer id);
	
}
