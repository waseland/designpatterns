package visitor;

import nodes.InputHighNode;
import nodes.InputLowNode;
import controller.NodeHolder;

public class InputNodeDisplayVisitor implements	InputNodeVisitor{
	
	private NodeHolder nodeholder;
	
	public InputNodeDisplayVisitor(NodeHolder nodeholder){
		this.nodeholder = nodeholder;
	}
	
	@Override
	public void visit(InputLowNode low) {
		String s = low.getLiteralName();
		InputHighNode tempnode =  new InputHighNode();
		tempnode.setOutputNodes(low.getOutputNodes());
		tempnode.setLiteralName(low.getLiteralName());
		nodeholder.getNodes().remove(s);
		nodeholder.getNodes().put(s, tempnode);
		nodeholder.getInputNodes().remove(s);
		nodeholder.getInputNodes().put(s, tempnode);
	}
	@Override
	public void visit(InputHighNode high) {
		String s = high.getLiteralName();
		InputLowNode tempnode =  new InputLowNode();
		tempnode.setOutputNodes(high.getOutputNodes());
		tempnode.setLiteralName(high.getLiteralName());
		nodeholder.getNodes().remove(s);
		nodeholder.getNodes().put(s, tempnode);
		nodeholder.getInputNodes().remove(s);
		nodeholder.getInputNodes().put(s, tempnode);
	}

}
