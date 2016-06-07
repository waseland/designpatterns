package nodes;

import java.util.ArrayList;

import interfaces.INode;
import interfaces.IOutputHandler;
import interfaces.IOutputNode;

public class OutputNode implements IOutputNode {

	private ArrayList<INode> outputNodes = new ArrayList<INode>();
	private ArrayList<Boolean> values = new ArrayList<Boolean>();
	private int inputAmount;
	private String name = "PROBE";
	private String literalName;
	private boolean isInput = false;
	private boolean isOutput = true;
	private IOutputHandler handler;
	
	public String getName() {
		return name;
	}

	public OutputNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 0;
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
			//System.out.println("Output: " + b);
			if(handler != null) {
				handler.doOutput(literalName, b);
			}
		}
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
	public void setOutputHandler(IOutputHandler handler) {
		this.handler = handler;
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
