package com.blogApp.Services.Impl;

import com.blogApp.Entities.Category;
import com.blogApp.Entities.Post;
import com.blogApp.Entities.User;
import com.blogApp.Exception.ResourceNotFoundException;
import com.blogApp.Payload.PostDto;
import com.blogApp.Payload.PostResponse;
import com.blogApp.Repository.CategoryRepo;
import com.blogApp.Repository.PostRepo;
import com.blogApp.Repository.UserRepo;
import com.blogApp.Services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public PostDto createPost(PostDto postDto , Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        Post post= this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletepost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
        this.postRepo.delete(post);

    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortby,String sortDirection) {

        Sort sort = null;
        if (sortDirection.equalsIgnoreCase("asc")){
            sort = Sort.by(sortby).ascending();
        }else {
            sort = Sort.by(sortby).descending();
        }
        //these will come from ui side by url
       // int pageSize=5;
        //int pageNumber=1;
        Pageable p = PageRequest.of(pageNumber,pageSize, sort);
        Page<Post> pagePost = this.postRepo.findAll(p);
        List<Post> allPost = pagePost.getContent();
       List<PostDto> postDtos= allPost.stream().map((post) ->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
       PostResponse postResponse = new PostResponse();
       postResponse.setContent(postDtos);
       postResponse.setPagenumber(pagePost.getNumber());
       postResponse.setPageSize(pagePost.getSize());
       postResponse.setTotleElement(pagePost.getTotalElements());
       postResponse.setTotlePages(pagePost.getTotalPages());
       postResponse.setLastPage(pagePost.isLast());

       return postResponse;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {

        Category category= this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        List<Post> posts = this.postRepo.findByCategory(category);
        List<PostDto> postDtos= posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "userId",userId));
        List<Post> posts = this.postRepo.findByUser(user);
        List<PostDto> postDtos= posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        List<Post> posts= this.postRepo.findByTitleContaining(keyword);
        List<PostDto> postDtos = posts.stream().map((post) ->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }
}
