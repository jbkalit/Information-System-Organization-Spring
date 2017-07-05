package com.sibem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.sibem.models.LaporanKeuangan;
import com.sibem.models.Mahasiswa;



@Repository
public interface LaporanKeuanganRepo extends JpaRepository<LaporanKeuangan ,Integer>{

}
	
