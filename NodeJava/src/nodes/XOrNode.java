package nodes;

import java.util.ArrayList;

import interfaces.INode;

public class XOrNode implements INode {

	private ArrayList<INode> outputNodes;
	private ArrayList<Boolean> values;
	private int inputAmount;
	
	public XOrNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 2;
	}
	
	@Override
	public void doAction() {
		Boolean output = false;
		
		//When both inputs are different, send true.
		if(values.size() == 2) {
			if(values.get(0) != values.get(1)) {
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

	/**
	 * This node only accepts 2 inputs.
	 */
	@Override
	public void setInputAmount(int inputAmount) {
		if(inputAmount == 2) {
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