package com.somegroup.cardfeed.controler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.somegroup.cardfeed.model.Button;
import com.somegroup.cardfeed.model.CardMessage;
import com.somegroup.cardfeed.model.CardType;
import com.somegroup.cardfeed.model.Customer;
import com.somegroup.cardfeed.model.CustomerType;
import com.somegroup.cardfeed.util.Condition;

@JsonInclude(Include.NON_NULL)
public class StatusUpdateCard extends Card {

	private String title;
	private CardType type = CardType.STATUS_UPDATE;
	private String message;
	private Button button;
	private String iconLink;
	
	public StatusUpdateCard(String title, String message, Button button, String iconLink) {
		super();
		this.title = title;
		this.message = message;
		this.button = button;
		this.iconLink = iconLink;
	}
	
	public StatusUpdateCard() {}

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public String getIconLink() {
		return iconLink;
	}

	public void setIconLink(String iconLink) {
		this.iconLink = iconLink;
	}
	@Override
	public boolean test(Customer cust) {
		return cust.getType()==CustomerType.TYPE_A?false:true;
	}
}
