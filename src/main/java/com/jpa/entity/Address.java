package com.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Entity
@Data
@NoArgsConstructor
@Embeddable
public class Address {

    //@NotNull
    @Size(min= 2)
    private String city;
    //@NotBlank
    private String state;
    //@NotBlank
    private String addressType;

}
