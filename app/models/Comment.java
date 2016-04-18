package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Comment extends Model
{
	@ManyToOne
  public Post post;
	
  @Lob
  public String content;
  
  @ManyToOne  
  public User sender;
  
  public long time;
  
  public Comment(User sender, String content)
  {
  	this.time = System.currentTimeMillis();
  	this.sender = sender;
  	this.content = content;
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