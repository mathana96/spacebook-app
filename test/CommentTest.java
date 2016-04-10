import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class CommentTest extends UnitTest 
{
	private Comment comment1, comment2;
	
  @Before
  public void setup()
  {
  	comment1 = new Comment("comment1");
  	comment2 = new Comment("comment2");
  	comment1.save();
  	comment2.save();
  }

  @After
  public void teardown()
  {
  	comment1.delete();
  	comment2.delete();
  }

  @Test
  public void testCreateComment()
  {
  	Comment a = Comment.findByComment("comment1");
  	assertNotNull(a);
  	assertEquals("comment1", a.content);
  	Comment b = Comment.findByComment("comment2");
  	assertNotNull(b);
  	assertEquals("comment2", b.content);
  }
  
  @Test
  public void testNotThere()
  {
    Comment a = Comment.findByComment("comment3");
    assertNull(a);
  }
}