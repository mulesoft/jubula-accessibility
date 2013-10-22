package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.FlowEditPart;
import org.mule.tooling.model.messageflow.Flow;
import org.mule.tooling.model.messageflow.decorator.EntityDecorator;

public class FlowEditPartIdentifier extends EntityEditPartIdentifier<FlowEditPart> {

	
	
	public FlowEditPartIdentifier(FlowEditPart editPart) {
		super(editPart);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getIdentifier() {
		EntityDecorator<Flow> entityDecorator = getEditPart().getEntityDecorator();
		return entityDecorator.getEntity().getName();
	}

}
