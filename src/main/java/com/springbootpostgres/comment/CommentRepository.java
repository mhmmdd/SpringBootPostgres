package com.springbootpostgres.comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mhmmdd on 15.03.2017.
 */

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    public List<Comment> findByPostId(Long postId);

}
