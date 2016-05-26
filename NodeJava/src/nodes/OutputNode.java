package nodes;

import java.util.ArrayList;

import interfaces.INode;
import interfaces.IOutputNode;

public class OutputNode implements IOutputNode {

	private ArrayList<INode> outputNodes = new ArrayList<INode>();
	private ArrayList<Boolean> values = new ArrayList<Boolean>();
	private int inputAmount;
	
	public OutputNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 1;
	}
	
	@Override
	public void doAction() {
		sendOutput();
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
		return new OutputNode();
	}

	@Override
	public void sendOutput() {
		for(Boolean b : values) {
			System.out.println("Output: " + b);
		}
	}
}