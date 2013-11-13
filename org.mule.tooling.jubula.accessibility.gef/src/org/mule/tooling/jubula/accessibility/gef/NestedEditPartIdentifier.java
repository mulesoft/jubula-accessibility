package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.NestedContainerEditPart;

public class NestedEditPartIdentifier extends EntityEditPartIdentifier<NestedContainerEditPart>{

	public NestedEditPartIdentifier(NestedContainerEditPart editPart)
	{
	super(editPart);
}

@Override
public String getIdentifier() {
	return getEditPart().getEntity().getName();
}
}
