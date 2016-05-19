package nodes;

import java.util.ArrayList;

import interfaces.INode;

public class NotOrNode implements INode{

	private ArrayList<INode> outputNodes = new ArrayList<INode>();
	private ArrayList<Boolean> values = new ArrayList<Boolean>();
	private int inputAmount;
	
	public NotOrNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 1;
	}
	
	@Override
	public void doAction() {
		Boolean output = true;
		
		//NOR, if all values are false, send true, otherwise send false.
		for(Boolean value : values) {
			if(value == true) {
				output = false;
			}
		}
		
		for(INode node : outputNodes) {
			node.addValue(output);
		}
		
	}

	@Override
	public void addOutputNode(INode node) {
		outputNodes.add(node);
	}

	@Override
	public void setInputAmount(int inputAmount) {
		if(inputAmount > 0) {
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
		return new NotOrNode();
	}

}
