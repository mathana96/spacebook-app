package models;
import java.util.ArrayList;
import java.util.Date;
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


	public Date when;
	
	public Post(String title, String content, User author)
	{
		this.title = title;
		this.content = content;
		this.comments = new ArrayList<Comment>();  
		this.when = new Date();
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


}