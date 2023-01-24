package com.emp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Department {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    private String deptName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Manager manager;

	@ManyToOne
    @JsonIgnore
	private Organization organization;

}
