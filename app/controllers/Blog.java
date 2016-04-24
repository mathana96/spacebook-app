package controllers;

import java.util.Collections;
import java.util.List;

import models.Comment;
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
    Post post = new Post(title, content, user);
    user.posts.add(0, post);
    post.save();
    user.save();
    Logger.info ("title:" + title + " content:" + content);
    index();
  }
  
  public static void editPost(String title, String content, Long id)
  {

    User user = Accounts.getLoggedInUser();
  	Post post = Post.findById(id);
    if (content != null)
    {
    	post.content = content;
    }
    if (title != null)
    {
    	post.title = title;
    }
    
    post.save();
    user.save();
    Logger.info ("New title:" + title + " New content:" + content);
    index();
  }
  
  public static void editPostPage(String title, String content, Long postid)
  {
  	Post post = Post.findById(postid);
  	render(post);
  }
  
  
  public static void deletePost(Long id)
  {
    User user = Accounts.getLoggedInUser();
    
    Post post = Post.findById(id);
    post.save();
    user.posts.remove(post);
    user.save();  
    post.delete();
    Logger.info ("Removed " + "id:" + id);
    index();
  }
  
  public static void deleteComment(Long postid, Long commentid)
  {
    User user = Accounts.getLoggedInUser();
    
    Post post = Post.findById(postid);
    post.save();
    
    Comment comment = Comment.findById(commentid);
    
    post.comments.remove(comment);
    comment.delete();
    user.save();  
    Logger.info ("Removed " + "id:" + commentid);
    index();
  }
}