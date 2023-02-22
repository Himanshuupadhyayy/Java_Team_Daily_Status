package com.blogApp.Payload;

import com.blogApp.Entities.Category;
import com.blogApp.Entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private String title;

    private  String content;
    private String ImageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDTO user;

}
