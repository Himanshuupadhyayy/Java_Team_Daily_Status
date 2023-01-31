package com.college.service;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.entity.College;
import com.college.repository.CollegeRepository;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  CollegeService.java
*	Time :   	11:56:26 AM
*/
@Service
@Slf4j
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;

	
	public College addCollege(College college)throws Exception{
		log.info("add college method is working at service layer");
		College local=null;
		
		Random random=new Random(10);
		System.out.println(random);
		local = this.collegeRepository.findByCollegeNameOrCollegeEmail(college.getCollegeName(),
				college.getCollegeEmail());
		if (local != null) {
			System.out.println("user is already have");
			//throw new CollegeFoundException("College is already registered with us !!");
		}
		return this.collegeRepository.save(college);
	
	}
	//get all colleges
	public List<College> getAllColleges() {
		log.info("get all college method is working at service layer");
		List<College> colleges=this.collegeRepository.findAll();
		return colleges;
	}

	// get college
	public College getCollege(int id) {
		log.info("get college by id method is working at service");
		return this.collegeRepository.findById(id).get();
	}

	// delete college
	public void deleteCollege(int id) {
		log.info("delete college by id method is working at service");
		this.collegeRepository.deleteById(id);
	}

	// update college
	public College updateCollege(College college) {
		log.info("update college details method is working at service");
		college.setCollegeId(college.getCollegeId());
		return this.collegeRepository.save(college);
	}
	
	//add type of college
//	public Type addTypes(Type type) {
//		log.info("add type method is working at service");
//		return this.typeRepository.save(type);
//	}
//
//	//get all the types
//	public List<Type> getAllTypes() {
//		log.info("get all type method is working at service");
//		return this.typeRepository.findAll();
//	}

	

}