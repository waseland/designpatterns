package nodes;

import java.util.ArrayList;

import interfaces.INode;

public class NotNode implements INode{

	private ArrayList<INode> outputNodes = new ArrayList<INode>();
	private ArrayList<Boolean> values = new ArrayList<Boolean>();
	private int inputAmount;
	private String literalName;
	private String name = "NOT";
	private boolean isInput = false;
	private boolean isOutput = false;
	
	public String getName() {
		return name;
	}
	
	public NotNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 0;
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
	
	@Override
	public boolean isInput() {
		return isInput;
	}

	@Override
	public boolean isOutput() {
		return isOutput;
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

	@Override
	public void heightenInputAmount() {
		inputAmount++;
	}
	
	@Override
	public ArrayList<INode> getOutputNodes() {
		return outputNodes;
	}
	
	@Override
	public String getLiteralName() {
		return literalName;
	}

	@Override
	public void setLiteralName(String name) {
		this.literalName = name;	
	}
}
