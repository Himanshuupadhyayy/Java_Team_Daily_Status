package com.emp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Manager {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerId;
    private String managerName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="manager")
    private List<Respresentative> respresentatives;
	
	

}
