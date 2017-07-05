package com.sibem.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibem.models.Mahasiswa;
import com.sibem.repositories.MahasiswaRepo;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {

	@Autowired
	private MahasiswaRepo mr;
	
	@Override
	public Mahasiswa save(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		return mr.save(mahasiswa);
	}

	@Override
	public Mahasiswa findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mahasiswa> getAllMahasiswa() {
		return mr.findAll();
	}

	@Override
	public Mahasiswa getMahasiswaByNim(String nim) {
		List<Mahasiswa> allUser = getAllMahasiswa();
		Mahasiswa userFind = null;		
		for (Mahasiswa u : allUser) {
			if(u.getNim().equals(nim)){
				userFind = u;
				break;
			}
		}
		return userFind;
	}

	@Override
	public Mahasiswa findUserById(String id) {
		return mr.getOne(id);
	}

	@Override
	public Date convertDate(String date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Date result = null;
		
		
		try {
			Date dateConvert = df.parse(date);
			
			result = dateConvert;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return result;
	}

}
