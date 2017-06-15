package com.gluteen.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yusufaslan on 30.05.2017.
 */
@Entity
@NoArgsConstructor
public class Post implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postBody;

    @ManyToOne
    @JoinColumn(name = "post_title_id")
    private Title postTitle;

    private String postImage;

    private Date postDate;

    @ManyToOne
    @JoinColumn(name = "post_sender_id")
    private Person postSender;

    public Post(String postBody, Title postTitle, String postImage, Date postDate, Person postSender) {
        this.postBody = postBody;
        this.postTitle = postTitle;
        this.postImage = postImage;
        this.postDate = postDate;
        this.postSender = postSender;
    }

    public Post(String body, Title postTitle, Date date, Person postSender) {
        this.postBody = postBody;
        this.postTitle = postTitle;
        this.postDate = postDate;
        this.postSender = postSender;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Title getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(Title postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Person getPostSender() {
        return postSender;
    }

    public void setPostSender(Person postSender) {
        this.postSender = postSender;
    }
}
