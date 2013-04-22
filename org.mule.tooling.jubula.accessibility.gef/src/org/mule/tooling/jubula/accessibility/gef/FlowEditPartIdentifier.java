package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.FlowEditPart;
import org.mule.tooling.model.messageflow.Flow;
import org.mule.tooling.model.messageflow.decorator.EntityDecorator;

public class FlowEditPartIdentifier extends EntityEditPartIdentifier {

	FlowEditPart flowEditPart;

	public FlowEditPartIdentifier(Object flowEditPart) {
		super(flowEditPart);
		this.flowEditPart = (FlowEditPart) flowEditPart;
	}

	@Override
	public String getIdentifier() {
		EntityDecorator<Flow> entityDecorator = flowEditPart
				.getEntityDecorator();
		return entityDecorator.getEntity().getName();
	}

}
