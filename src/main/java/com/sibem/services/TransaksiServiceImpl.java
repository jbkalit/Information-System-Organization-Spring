package com.sibem.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibem.models.Transaksi;
import com.sibem.repositories.TransaksiRepo;

@Service
public class TransaksiServiceImpl implements TransaksiService {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private TransaksiRepo transRepo;
	
	@Override
	public void save(Transaksi transaksi) {
		transRepo.save(transaksi);
	}

	@Override
	public List<Transaksi> getAllTransaksi() {
		return transRepo.findAll();
	}
	@Override
	public List<Transaksi> findAllTransaksiById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("from Transaksi a Join   ="+ id, Transaksi.class).getResultList();
		
	}

	@Override
	public Transaksi findTransaksiById(int id) {	
		return transRepo.findOne(id);
	}
	
	

}
