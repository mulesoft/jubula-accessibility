package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.ScopeEditPart;

public class ScopeEditPartIdentifier extends EntityEditPartIdentifier<ScopeEditPart>{

	public ScopeEditPartIdentifier(ScopeEditPart editPart)
	{
	super(editPart);
}

@Override
public String getIdentifier() {
	return getEditPart().getEntity().getName();
}
}
