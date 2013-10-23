package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.EndpointEditPart;

public class EndpointEditPartIdentifier extends EntityEditPartIdentifier<EndpointEditPart> {
	
	public EndpointEditPartIdentifier(EndpointEditPart editPart) {
		super(editPart);
		
	}

	@Override
	public String getIdentifier() {
		return getEditPart().getEntity().getName();
	}

}
