package com.munna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munna.entity.Faculty;
import com.munna.repo.UserRepo;

@RestController
public class restController {
	
	@Autowired
	private UserRepo repo;
	
    @GetMapping("/facul")
    public List<Faculty> getAllFaculty() {
        return repo.findAll();
    }

    @GetMapping("/facul/{id}")
    public Optional<Faculty> getFacultyById(@PathVariable int id) {
        return repo.findById(id);
    }
    
	@PatchMapping("/updatesal/{sal}/{id}")
	public void updateFaculById(@PathVariable Double sal,@PathVariable Integer id)
	{
	int count=	repo.upFacById(sal, id);
	System.out.println("recurd update"+count);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delFaculById(@PathVariable Integer id)
	{
	int count=	repo.upDelById(id);
	System.out.println("recurd deleted"+count);
	}
	
	@PutMapping("/updateall/{id}")
	public Faculty updatefullrecord(@PathVariable Integer id)
	{
	   Faculty fac = repo.findById(id).get();
	     fac.setName("nayak");
	     fac.setDepartment("arts");
	     fac.setSalary(310000.00);
	     repo.save(fac);
	     
	     return fac;
	   
	}
}
