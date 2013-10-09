package org.eclipse.jubula.rc.swt.implclasses;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jubula.rc.common.exception.ComponentNotFoundException;
import org.eclipse.jubula.rc.common.exception.StepExecutionException;
import org.eclipse.swt.widgets.Control;
import org.mule.tooling.ui.widgets.tab.TabbedPropertyList;
import org.mule.tooling.ui.widgets.tab.TabbedPropertyList.ListElement;

public class ConfigWindowTabsControlImplClass extends AbstractControlImplClass {

	public void selectTab(String tabName) throws StepExecutionException {
		TabbedPropertyList tabbedComponent = (TabbedPropertyList) getComponent();
		List<ListElement> elements = Arrays.asList(tabbedComponent.getElements());
		ListElement targetListElement = null;
		for (ListElement listElement : elements) {
			if (tabName.equals(listElement.getTabItem().getText())) {
				targetListElement = listElement;
				break;
			}
		}
		if (targetListElement != null) {
			tabbedComponent.select(elements.indexOf(targetListElement));
		} else {
			throw new StepExecutionException(new ComponentNotFoundException("Tab with name " + tabName + " not found", null));
		}
	}

	// copied from SimpleExtendedComponentImplClass

	/** the tested component */
	private Control control;

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void setComponent(Object graphicsComponent) {
		control = (Control) graphicsComponent;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String[] getTextArrayFromComponent() {
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Control getComponent() {
		return control;
	}

}
