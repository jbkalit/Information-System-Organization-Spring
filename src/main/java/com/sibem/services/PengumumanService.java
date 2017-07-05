package com.sibem.services;

import java.util.List;

import com.sibem.models.Pengumuman;


public interface PengumumanService {

	Pengumuman save(Pengumuman pengumuman);

	Pengumuman findPengumumanById(int id);
    
    List<Pengumuman>getAllPengumuman();
    
    Pengumuman getPengumumanByJudul(String judul);
 
}
