package org.eclipse.jubula.rc.common.adapter;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jubula.rc.common.adaptable.IAdapterFactory;
import org.eclipse.jubula.rc.common.tester.adapter.interfaces.IWidgetComponent;
import org.eclipse.jubula.rc.swt.tester.adapter.WidgetAdapter;
import org.mule.tooling.properties.widget.VerticalPropertiesTabFolder;

public class StudioAdapterFactory implements IAdapterFactory {

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class targetedClass, Object objectToAdapt) {
		if (targetedClass.isAssignableFrom(IWidgetComponent.class)) {
			if (objectToAdapt instanceof VerticalPropertiesTabFolder) {
				return new WidgetAdapter(objectToAdapt);
			}
		}
		return null;
	}

	@Override
	public Class<?>[] getSupportedClasses() {
		@SuppressWarnings("unchecked")
		List<Class<VerticalPropertiesTabFolder>> supportedTypesAsList = Arrays.asList(VerticalPropertiesTabFolder.class);
		return (Class[]) supportedTypesAsList.toArray(new Class[supportedTypesAsList.size()]);
	}

}
