package com.blogApp.Payload;

import com.blogApp.Entities.Category;
import com.blogApp.Entities.Comment;
import com.blogApp.Entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private Integer postId;
    private String title;

    private  String content;
    private String ImageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDTO user;

    private Set<CommentDto> comments= new HashSet<>();

}
