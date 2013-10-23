package org.mule.tooling.jubula.accessibility.gef;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jubula.rc.rcp.e3.gef.identifier.IEditPartIdentifier;
import org.mule.tooling.messageflow.editpart.EndpointEditPart;
import org.mule.tooling.messageflow.editpart.EntityEditPart;
import org.mule.tooling.messageflow.editpart.FlowEditPart;
import org.mule.tooling.messageflow.editpart.PatternEditPart;
import org.mule.tooling.model.messageflow.MessageFlowEntity;

public class MessageFlowAdapterFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptable, @SuppressWarnings("rawtypes") Class adapterType) {
		if (adapterType == IEditPartIdentifier.class) {
			if (adaptable instanceof EntityEditPart<?>) {
				@SuppressWarnings("unchecked")
				EntityEditPart<? extends MessageFlowEntity> entityEditPart = (EntityEditPart<? extends MessageFlowEntity>) adaptable;
				MessageFlowEntity entity = entityEditPart.getEntity();
				EditPartIdentifierEntityVisitor visitor = new EditPartIdentifierEntityVisitor(entityEditPart);
				entity.accept(visitor);
				return visitor.getIdentifier();
			}
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		Class<?>[] adapters = { EntityEditPart.class, PatternEditPart.class, EndpointEditPart.class, FlowEditPart.class };
		return adapters;
	}

}
