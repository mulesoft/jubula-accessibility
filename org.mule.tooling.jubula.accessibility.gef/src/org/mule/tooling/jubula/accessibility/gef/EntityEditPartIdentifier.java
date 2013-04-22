package org.mule.tooling.jubula.accessibility.gef;

import java.util.Collections;
import java.util.Map;

import org.eclipse.jubula.rc.rcp.gef.identifier.IEditPartIdentifier;
import org.mule.tooling.messageflow.editpart.EntityEditPart;
import org.mule.tooling.model.messageflow.MessageFlowEntity;

public class EntityEditPartIdentifier implements IEditPartIdentifier {

	private EntityEditPart<MessageFlowEntity> entityEditPart;

	@SuppressWarnings("unchecked")
	public EntityEditPartIdentifier(Object editPart) {
		this.entityEditPart = (EntityEditPart<MessageFlowEntity>) editPart;
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
		return this.entityEditPart.getClass().getSimpleName();
	}
}
