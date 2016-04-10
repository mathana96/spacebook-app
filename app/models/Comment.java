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

  public Comment(String content)
  {
    this.content = content;
  }

  public String toString()
  {
    return content;
  } 
  
  public static Comment findByComment(String content)
  {
    return find("content", content).first();
  }
}