package com.sibem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibem.models.Jabatan;
import com.sibem.models.Prodi;
import com.sibem.repositories.JabatanRepo;
import com.sibem.repositories.ProdiRepo;

@Service	
public class JabatanServiceImpl implements JabatanService {

	@Autowired
	private JabatanRepo jr;
	
	@Override
	public void save(Jabatan jabatan) {
		jr.save(jabatan);
	}

	@Override
	public Jabatan findJabatanById(int id) {
		return jr.findOne(id);
	}

	@Override
	public List<Jabatan> getAllJabatan() {
		return jr.findAll();
	}

}
