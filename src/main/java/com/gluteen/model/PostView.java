package com.gluteen.model;

import com.gluteen.domain.Person;
import com.gluteen.domain.Post;
import com.gluteen.domain.Title;
import com.gluteen.security.SecurityUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yusufaslan on 1.06.2017.
 */
public class PostView implements Serializable{

    private Long postSenderId;
    private String postSender;
    private String postBody;
    private Date postDate;
    private String postImage;
    private Long postTitleId;

    public PostView(Post post)
    {
        final Person profile = SecurityUtils.currentProfile();
        final Person postSender = post.getPostSender();
        final Title postTitle = post.getPostTitle();

        this.postSenderId = postSender.getId();
        this.postSender=postSender.getUserName();
        this.postTitleId = postTitle.getId();
        this.postBody = post.getPostBody().replace("\n","\\n");
      //  this.postImage= ImageService.getImage(postSender.getId(),postSender.getUserName());
        this.postDate=post.getPostDate();




    }



}
