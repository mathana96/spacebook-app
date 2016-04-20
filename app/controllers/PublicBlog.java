package controllers;

import java.util.List;

import models.Comment;
import models.Message;
import models.Post;
import models.User;
import play.Logger;
import play.mvc.Controller;

public class PublicBlog  extends Controller
{
	 public static void visit(Long id)
	  {
//	    User currentUser = Accounts.getLoggedInUser();
	    
	    User user = User.findById(id);
	    Logger.info("Just visiting the page for " + user.firstName + ' ' + user.lastName);
	    
	    
	    render(user);
	   
	  }
  
  public static void comment(Long id, Long postid, String content, String title)
  {
    User currentUser = Accounts.getLoggedInUser();
    User user = User.findById(id);
    Post post = Post.findById(postid);
    Comment comment = new Comment(currentUser, content);
    post.addComment(comment);
    post.save();
    user.posts.add(post);
    if (currentUser == user)
    {
      Blog.index();
    }
    else 
    {
    	viewPost(id, postid);
    }
  }
  
  public static void viewPost(Long id, Long postid)
  {
//    User currentUser = Accounts.getLoggedInUser();
    Post post = Post.findById(postid);
    User user = User.findById(id);
    Logger.info("Just visiting the page for " + user.firstName + ' ' + user.lastName);
    if (user.posts.contains(post))
    {
    	render(user, post);
    }
    else
    {
    	PublicBlog.visit(id);
    }
    
  }
  
 

}