package com.springbootpostgres.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhmmdd on 15.03.2017.
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments (Long postId) {
        List<Comment> comments = new ArrayList<>();
        commentRepository.findByPostId(postId).forEach(comments::add);
        return comments;
    }

    public Comment getComment(Long id) {
        return commentRepository.findOne(id);
    }

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.delete(id);
    }
}
