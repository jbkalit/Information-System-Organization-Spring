package com.sibem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sibem.models.Transaksi;

@Repository
public interface TransaksiRepo extends JpaRepository<Transaksi, Integer> {
	//Transaksi findTransaksiByProdiMahasiswaNim(String id);
	List<Transaksi> findByProdiMahasiswaNim(String id);
	List<Transaksi> findByBulan(String bulan);
	List<Transaksi> findByLaporankeuanganIdlaporankeuangan(int id);
}
