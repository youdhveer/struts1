package com.example.common.form;

import org.apache.struts.action.ActionForm;

public class TestJsonForm extends ActionForm{
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}