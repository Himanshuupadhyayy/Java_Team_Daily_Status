package com.blogApp.Services;

import com.blogApp.Payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);

    void  deleteComment(Integer commentId);
}
