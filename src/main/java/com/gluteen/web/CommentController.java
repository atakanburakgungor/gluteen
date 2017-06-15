package com.gluteen.web;

import com.gluteen.domain.Comment;
import com.gluteen.service.CommentService;
import com.gluteen.service.PostService;
import com.gluteen.service.TitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.gluteen.configuration.Constants.URI_API_PREFIX;
import static com.gluteen.configuration.Constants.URI_COMMENTS;

/**
 * Created by yusufaslan on 3.06.2017.
 */
@RestController
@RequestMapping(value = URI_API_PREFIX)
public class CommentController {
//ssa
    private static final Logger log = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private TitleService titleService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = URI_COMMENTS+"/save")
    public void saveComment(Comment comment)
    {
        commentService.saveComment(comment);
    }

    @RequestMapping(value = URI_COMMENTS+"/delete/{id}")
    public void deleteComment(@PathVariable("id")Long id)
    {
        commentService.deleteComment(id);
    }

    @RequestMapping(value = URI_COMMENTS+"/update")
    public void updateComment(Comment comment)
    {
        commentService.updateComment(comment);
    }

    @RequestMapping(value = URI_COMMENTS+"/commentOfPost/{id}")
    public List<Comment> getCommentsOfPost(@PathVariable("id")Long id)
    {
       return commentService.findByCommentOfPostOrderByCommentDate(id);
    }

    @RequestMapping(value = URI_COMMENTS+"/commentOfPerson/{id}")
    public List<Comment> getCommentOfPerson(@PathVariable("id")Long id)
    {
        return commentService.getCommentsByCommentSender(id);
    }



}
