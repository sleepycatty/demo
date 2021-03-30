package com.somegroup.cardfeed.controler;

import com.somegroup.cardfeed.model.Author;
import com.somegroup.cardfeed.model.CardType;
import com.somegroup.cardfeed.util.Condition;

public abstract class Card implements Condition{

	public abstract String getTitle();
	public abstract CardType getType();	
	public abstract String getMessage();
	
	public Author getAuthor() {return null;}
	
	public String getIconLink() {return null;}
	public String getButtonMsg() {return null;}
	
}
