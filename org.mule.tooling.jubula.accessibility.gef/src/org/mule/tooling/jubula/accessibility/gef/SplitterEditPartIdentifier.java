package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.SplitterEditPart;

public class SplitterEditPartIdentifier extends EntityEditPartIdentifier<SplitterEditPart> {
	
	public SplitterEditPartIdentifier(SplitterEditPart editPart) {
		super(editPart);
	}

	@Override
	public String getIdentifier() {
		return getEditPart().getEntity().getName();
	}
}
