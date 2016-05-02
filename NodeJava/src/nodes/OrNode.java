package nodes;

import java.util.ArrayList;

import interfaces.INode;

public class OrNode implements INode{

	private ArrayList<INode> outputNodes;
	private ArrayList<Boolean> values;
	private int inputAmount;
	
	public OrNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 1;
	}
	
	@Override
	public void doAction() {
		Boolean output = false;
		
		//OR, if one of the values is true, send true. Otherwise send false.
		for(Boolean value : values) {
			if(value == true) {
				output = true;
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
}