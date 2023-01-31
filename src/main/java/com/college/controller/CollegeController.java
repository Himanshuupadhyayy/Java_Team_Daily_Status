package com.college.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.entity.College;
import com.college.service.CollegeService;

import lombok.extern.slf4j.Slf4j;


/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  CollegeController.java
*	Time :   	11:57:25 AM
*/

@RestController
@RequestMapping("/college")
@CrossOrigin("*")
@Slf4j
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	// add the college details
	@PostMapping("/addCollege")
	public College addCollege(@RequestBody College college){
		log.info("add college method is working at controller");
		College col=null;
		try {
		 col=this.collegeService.addCollege(college);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return col;
	}

	@GetMapping("/colleges")
	public List<College> getAllColleges(){
		log.info("get all college method is working at controller layer");
		return this.collegeService.getAllColleges();
	}
	
	
	
	// get the college by id
	@GetMapping("/{collegeId}")
	public ResponseEntity<?> getCollegeById(@PathVariable int collegeId){
		log.info("get college by id method is working at controller");
		College college=null;
		try {
		college=this.collegeService.getCollege(collegeId);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("having some excepetion");
		}
		return ResponseEntity.ok(college);
	}

	// delete college by id
	@DeleteMapping("/col/{collegeId}")
	public void deleteCollegeById(@PathVariable int collegeId) {
		log.info("delete college by id method is working at controller");
		this.collegeService.deleteCollege(collegeId);
	}

	// update college by id
	@PutMapping("/col/{collegeId}")
	public College updateCollege(@RequestBody College college) {
		log.info("update college method is working at controller");
		return this.collegeService.updateCollege(college);
	}

	
	
//	@PostMapping("/types")
//	public Type addType(@RequestBody Type type) {
//		log.info("add type of college working at controller");
//		return this.collegeService.addTypes(type);
//	}
//	
//	@GetMapping("/types")
//	public List<Type> getAllTypes() {
//		log.info("get all type of college method working at controller");
//	return this.collegeService.getAllTypes();
//	}
}