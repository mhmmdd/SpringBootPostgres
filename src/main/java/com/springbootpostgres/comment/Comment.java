package com.springbootpostgres.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springbootpostgres.post.Post;

import javax.persistence.*;

/**
 * Created by mhmmdd on 15.03.2017.
 */

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnore // break the cycle
    private Post post;

    public Long getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
