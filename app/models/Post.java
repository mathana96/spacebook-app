package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Post extends Model
{
  public String title;
  @Lob
  public String content;
  
  @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
  public List<Comment> comments;
//  @OneToMany(cascade=CascadeType.ALL)
  
  public long time;

  public Post(String title, String content)
  {
    this.title = title;
    this.content = content;
    this.comments = new ArrayList<Comment>();
    this.time = System.currentTimeMillis();
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

  public String toString()
  {
    return title + getTime(time);
  } 
  
  private String getTime(long time)
  {
      long timeNow = System.currentTimeMillis();
      long timePassed = timeNow - time;      // time passed in milliseconds
      long seconds = timePassed/1000;
      long minutes = seconds/60;
      if(minutes > 0) {
          return minutes + " minutes ago";
      }
      else {
          return seconds + " seconds ago";
      }
  }
  
}