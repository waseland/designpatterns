package nodes;

import java.util.ArrayList;

import interfaces.INode;

public class NotNode implements INode{

	private ArrayList<INode> outputNodes = new ArrayList<INode>();
	private ArrayList<Boolean> values = new ArrayList<Boolean>();
	private int inputAmount;
	
	public NotNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 1;
	}
	
	@Override
	public void doAction() {
		Boolean output = false;
		
		//When true, send false. When false, send true.
		if(values.size() == 1) {
			output = !values.get(0);
		}
		
		for(INode node : outputNodes) {
			node.addValue(output);
		}
	}

	@Override
	public void addOutputNode(INode node) {
		outputNodes.add(node);
	}

	/**
	 * This node only accepts 1 input.
	 */
	@Override
	public void setInputAmount(int inputAmount) {
		if(inputAmount == 1) {
			this.inputAmount = inputAmount;
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
		return new NotNode();
	}

}
