package com.avihang.products.client;

import com.avihang.frameworks.ags.client.components.AMDBC_41_Form_PWTextBox;

public class PWTextBox extends AMDBC_41_Form_PWTextBox {

	private ActionEmbarkment action;
	
	public PWTextBox(String id, String label, String emptyText) {
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
