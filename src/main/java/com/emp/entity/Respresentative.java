package com.emp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Respresentative {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String empName;

	@ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
	private Manager manager;
}
