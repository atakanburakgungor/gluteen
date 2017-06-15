package com.gluteen.web;

import com.gluteen.domain.Post;
import com.gluteen.repository.PostRepository;
import com.gluteen.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yusufaslan on 30.05.2017.
 */
@RestController
public class DemoController {

    @Autowired
    private final PostService postService;



    @Autowired
    private PostRepository postRepository;

    public DemoController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/post/{id}")
    public Post getByid(@PathVariable("id") Long id)
    {
        return postRepository.findOne(id);
    }

    @RequestMapping("/posts/{id}")
    public void getAll(@PathVariable("id")Long id)
    {
         postService.deletePost(id);
    }
    @RequestMapping("/update")
    public void update(Post post)
    {
        postService.updatePost(post);
    }
    @RequestMapping("/save")
    public void create(Post post)
    {
        postService.savePost(post);
    }


}
