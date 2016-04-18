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

  public Comment(User sender, String content)
  {
  	this.post = post;
  	this.sender = sender;
  	this.content = content;
  }

}