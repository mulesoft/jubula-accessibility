package org.mule.tooling.jubula.accessibility.gef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
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
		int indexOfPart = 0;
		String simpleName = editPart.getClass().getSimpleName();

		EditPart parent = editPart.getParent();
		if (parent != null) {
			indexOfPart = getIndexOfPartInParent(parent);
			if (indexOfPart < 0) {
				throw new RuntimeException("editPart is not a child of it's parent");
			}
		}

		String suffix = indexOfPart > 0 ? String.valueOf(indexOfPart) : "";
		return simpleName + suffix;
	}

	private int getIndexOfPartInParent(EditPart parent) {
		List<EditPart> siblings = new ArrayList<EditPart>();
		@SuppressWarnings("unchecked")
		List<EditPart> children = parent.getChildren();
		for (EditPart child : children) {
			if (child.getClass().equals(editPart.getClass())) {
				siblings.add(child);
			}
		}
		return siblings.indexOf(editPart);
	}
}
