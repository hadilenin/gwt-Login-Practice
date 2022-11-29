package com.avihang.products.client;

import java.util.ArrayList;

import com.avihang.frameworks.ags.client.components.AMDBC_30_Action_Button;
import com.avihang.frameworks.ags.client.components.AMDBC_31_Action_FloatingButton;
import com.avihang.frameworks.ags.client.components.AMDBC_31_Action_IconButton;
import com.avihang.frameworks.ags.client.components.AMDBC_90_Card_Card;
import com.avihang.frameworks.ags.client.components.AMDBC_Enum.ButtonStyle;
import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.TextJustify;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.css.InterfaceGenerator;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;

public class TikTakToe extends FlowPanel {

	private AMDBC_90_Card_Card                 cdQuarterContainer         = new AMDBC_90_Card_Card("","","",false);
	private ArrayList<AMDBC_30_Action_Button>  quarterList  			  = new ArrayList<>();
	
	private TurnBase currentTurn = TurnBase.O;
	private boolean[] wasClicked = new boolean[9]; 
	
	public TikTakToe() {
		
		for(int i = 0;i < 9;i++) {
			quarterList.add(new AMDBC_30_Action_Button(" ",ButtonStyle.ADDITIONAL_CYAN,false,""));
			quarterList.get(i).getElement().getStyle().setWidth(100, Unit.PX);
			
			quarterList.get(i).setText(" ");
			int j = i;
			quarterList.get(i).addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent arg0) {
					
					if(!wasClicked[j]) {
						if(nextTurn() == TurnBase.O)
							quarterList.get(j).setText("O");
						else 
							quarterList.get(j).setText("X");
						wasClicked[j] = true;
					}
				}
			});
		}
		
		positionQuarters();
	
		cdQuarterContainer.getElement().getStyle().setMargin(300, Unit.PX);
	
		
		for(int i = 0;i < quarterList.size();i++)
			cdQuarterContainer.add(quarterList.get(i));
		
		add(cdQuarterContainer);
		
		
	}
	
	private void positionQuarters() {
		int positionRightPx = 455;
		int liftPx = 45;
		int shiftRightPx = formatter(quarterList.get(0).getElement().getStyle().getWidth()) + 30;
		int j = 0;
		while(j == 0 || j == 3 || j == 6) {
			quarterList.get(j).getElement().getStyle().setPosition(Position.RELATIVE);
			quarterList.get(j + 1).getElement().getStyle().setPosition(Position.RELATIVE);
			quarterList.get(j + 2).getElement().getStyle().setPosition(Position.RELATIVE);
			
			quarterList.get(j).getElement().getStyle().setRight(positionRightPx, Unit.PX);
			quarterList.get(j + 1).getElement().getStyle().setRight(positionRightPx - shiftRightPx, Unit.PX);
			quarterList.get(j + 2).getElement().getStyle().setRight(positionRightPx - (2 * shiftRightPx), Unit.PX);
			
			quarterList.get(j + 1).getElement().getStyle().setBottom(liftPx, Unit.PX);
			quarterList.get(j + 2).getElement().getStyle().setBottom(2 * liftPx, Unit.PX);
			
			j += 3;
		}
	}
	
	private int formatter(String str) {
		str =  str.replace("px","");
		return Integer.parseInt(str);
	}

	private TurnBase nextTurn() {
		switch (currentTurn) {
		case X:
			currentTurn = TurnBase.O;
			break;
		case O:
			currentTurn = TurnBase.X;
			break;
		}
		
		return currentTurn;
	}
	

	enum TurnBase{
		X,O
	}
	
}