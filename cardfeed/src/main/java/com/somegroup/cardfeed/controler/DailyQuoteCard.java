package com.somegroup.cardfeed.controler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.somegroup.cardfeed.model.Author;
import com.somegroup.cardfeed.model.CardType;
import com.somegroup.cardfeed.model.Customer;
import com.somegroup.cardfeed.model.CustomerType;
import com.somegroup.cardfeed.util.Condition;

@JsonInclude(Include.NON_NULL)
public class DailyQuoteCard extends Card {

	private String title ;
	private CardType type = CardType.DAILY_QUOTE;
	private String message;
	private Author author;

	public DailyQuoteCard(String title, String message, Author author) {
		super();
		this.title = title;
		this.message = message;
		this.author = author;
	}
	
	public DailyQuoteCard() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	@Override
	public boolean test(Customer cust) {
		return cust.getType()==CustomerType.TYPE_B?false:true;
	}
}
