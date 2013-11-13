package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.ContainerEditPart;

public class ContainerEditPartIdentifier extends EntityEditPartIdentifier<ContainerEditPart>{

	public ContainerEditPartIdentifier(ContainerEditPart editPart)
	{
	super(editPart);
}

@Override
public String getIdentifier() {
	return getEditPart().getEntity().getName();
}
}
