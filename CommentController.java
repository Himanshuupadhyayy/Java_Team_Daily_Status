package com.blogApp.Controller;

import com.blogApp.Payload.ApiResponses;
import com.blogApp.Payload.CommentDto;
import com.blogApp.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComments(@RequestBody CommentDto comment, @PathVariable Integer postId){
        CommentDto createComment = this.commentService.createComment(comment,postId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponses> deleteComments(@PathVariable Integer commentId){
    this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponses>(new ApiResponses("deleted successfully", true), HttpStatus.OK);
    }

}
