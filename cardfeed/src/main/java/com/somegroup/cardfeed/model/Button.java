package com.somegroup.cardfeed.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Button {
	@Id
	private String buttonName;
	private String buttonMsg;
	
	public Button() {}
	
	public Button(String buttonName, String buttonMsg) {
		super();
		this.buttonName = buttonName;
		this.buttonMsg = buttonMsg;
	}
	
	public String getButtonName() {
		return buttonName;
	}
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	public String getButtonMsg() {
		return buttonMsg;
	}
	public void setButtonMsg(String buttonMsg) {
		this.buttonMsg = buttonMsg;
	}
	
	public static final String STATUS_BUTTON_NAME="StatusBtn";
}
