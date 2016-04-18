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
	    User currentUser = Accounts.getLoggedInUser();
	    
	    User user = User.findById(id);
	    Logger.info("Just visiting the page for " + user.firstName + ' ' + user.lastName);
	    render(user);
	  }
  
  public static void comment(Long id, String content, String title)
  {
    User currentUser = Accounts.getLoggedInUser();
    User user = User.findById(id);
    Post post = Post.findByTitle(title);
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
    	visit(id);
    }
    
 
  }
}