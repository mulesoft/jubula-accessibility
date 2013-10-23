package org.eclipse.jubula.rc.swt.implclasses;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jubula.rc.common.exception.ComponentNotFoundException;
import org.eclipse.jubula.rc.common.exception.StepExecutionException;
import org.eclipse.jubula.rc.common.tester.WidgetTester;
import org.eclipse.swt.widgets.Display;
import org.mule.tooling.messageflow.dialog.IItem;
import org.mule.tooling.properties.widget.VerticalPropertiesTabFolder;

public class VerticalPropertiesTabTester extends WidgetTester {

	public void selectTab(final String tabName) throws StepExecutionException {
		Display currentDisplay = Display.getCurrent();
		Display display = currentDisplay != null ? currentDisplay : Display.getDefault();
		display.syncExec(new Runnable() {

			@Override
			public void run() {
				doSelectTab(tabName);
			}
		});
	}

	private void doSelectTab(String tabName) {
		VerticalPropertiesTabFolder propertiesTab = getPropertiesTab();
		List<IItem> items = Arrays.asList(propertiesTab.getItems());
		IItem targetItem = null;
		for (IItem item : items) {
			if (tabName.equals(item.getText())) {
				targetItem = item;
				break;
			}
		}
		if (targetItem != null) {
			propertiesTab.setSelection(items.indexOf(targetItem));
		} else {
			throw new StepExecutionException(new ComponentNotFoundException("Tab with name " + tabName + " not found", null));
		}
	}

	private VerticalPropertiesTabFolder getPropertiesTab() {
		return (VerticalPropertiesTabFolder) getRealComponent();
	}

}
