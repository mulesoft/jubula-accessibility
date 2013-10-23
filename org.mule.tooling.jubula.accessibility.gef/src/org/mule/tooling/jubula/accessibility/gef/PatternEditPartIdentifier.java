package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.PatternEditPart;

public class PatternEditPartIdentifier extends EntityEditPartIdentifier<PatternEditPart> {
	
	public PatternEditPartIdentifier(PatternEditPart editPart) {
		super(editPart);	
	}

	@Override
	public String getIdentifier() {
		return getEditPart().getEntity().getName();
	}

}
