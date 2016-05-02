package nodes;

import java.util.ArrayList;

import interfaces.INode;

public class NotAndNode implements INode{

	private ArrayList<INode> outputNodes;
	private ArrayList<Boolean> values;
	private int inputAmount;
	
	public NotAndNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 1;
	}
	
	@Override
	public void doAction() {
		Boolean output = false;
		
		//NAND, if all values are true, send false, otherwise send true.
		for(Boolean value : values) {
			if(value == false) {
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