import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class CommentTest extends UnitTest 
{
	private User bob;
	private Comment comment1;
	private Post post1;
	
  @Before
  public void setup()
  {
  	//Create a new user called bob and save
  	bob = new User ("bob", "jones", "bob@jones.com", "secret", 20, "irish");
  	bob.save();
  }

  @After
  public void teardown()
  {
  	bob.delete();
  }

  @Test
  public void testCreateComment()
	{
  	//Create a new post and add the post to bob's arraylist of post.
  	post1 = new Post("Post Title 1", "This is the first post content");
  	bob.posts.add(post1);
  	
  	//Create a new comment and add the comment to the post created
  	comment1 = new Comment(bob, "comment2");
  	post1.comments.add(comment1);
  	post1.save();
  	
  	//Find the user which we created and get the post
  	User user = User.findByEmail("bob@jones.com");
  	Post post = user.posts.get(0);
  	
  	//Get the comment from the post and check if that's it
  	Comment comment = post.comments.get(0);
  	assertEquals("comment2", comment.content);
  	
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
  
  
//  @Test
//  public void testCreateCommentWithUser()
//  {
//  	Post post1 = Post.findByTitle("Post Title 1");
//    assertEquals("This is the first post content", post1.content);
//    
//    Comment comment = Comment.findBySender(bob);
//    assertEquals("comment1", comment.content);
//  
//  }
  
  @Test
  public void testNotThere()
  {
    Comment a = Comment.findByComment("comment3");
    assertNull(a);
  }
}