package com.gluteen.service;

import com.gluteen.domain.Person;
import com.gluteen.domain.Post;
import com.gluteen.domain.Title;
import com.gluteen.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yusufaslan on 30.05.2017.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;



    public Post getPostById (Long id)
    {
        return postRepository.findOne(id);
    }

    public List<Post> getPostsByPerson(Long senderId)
    {
        return postRepository.findByPostSenderOrderByPostDate(senderId);
    }

    public List<Post> findByPostTitleOrderByPostDate(Long titleId)
    {
        return postRepository.findByPostTitleOrderByPostDate(titleId);
    }

    public void updatePost(Post post)
    {
        postRepository.updatePost(post.getId(),post.getPostBody());
    }

    public void deletePost(Long id)
    {
        postRepository.delete(id);
    }

    public void savePost(Post post)
    {
        postRepository.save(post);
    }
    public Post postSave(String body, Title postTitle, String postImage, Person postSender) {

        if (!postImage.isEmpty() && postImage != null) {
            return new Post(body , postTitle,"/imgs/post/" + postImage, new Date(),postSender);
        }
        return new Post(body,postTitle, new Date(), postSender);

    }



}
