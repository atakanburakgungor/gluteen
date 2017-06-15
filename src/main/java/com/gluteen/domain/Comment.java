package com.gluteen.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yusufaslan on 30.05.2017.
 */
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentBody;

    @ManyToOne
    @JoinColumn(name = "comment_sender_id")
    private Person commentSender;

    private Date commentDate;
    @ManyToOne
    @JoinColumn(name = "comment_post_id")
    private Post commentOfPost;

    public Comment(String commentBody, Person commentSender, Date commentDate, Post commentOfPost) {
        this.commentBody = commentBody;
        this.commentSender = commentSender;
        this.commentDate = commentDate;
        this.commentOfPost = commentOfPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Person getCommentSender() {
        return commentSender;
    }

    public void setCommentSender(Person commentSender) {
        this.commentSender = commentSender;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Post getCommentOfPost() {
        return commentOfPost;
    }

    public void setCommentOfPost(Post commentOfPost) {
        this.commentOfPost = commentOfPost;
    }
}
