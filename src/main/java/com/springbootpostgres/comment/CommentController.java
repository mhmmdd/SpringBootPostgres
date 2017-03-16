package com.springbootpostgres.comment;

import com.springbootpostgres.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mhmmdd on 15.03.2017.
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/posts/{postId}/comments")
    public List<Comment> getAllComments(@PathVariable String postId) {
        return commentService.getAllComments(Long.valueOf(postId));
    }

    @RequestMapping("/posts/{postId}/comments/{id}")
    public Comment getComment(@PathVariable String id) {
        return commentService.getComment(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/posts/{postId}/comments")
    public void addComment(@RequestBody Comment comment, @PathVariable String postId) {
        Post post = new Post(Long.valueOf(postId), "", "");
        comment.setPost(post);
        commentService.addComment(comment);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{postId}/comments/{id}")
    public void updateComment(@RequestBody Comment comment, @PathVariable String id, @PathVariable String postId) {
        Post post = new Post(Long.valueOf(postId), "", "");
        comment.setPost(post);
        comment.setId(Long.valueOf(id));
        commentService.updateComment(comment);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/comments/{id}")
    public void deleteComment(@PathVariable String id) {
        commentService.deleteComment(Long.valueOf(id));
    }
}
