package nodes;

import java.util.ArrayList;

import interfaces.INode;

public class InputNode implements INode {

	private ArrayList<INode> outputNodes = new ArrayList<INode>();
	private ArrayList<Boolean> values = new ArrayList<Boolean>();
	private int inputAmount;
	
	public InputNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 1;
	}
	
	@Override
	public void doAction() {
		for(INode node : outputNodes) {
			System.out.println(values.get(0));
			node.addValue(values.get(0));
		}
	}
	
	@Override
	public void addOutputNode(INode node) {
		outputNodes.add(node);
	}

	@Override
	public void setInputAmount(int inputAmount) {
		if(inputAmount == 1) {
			this.inputAmount = inputAmount;
		} else {
			this.inputAmount = 1;
		}
	}

	@Override
	public void addValue(Boolean value) {
		values.add(value);
		if(values.size() == inputAmount) {
			doAction();
		}
	}

	@Override
	public INode copy() {
		return new InputNode();
	}
}
