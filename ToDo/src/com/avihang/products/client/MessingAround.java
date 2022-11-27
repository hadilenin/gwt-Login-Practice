package com.avihang.products.client;

import java.util.ArrayList;
import java.util.Random;

import com.avihang.frameworks.ags.client.components.AMDBC_03_Layout_Column;
import com.avihang.frameworks.ags.client.components.AMDBC_30_Action_Button;
import com.avihang.frameworks.ags.client.components.AMDBC_40_Form_TextBox;
import com.avihang.frameworks.ags.client.components.AMDBC_43_Form_RadioBox;
import com.avihang.frameworks.ags.client.components.AMDBC_47_Form_TextArea;
import com.avihang.frameworks.ags.client.components.AMDBC_61_FileUpload;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DragEnterEvent;
import com.google.gwt.event.dom.client.DragEnterHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class MessingAround extends VerticalPanel {

	private AMDBC_30_Action_Button button        		   =   new AMDBC_30_Action_Button("useless button");
	private AMDBC_47_Form_TextArea textArea      		   =   new AMDBC_47_Form_TextArea ("textArea_main","Label","type here!");
	private ArrayList<AMDBC_43_Form_RadioBox> radioBoxList =   new ArrayList<>();
	
	public MessingAround() {
		
		setWidth("100%");
		setHeight("100%");
		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		
		
		button.addStyleName("btn-outline-danger");
		button.setSmallButton();
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				Window.alert("button clicked");
			}
		});
		button.setWidth("400px");
		button.setHeight("100px");
		button.getElement().getStyle().setBackgroundColor("purple");
		
		textArea.getMainWidget().setSize("500px", "100px");
		textArea.getMainWidget().setDirection(Direction.LTR);
		textArea.getMainWidget().addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				// TODO Auto-generated method stub
				if(event.getUnicodeCharCode() == 13)
				  Window.alert(textArea.getMainWidget().getText());
			}
		});

		
		
		for(int i = 0; i < 5; i++) {
			radioBoxList.add(new AMDBC_43_Form_RadioBox(DOM.createUniqueId(),"label_" + String.valueOf(i),"singleGroup"));
			String[] colors = {"red","black","yellow","white","green","blue","purple","pink"};
			GWT.log(colors[Math.abs(new Random().nextInt(colors.length))]);
			radioBoxList.get(i).getElement().getStyle().setColor(colors[Math.abs(new Random().nextInt(colors.length))]);
		}
		
		
		add(button);
		add(textArea);
		for(int i = 0; i < radioBoxList.size(); i++) {
			add((AMDBC_43_Form_RadioBox) radioBoxList.get(i));
		}
		
	}

}
