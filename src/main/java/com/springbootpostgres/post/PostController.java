package com.springbootpostgres.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mhmmdd on 15.03.2017.
 */
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @RequestMapping("/posts/{id}")
    public Post getPost(@PathVariable String id) {
        return postService.getPost(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/posts")
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{id}")
    public void updatePost(@RequestBody Post post, @PathVariable String id) {
        postService.updatePost(post);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/posts/{id}")
    public void deletePost(@PathVariable String id) {
        postService.deletePost(Long.valueOf(id));
    }
}
