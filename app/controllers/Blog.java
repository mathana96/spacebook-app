package controllers;

import java.util.Collections;
import java.util.List;

import models.Message;
import models.Post;
import models.User;
import play.Logger;
import play.mvc.Controller;

public class Blog  extends Controller
{
  public static void index()
  {
    User user = Accounts.getLoggedInUser();
    render(user);
  }
  
  public static void newPost(String title, String content)
  {
    User user = Accounts.getLoggedInUser();
    
    Post post = new Post(title, content);
    post.save();
    user.posts.add(0, post);
    user.save();  
    Logger.info ("title:" + title + " content:" + content);
    index();
  }
  
  public static void deletePost(Long id)
  {
    User user = Accounts.getLoggedInUser();
    
    Post post = Post.findById(id);
    post.save();
    user.posts.remove(post);
    user.save();  
    Logger.info ("Removed " + "id:" + id);
    index();
  }
}