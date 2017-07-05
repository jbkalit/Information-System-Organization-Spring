package com.sibem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sibem.models.Pengurus;

public interface PengurusRepo extends JpaRepository<Pengurus, Integer>{
	Pengurus findByMahasiswaNim(String nim);
}
