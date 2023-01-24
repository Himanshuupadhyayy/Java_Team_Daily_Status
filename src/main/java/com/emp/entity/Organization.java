package com.emp.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Organization {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String org;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="organization")
    private List<Department> department;


}
