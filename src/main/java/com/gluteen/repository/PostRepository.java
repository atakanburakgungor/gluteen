package com.gluteen.repository;

import com.gluteen.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by yusufaslan on 30.05.2017.
 */
public interface PostRepository extends JpaRepository<Post, Long> {


    @Modifying
    @Query("select m from Post m where m.postSender=:senderId order by m.postDate")
    List<Post> findByPostSenderOrderByPostDate(Long senderId);

    @Modifying
    @Query("select m from Post m where m.postTitle=:titleId order by m.postDate")
    List<Post> findByPostTitleOrderByPostDate(Long titleId);

    @Modifying
    @Query("update Post m set m.postBody=:postBody where m.id =:id ")
    Post updatePost(@PathParam("id") Long id, @PathParam("postBody") String postBody);





}
