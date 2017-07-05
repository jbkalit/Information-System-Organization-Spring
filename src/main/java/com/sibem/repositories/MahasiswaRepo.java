package com.sibem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.sibem.models.Mahasiswa;



@Repository
public interface MahasiswaRepo extends JpaRepository<Mahasiswa, String>{
	Mahasiswa findByNim(String nim);
	
	List<Mahasiswa> findByTanggallahir(String birthdate);

}
	
