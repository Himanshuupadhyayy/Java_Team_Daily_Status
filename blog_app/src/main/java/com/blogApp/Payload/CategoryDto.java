package com.blogApp.Payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private int categoriId;
    @NotBlank
    @Size(min = 4, message = "title should be in 4 char")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10, message = "description should be of min 10 char")
    private String categoryDescription;

}
