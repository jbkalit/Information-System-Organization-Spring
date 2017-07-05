package com.sibem.services;

import java.util.List;

import com.sibem.models.LaporanKeuangan;

public interface LaporanKeuanganService {

	void save(LaporanKeuangan lk);

    List<LaporanKeuangan> findAllLaporanKeuanganById(int id);
    
    List<LaporanKeuangan>getAllLaporanKeuangan();
    
    LaporanKeuangan findLaporanKeuanganById(int id);
 
}
