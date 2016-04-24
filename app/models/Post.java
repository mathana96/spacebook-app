package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import controllers.Accounts;
import play.Logger;
import play.db.jpa.Model;

@Entity
public class Post extends Model
{
	@ManyToOne
	public User author;
	
  public String title;
  @Lob
  public String content;
  
  @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
  public List<Comment> comments;
//  @OneToMany(cascade=CascadeType.ALL)
  
  public long time;;

  public Post(String title, String content, User author)
  {
    this.title = title;
    this.content = content;
    this.comments = new ArrayList<Comment>();  
    this.time = System.currentTimeMillis();
    this.author = author;
  }
  
  public void addComment(Comment comment)
  {
  	comment.post = this;
  	comments.add(comment);
  }
  
  public static Post findByTitle(String title)
  {
    return find("title", title).first();
  } 
  
  private String getTime(long time)
  {
      long timeNow = System.currentTimeMillis();
      long timePassed = timeNow - time;      // time passed in milliseconds
      long seconds = timePassed/1000;
      long minutes = seconds/60;
      long hours = minutes/60;
      if (hours > 0)
      {
      	if (hours < 2)
      	{
        	return hours + " hour ago";

      	}
      	return hours + " hours ago";
      }
      else if(minutes > 0) 
      {
      	if (minutes < 2)
      	{
      		return minutes + " minute ago";
      	}
      	else
      	{
      		return minutes + " minutes ago";
      	}          
      }
      else 
      {
          return seconds + " seconds ago";
      }
  
 }
  

  
}