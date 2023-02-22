package com.blogApp.Services;

import com.blogApp.Entities.Post;
import com.blogApp.Payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    Post updatePost(PostDto postDto, Integer postId);

    void deletepost(Integer postId);

    List<Post> getAllPost();

    Post getPostById(Integer postId);

    List<PostDto> getPostsByCategory(Integer categoryId);

    List<PostDto> getPostsByUser(Integer userId);
// search posts by keyword
    List<Post> searchPosts(String keyword);
}
