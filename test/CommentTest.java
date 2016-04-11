import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class CommentTest extends UnitTest 
{
	private User bob, joe, lee;
	private Comment comment1, comment2, comment3, comment4;
	private Post post1, post2, post3, post4, post5;
	
  @Before
  public void setup()
  {
  	//Create a new user called bob and save
  	bob = new User ("bob", "jones", "bob@jones.com", "secret", 20, "irish");
  	bob.save();
  	joe = new User ("joe", "jones", "joe@jones.com", "secret", 20, "irish");
  	joe.save();
  	lee = new User ("lee", "jones", "lee@jones.com", "secret", 20, "irish");
  	lee.save();
  }

  @After
  public void teardown()
  {
  	bob.delete();
  	joe.delete();
  }

  @Test
  public void testCreateComment()
	{
  	//Create a new post and add the post to bob's arraylist of post.
  	post1 = new Post("Post Title 1", "This is the first post content");
  	bob.posts.add(post1);
  	
  	//Create a new comment and add the comment to the post created
  	comment1 = new Comment(bob, "comment1");
  	post1.comments.add(comment1);
  	post1.save();
  	
  	//Find the user which we created and get the post
  	User user = User.findByEmail("bob@jones.com");
  	Post post = user.posts.get(0);
  	
  	//Get the comment from the post and check if that's it
  	Comment comment = post.comments.get(0);
  	assertEquals("comment1", comment.content);
  	//Use bob's email as it is more reliable and specific
  	assertEquals(bob.email, comment.sender.email);
  	
  	//Remove comment from post
  	post.comments.remove(comment);
  	//Save it because it has been updated
    post.save();
    //Delete it from the database
    comment.delete();
  	//Remove post from user
  	user.posts.remove(post);
  	//Save it
  	user.save();
  	//Delete it from the database
  	post.delete();
  	
  }
  
  @Test
  public void testDeleteComment()
  {
  	post2 = new Post("Post Title 2", "This is the first post content");
  	joe.posts.add(post2);
  	
  	comment2 = new Comment(bob, "comment2");
  	post2.comments.add(comment2);
  	post2.save();
  	
  	User user = User.findByEmail("joe@jones.com");
  	Post post = user.posts.get(0);
  	Comment comment = post.comments.get(0);
  	
  	assertEquals("comment2", comment.content);
  	assertEquals(bob.firstName, comment.sender.firstName);
  	
  	
  	post.comments.remove(comment);
    post.save();
    
    assertEquals(0, post.comments.size()); //check is no comments
    
    comment.delete(); //delete from database
    
    
  	user.posts.remove(post);
  	
  	assertEquals(0, user.posts.size()); //check if no posts
  	
  	user.save(); //update user
  	
  	post.delete();
  }
  
  @Test
  public void testMultipleComments()
  {
  	post3 = new Post("Post Title 3", "The content");
  	bob.posts.add(post3);
  	//post4 = new Post("Post Title 4", "This is the second post content");
  	//bob.posts.add(post3);
  	
  	comment3 = new Comment(joe, "Comment from Joe");
  	comment4 = new Comment(lee, "Comment from Lee");
  	post3.comments.add(comment3);
  	post3.comments.add(comment4);
  	post3.save();
  	
  	User user = User.findByEmail("bob@jones.com");
  	Post post = user.posts.get(0);
  	Comment comment1 = post.comments.get(0);
  	Comment comment2 = post.comments.get(1);
  	
  	//Check post number, title and content
  	assertEquals(1, user.posts.size());
  	assertEquals("Post Title 3", user.posts.get(0).title);
  	assertEquals("The content", user.posts.get(0).content);
  	
  	//Check comments number, sender and content
  	assertEquals(2, post.comments.size());
  	assertEquals(joe, post.comments.get(0).sender);
  	assertEquals(lee, post.comments.get(1).sender);
  	assertEquals("Comment from Joe", post.comments.get(0).content);
  	assertEquals("Comment from Lee", post.comments.get(1).content);
  	
  	//Deleting comment&post from user and database
  	post.comments.remove(comment1);
  	post.comments.remove(comment2);
  	
    post.save();
    
    comment1.delete();
    comment2.delete();
  	
  	user.posts.remove(post);
  	
  	user.save();
  	
  	post.delete();
  }

}