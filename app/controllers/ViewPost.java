package controllers;

import java.util.List;

import models.Comment;
import models.Message;
import models.Post;
import models.User;
import play.Logger;
import play.mvc.Controller;

public class ViewPost  extends Controller
{
	 public static void index(Long id, Long postid)
	  {
	    User currentUser = Accounts.getLoggedInUser();
	    Post post = Post.findById(postid);
	    User user = User.findById(id);
	    Logger.info("Just visiting the page for " + user.firstName + ' ' + user.lastName);
	    if (user.posts.size() > 0)
	    {
	    	render(user, post);
	    }
	    else
	    {
	    	PublicBlog.visit(id);
	    }
	    
	  }
  
	
}