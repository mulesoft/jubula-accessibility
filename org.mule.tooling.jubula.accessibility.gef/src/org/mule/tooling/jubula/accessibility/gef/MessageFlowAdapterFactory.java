package org.mule.tooling.jubula.accessibility.gef;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.gef.EditPart;
import org.eclipse.jubula.rc.rcp.gef.identifier.IEditPartIdentifier;
import org.mule.tooling.messageflow.editpart.EndpointEditPart;
import org.mule.tooling.messageflow.editpart.FlowEditPart;
import org.mule.tooling.messageflow.editpart.PatternEditPart;

public class MessageFlowAdapterFactory implements IAdapterFactory {

	private static final Map<Class<? extends EditPart>, Class<? extends EntityEditPartIdentifier>> adapterClassesMap;

	static {
		adapterClassesMap = new HashMap<Class<? extends EditPart>, Class<? extends EntityEditPartIdentifier>>();

		// add specific identifiers for edit parts that could be identified in a
		// cool way
		adapterClassesMap.put(PatternEditPart.class,
				PatternEditPartIdentifier.class);
		adapterClassesMap.put(EndpointEditPart.class,
				EndpointEditPartIdentifier.class);
		adapterClassesMap.put(FlowEditPart.class, FlowEditPartIdentifier.class);
	}

	@Override
	public Object getAdapter( //
			Object adaptable, //
			@SuppressWarnings("rawtypes") Class adapterType //
	) {
		if (adapterType == IEditPartIdentifier.class) {
			Class<? extends IEditPartIdentifier> identifierClass = this
					.getIdentifierClass(adaptable);
			return this.instantiate(identifierClass, adaptable);
		}
		return null;
	}

	private Class<? extends EntityEditPartIdentifier> getIdentifierClass(
			Object adaptable) {
		Class<? extends EntityEditPartIdentifier> identifierClass = adapterClassesMap
				.get(adaptable.getClass());
		if (identifierClass == null)
			// adaptable is an EntityEditPart, not specifically defined here
			// return a generic 'entityId-based' identifier
			identifierClass = EntityEditPartIdentifier.class;
		return identifierClass;
	}

	private IEditPartIdentifier instantiate( //
			Class<? extends IEditPartIdentifier> identifierClass, //
			Object adaptable //
	) {
		try {
			return identifierClass.getConstructor(Object.class).newInstance(
					adaptable);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Class<?>[] getAdapterList() {
		Collection<Class<? extends EditPart>> adaptableTypes = adapterClassesMap
				.keySet();
		return adaptableTypes.toArray(new Class[adaptableTypes.size()]);
	}

}
