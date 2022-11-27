package com.avihang.products.client;

import com.avihang.frameworks.ags.client.components.AMDBC_40_Form_TextBox;
import com.avihang.frameworks.ags.client.components.AMDBC_41_Form_PWTextBox;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends VerticalPanel{

	private AMDBC_40_Form_TextBox username;
	private AMDBC_41_Form_PWTextBox password;
	
	
	public Login() {
		pushWidgetsCenter();
		
		username = textBoxGetInstance();
		password = PWTextGetInstance();
		
		username.getElement().getStyle().setPropertyPx("width", 300);
		password.getElement().getStyle().setPropertyPx("width", 300);
		
		username.getMainWidget().getElement().getStyle().setProperty("marginTop", "200px");
		
		add(username);
		add(password);
	}
	
	
	
	private void pushWidgetsCenter() {
		setWidth("100%");
		setHeight("100%");
		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	}
	
/*	private ActionEmbarkment getTextBoxOnActionImp() {
		ActionEmbarkment Imp = () -> {
			Window.alert(username.getText());
		};
		return Imp;
	}
	
	private ActionEmbarkment getPWTextBoxOnActionImp() {
		ActionEmbarkment Imp = () -> {
			Window.alert(password.getValue());
		};
		
		return Imp;
	}
*/
	
	private AMDBC_40_Form_TextBox textBoxGetInstance() {
		return  new AMDBC_40_Form_TextBox(DOM.createUniqueId(),"username :", "your username here!") {

			@Override
			public void doEnterPressHandler() { 
				// TODO Auto-generated method stub
				Window.alert(username.getText());
			}
			
			
		};
	}
	
	private AMDBC_41_Form_PWTextBox PWTextGetInstance() {
		return new AMDBC_41_Form_PWTextBox(DOM.createUniqueId(), "password :", "your password here!") {

			@Override
			public void doEnterPressHandler() {
				// TODO Auto-generated method stub
				Window.alert(password.getValue());
			}
		};
	}
	
}



