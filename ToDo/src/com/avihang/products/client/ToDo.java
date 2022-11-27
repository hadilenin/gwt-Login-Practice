package com.avihang.products.client;

import org.eclipse.jetty.util.log.Log;

import com.avihang.frameworks.ags.client.AGSEntryPoint;
import com.avihang.frameworks.ags.client.template.AMDBC_LoginPageUI;
import com.avihang.frameworks.ags.client.utils.AMDBC_NavigationUtil;
import com.google.gwt.user.client.DOM;


public class ToDo extends AGSEntryPoint {
	@Override
	public void initialize(String initializationResult) {
		AMDBC_NavigationUtil.navigateTo(new Login());
		
	}
}
