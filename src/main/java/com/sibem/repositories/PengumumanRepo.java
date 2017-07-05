package com.sibem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sibem.models.Pengumuman;

@Repository
public interface PengumumanRepo extends JpaRepository<Pengumuman, Integer>{
	
}
	
