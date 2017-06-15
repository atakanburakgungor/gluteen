package com.gluteen.repository;

import com.gluteen.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;


/**
 * Created by yusufaslan on 31.05.2017.
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Modifying
    @Query("select m from Comment m where m.commentSender=:senderId order by m.commentDate")
    List<Comment> findByCommentSenderOrderByPostDate(Long senderId);

    List<Comment> findByCommentOfPostOrderByCommentDate(Long postId);

//    @Modifying
//    @Query("select m from Comment m where m.postTitle=:titleId order by m.postDate")
//    List<Comment> findByPostTitleOrderByPostDate(Long titleId);

    @Modifying
    @Query("update Comment m set m.commentBody=:commentBody where m.id =:id ")
    Comment updateComment(@PathParam("id") Long id, @PathParam("commentBody") String commentBody);






}
