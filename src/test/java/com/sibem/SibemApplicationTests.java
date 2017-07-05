package com.sibem;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sibem.models.Mahasiswa;
import com.sibem.services.MahasiswaService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SibemApplicationTests {

	@Autowired
	MahasiswaService mahasiswaService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getAllMahasiswa()
	{
		List<Mahasiswa> mahasiswas = mahasiswaService.getAllMahasiswa();
		System.out.println(mahasiswas.size());
		for (Mahasiswa mahasiswa : mahasiswas) {
			System.out.println("=============================");
			System.out.println("Nama \t:"+mahasiswa.getFullname());
			System.out.println("Role Null? \t:"+(mahasiswa.getRole()== null));
			System.out.println("Role \t:"+mahasiswa.toString());
			System.out.println("=============================");
		}
	}
}
