package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.EndpointEditPart;

public class EndpointEditPartIdentifier extends EntityEditPartIdentifier {

	private EndpointEditPart editPart;

	public EndpointEditPartIdentifier(Object adaptable) {
		super(adaptable);
		editPart = (EndpointEditPart) adaptable;
	}

	@Override
	public String getIdentifier() {
		return editPart.getEntity().getName();
	}

}
