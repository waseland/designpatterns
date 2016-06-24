package interfaces;

import visitor.InputNodeVisitor;

public interface IInputNode extends INode {
	public void accept(InputNodeVisitor inputNodeVisitor);
}
