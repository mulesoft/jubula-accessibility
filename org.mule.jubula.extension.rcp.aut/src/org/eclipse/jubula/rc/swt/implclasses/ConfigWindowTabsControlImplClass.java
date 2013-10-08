package org.eclipse.jubula.rc.swt.implclasses;

import org.mule.tooling.ui.widgets.tab.TabbedPropertyList;

public class ConfigWindowTabsControlImplClass extends
		SimpleExtendedComponentImplClass {

	//Public methods are test steps 
	public void selectTab( String tabName ){
		TabbedPropertyList tabs = (TabbedPropertyList) getComponent();  
		tabs.select(2);
	}
	
}
