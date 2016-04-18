package models;

import javax.persistence.*;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import play.db.jpa.*;

@Entity
public class Message extends Model
{
  public String messageText;

  @ManyToOne
  public User from;

  @ManyToOne
  public User to;

  public Message(User from, User to, String messageText)
  {
    this.from = from;
    this.to = to;
    this.messageText = messageText;
  }
}