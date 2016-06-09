package nodes;

import java.util.ArrayList;

import interfaces.INode;

public class OrNode implements INode{

	private ArrayList<INode> outputNodes = new ArrayList<INode>();
	private ArrayList<Boolean> values = new ArrayList<Boolean>();
	private int inputAmount;
	private String literalName;
	private String name = "OR";
	private boolean isInput = false;
	private boolean isOutput = false;
	
	public String getName() {
		return name;
	}
	
	public OrNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 0;
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

	@Override
	public INode copy() {
		return new OrNode();
	}
	
	@Override
	public boolean isInput() {
		return isInput;
	}

	@Override
	public boolean isOutput() {
		return isOutput;
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
	
	@Override
	public void clearValues() {
		this.values.clear();
	}
	
	@Override
	public boolean didWork() {
		if(values.size() == inputAmount || inputAmount < 1) {
			return true;
		} else {
			return false;
		}
	}
}
