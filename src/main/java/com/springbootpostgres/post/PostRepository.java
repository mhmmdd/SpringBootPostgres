package com.springbootpostgres.post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mhmmdd on 15.03.2017.
 */

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
