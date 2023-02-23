package com.blogApp.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;


}
