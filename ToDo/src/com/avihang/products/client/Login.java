package com.avihang.products.client;

import com.avihang.frameworks.ags.client.components.AMDBC_30_Action_Button;
import com.google.gwt.user.client.Element;
import com.avihang.frameworks.ags.client.components.AMDBC_31_Action_FloatingButton;
import com.avihang.frameworks.ags.client.components.AMDBC_40_Form_TextBox;
import com.avihang.frameworks.ags.client.components.AMDBC_41_Form_PWTextBox;
import com.avihang.frameworks.ags.client.components.AMDBC_58_Compound_Captcha;
import com.avihang.frameworks.ags.client.components.AMDBC_90_Card_Card;
import com.avihang.frameworks.ags.client.components.AMDBC_92_Card_Header;
import com.avihang.frameworks.ags.client.components.AMDBC_Enum.ButtonStyle;
import com.avihang.frameworks.ags.client.components.AMDBC_Enum.SpinnerStyle;
import com.avihang.frameworks.ags.client.components.AMDBC_Enum.TextStyle;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Login extends VerticalPanel{
	
	
	private AMDBC_90_Card_Card             cdContainer     = new AMDBC_90_Card_Card(new AMDBC_92_Card_Header("Login", "text-center", "black-text", "info-color",null,false,"headerFont"),false);
	private AMDBC_30_Action_Button         bnSubmit        = new AMDBC_30_Action_Button("sumbit",ButtonStyle.ADDITIONAL_CYAN,false,"");
	private AMDBC_31_Action_FloatingButton fltBnRefresh    = new AMDBC_31_Action_FloatingButton("mdi-sync",ButtonStyle.ADDITIONAL_CYAN);
	private AMDBC_40_Form_TextBox 	       tbUsername      = new AMDBC_40_Form_TextBox(DOM.createUniqueId(),"username", "your username here!") {

		@Override
		public void doEnterPressHandler() { 
			Window.alert(tbUsername.getText());
		}
		
		
	};
	private AMDBC_41_Form_PWTextBox pwPassword     = new AMDBC_41_Form_PWTextBox(DOM.createUniqueId(), "password", "your password here!") {

		@Override
		public void doEnterPressHandler() {
			Window.alert(pwPassword.getValue());
		}
	};
	

	
	
	public Login() {
		pushWidgetsCenter(); 		// pushes Widgets to center 
		
	    Button button = new Button("temp");
		button.addStyleName("buttonElement button1");
		
		
		tbUsername.getElement().getStyle().setPropertyPx("width", 300);
		tbUsername.getMainWidget().getElement().getStyle().setColor("black");
		pwPassword.getElement().getStyle().setPropertyPx("width", 300);
		cdContainer.getElement().getStyle().setProperty("marginTop", "130px");
		cdContainer.getElement().getStyle().setBackgroundColor("#86d1aa");
		cdContainer.getElement().getStyle().setMarginRight(400, Unit.PX);
		cdContainer.getElement().getStyle().setMarginLeft(400, Unit.PX);
		cdContainer.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		fltBnRefresh.getElement().getStyle().setCursor(Cursor.POINTER);
		
		
		bnSubmit.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg) {
			
				if (pwPassword.getValue().isEmpty()) 
					pwPassword.showError("password input was glossed over!");
				
				if(tbUsername.getText().isEmpty())
					tbUsername.showError("username input was glossed over!");
				 
				if(!(pwPassword.getValue().isEmpty() || tbUsername.getText().isEmpty()))
					Window.alert(tbUsername.getText() + "@" + pwPassword.getValue());
			
			}
		});
		
		fltBnRefresh.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				// TODO Auto-generated method stub
				tbUsername.setText("");
				tbUsername.clearError();
				pwPassword.setValue("");
				pwPassword.clearError();
			}
		});
		
		tbUsername.getMainWidget().addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent arg0) {
				// TODO Auto-generated method stub
				tbUsername.clearError();
				pwPassword.clearError();
			}
		});
		
		
		cdContainer.addToContent(tbUsername);
		cdContainer.addToContent(pwPassword);
		cdContainer.addToContent(bnSubmit);
		cdContainer.addToContent(button);

		add(fltBnRefresh);
		add(cdContainer);
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
	
/*	private AMDBC_40_Form_TextBox textBoxGetInstance() {
		return  new AMDBC_40_Form_TextBox(DOM.createUniqueId(),"username :", "your username here!") {

			@Override
			public void doEnterPressHandler() { 
				// TODO Auto-generated method stub
				Window.alert(tbUsername.getText());
			}
			
			
		};
	}
	
	private AMDBC_41_Form_PWTextBox PWTextGetInstance() {
		return new AMDBC_41_Form_PWTextBox(DOM.createUniqueId(), "password :", "your password here!") {

			@Override
			public void doEnterPressHandler() {
				// TODO Auto-generated method stub
				Window.alert(pwPassword.getValue());
			}
		};
	}
	
	*/
}



