package com.sibem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.sibem.models.LaporanKeuangan;
import com.sibem.models.Mahasiswa;
import com.sibem.models.ProgramKerja;


@Repository
public interface ProgramKerjaRepo extends JpaRepository<ProgramKerja ,Integer>{

}
	
