package com.avihang.products.client;

import com.avihang.frameworks.ags.client.components.AMDBC_40_Form_TextBox;

public class TextBox extends AMDBC_40_Form_TextBox{
	
	private ActionEmbarkment action;
	
	public TextBox(String id, String label, String emptyText) {
		super(id, label, emptyText);
		// TODO Auto-generated constructor stub
	}

	
	public void setActionHandler(ActionEmbarkment action) {
		this.action = action;
	}
	
	@Override
	public void doEnterPressHandler() {
		// TODO Auto-generated method stub
		action.embark();
	}
	
}
