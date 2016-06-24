package visitor;

import controller.NodeHolder;
import nodes.InputHighNode;
import nodes.InputLowNode;

public interface InputNodeVisitor {
	
	public void visit(InputLowNode low);
	public void visit(InputHighNode high);

}
