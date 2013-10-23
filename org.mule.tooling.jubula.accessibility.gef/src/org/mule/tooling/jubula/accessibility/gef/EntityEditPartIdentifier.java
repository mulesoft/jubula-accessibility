package org.mule.tooling.jubula.accessibility.gef;

import java.util.Collections;
import java.util.Map;

import org.eclipse.jubula.rc.rcp.e3.gef.identifier.IEditPartIdentifier;
import org.mule.tooling.messageflow.editpart.EntityEditPart;
import org.mule.tooling.model.messageflow.MessageFlowEntity;

public class EntityEditPartIdentifier<T extends EntityEditPart<? extends MessageFlowEntity>> implements IEditPartIdentifier {

	private T editPart;

	public EntityEditPartIdentifier(T editPart) {
		super();
		this.editPart = editPart;
	}

	public void setEditPart(T editPart) {
		this.editPart = editPart;
	}

	public T getEditPart() {
		return editPart;
	}

	/**
	 * We don't work around this anchor concept in Studio, no need to implement
	 * this.
	 */
	@Override
	public Map<?, ?> getConnectionAnchors() {
		return Collections.EMPTY_MAP;
	}

	/**
	 * By default, return this entity's entityId attribute. Subclass and
	 * override this method for a more precise description of this edit part.
	 */
	@Override
	public String getIdentifier() {
		return this.editPart.getClass().getSimpleName();
	}
}
