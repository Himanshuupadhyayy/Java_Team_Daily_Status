package com.blogApp.Services;

import com.blogApp.Entities.Post;
import com.blogApp.Payload.PostDto;
import com.blogApp.Payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    PostDto updatePost(PostDto postDto, Integer postId);

    void deletepost(Integer postId);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy, String sortDirection);

    PostDto getPostById(Integer postId);

    List<PostDto> getPostsByCategory(Integer categoryId);

    List<PostDto> getPostsByUser(Integer userId);
// search posts by keyword
    List<PostDto> searchPosts(String keyword);
}
