package org.mule.tooling.jubula.accessibility.gef;

import org.mule.tooling.messageflow.editpart.EndpointEditPart;
import org.mule.tooling.messageflow.editpart.EntityEditPart;
import org.mule.tooling.messageflow.editpart.FlowEditPart;
import org.mule.tooling.messageflow.editpart.PatternEditPart;
import org.mule.tooling.messageflow.editpart.SplitterEditPart;
import org.mule.tooling.model.messageflow.Compartment;
import org.mule.tooling.model.messageflow.CompartmentLane;
import org.mule.tooling.model.messageflow.Container;
import org.mule.tooling.model.messageflow.EndpointNode;
import org.mule.tooling.model.messageflow.Flow;
import org.mule.tooling.model.messageflow.GlobalElement;
import org.mule.tooling.model.messageflow.GlobalUnknown;
import org.mule.tooling.model.messageflow.MessageFlowEntity;
import org.mule.tooling.model.messageflow.MuleConfiguration;
import org.mule.tooling.model.messageflow.MultiSourceNode;
import org.mule.tooling.model.messageflow.NestedContainer;
import org.mule.tooling.model.messageflow.PatternNode;
import org.mule.tooling.model.messageflow.ResponseNode;
import org.mule.tooling.model.messageflow.ScopeNode;
import org.mule.tooling.model.messageflow.SplitterNode;
import org.mule.tooling.model.messageflow.UnknownNode;
import org.mule.tooling.model.messageflow.util.MessageFlowEntityVisitor;

final class EditPartIdentifierEntityVisitor implements MessageFlowEntityVisitor {
	private EntityEditPartIdentifier<? extends EntityEditPart<?>> identifier;
	private EntityEditPart<? extends MessageFlowEntity> editPart;

	public EditPartIdentifierEntityVisitor(EntityEditPart<? extends MessageFlowEntity> editPart) {
		super();
		this.editPart = editPart;
	}

	public EntityEditPartIdentifier<? extends EntityEditPart<?>> getIdentifier() {
		if (identifier == null) {
			identifier = new EntityEditPartIdentifier<EntityEditPart<?>>(editPart);
		}
		return identifier;
	}

	@Override
	public void visitUnknownNode(UnknownNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitSplitterNode(SplitterNode arg0) {
		identifier = new SplitterEditPartIdentifier((SplitterEditPart) editPart);
	}

	@Override
	public void visitScopeNode(ScopeNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitResponseNode(ResponseNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPatternNode(PatternNode pattern) {
		identifier = new PatternEditPartIdentifier((PatternEditPart) editPart);
	}

	@Override
	public void visitNestedContainer(NestedContainer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitMultiSourceNode(MultiSourceNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitMuleConfiguration(MuleConfiguration arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitGlobalUnknown(GlobalUnknown arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitGlobalElement(GlobalElement arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitFlow(Flow arg0) {
		identifier = new FlowEditPartIdentifier((FlowEditPart) editPart);
	}

	@Override
	public void visitEndpointNode(EndpointNode arg0) {
		identifier = new EndpointEditPartIdentifier((EndpointEditPart) editPart);
	}

	@Override
	public void visitContainer(Container arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitCompartmentLane(CompartmentLane arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitCompartment(Compartment arg0) {
		// TODO Auto-generated method stub

	}
}