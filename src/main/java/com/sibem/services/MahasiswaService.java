package com.sibem.services;

import java.util.Date;
import java.util.List;


import com.sibem.models.Mahasiswa;


public interface MahasiswaService {

	Mahasiswa save(Mahasiswa user);

    Mahasiswa findByUsername(String username);
        
    List<Mahasiswa>getAllMahasiswa();
    
    Mahasiswa getMahasiswaByNim(String username);
    
    Mahasiswa findUserById(String id);
    
    Date convertDate(String date);
	
}
