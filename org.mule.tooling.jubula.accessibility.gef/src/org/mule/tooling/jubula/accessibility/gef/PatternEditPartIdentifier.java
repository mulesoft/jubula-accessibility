package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.PatternEditPart;

public class PatternEditPartIdentifier extends EntityEditPartIdentifier {

	PatternEditPart editPart;

	public PatternEditPartIdentifier(Object adaptable) {
		super(adaptable);
		editPart = (PatternEditPart) adaptable;
	}

	@Override
	public String getIdentifier() {
		return editPart.getEntity().getName();
	}

}
