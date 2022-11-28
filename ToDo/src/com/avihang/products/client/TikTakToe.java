package com.avihang.products.client;

import java.util.ArrayList;

import com.avihang.frameworks.ags.client.components.AMDBC_30_Action_Button;
import com.avihang.frameworks.ags.client.components.AMDBC_31_Action_FloatingButton;
import com.avihang.frameworks.ags.client.components.AMDBC_31_Action_IconButton;
import com.avihang.frameworks.ags.client.components.AMDBC_90_Card_Card;
import com.avihang.frameworks.ags.client.components.AMDBC_Enum.ButtonStyle;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.css.InterfaceGenerator;
import com.google.gwt.user.client.ui.FlowPanel;

public class TikTakToe extends FlowPanel {

	private AMDBC_90_Card_Card                 cdQuarterContainer         = new AMDBC_90_Card_Card("TikTakToe","yoo hoo","",false);
	private ArrayList<AMDBC_30_Action_Button>  quarterList  			  = new ArrayList<>();
	
	public TikTakToe() {
		
		for(int i = 0;i < 9;i++) {
			quarterList.add(new AMDBC_30_Action_Button(" ",ButtonStyle.ADDITIONAL_CYAN,false,""));
			quarterList.get(i).getElement().getStyle().setWidth(100, Unit.PX);
			quarterList.get(i).setLargeButton();
		}
		
		quarterList.get(0).getElement().getStyle().setPosition(Position.RELATIVE);
		quarterList.get(0).getElement().getStyle().setRight(100, Unit.PX);
		quarterList.get(0).getElement().getStyle().setTop(50, Unit.PX);
		
		//positionQuarters();
	
		cdQuarterContainer.getElement().getStyle().setMargin(300, Unit.PX);
	
		
		for(int i = 0;i < quarterList.size();i++)
			cdQuarterContainer.add(quarterList.get(i));
		
		add(cdQuarterContainer);
	}
	
	private void positionQuarters() {
		int marginRightPx = 500;
		int liftPx = 50;
		int shiftRightPx = formatter(quarterList.get(0).getElement().getStyle().getWidth());
		int j = 0;
		while(j == 0 || j == 3 || j == 6) {
			
			quarterList.get(j).getElement().getStyle().setMarginRight(marginRightPx, Unit.PX);
			quarterList.get(j + 1).getElement().getStyle().setMarginRight(marginRightPx - 50, Unit.PX);
			quarterList.get(j + 1).getElement().getStyle().setMarginBottom(liftPx, Unit.PX);
			quarterList.get(j + 2).getElement().getStyle().setMarginRight(marginRightPx, Unit.PX);
			
			j += 3;
		}
	}
	
	private int formatter(String str) {
		str =  str.replace("px","");
		return Integer.parseInt(str);
	}

}