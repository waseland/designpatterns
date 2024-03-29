package nodes;

import java.util.ArrayList;

import interfaces.INode;
import interfaces.IOutputHandler;

public class NotOrNode implements INode{

	private ArrayList<INode> outputNodes = new ArrayList<INode>();
	private ArrayList<Boolean> values = new ArrayList<Boolean>();
	private int inputAmount;
	private String literalName;
	private String name = "NOR";
	private boolean isInput = false;
	private boolean isOutput = false;
	private IOutputHandler handler;
	
	public String getName() {
		return name;
	}
	
	public NotOrNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 0;
	}
	
	@Override
	public void doAction() {
		long start_time = System.nanoTime();
		
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
		
		long end_time = System.nanoTime();
		
		if(handler != null) {
			handler.sendNodeValues(this.getLiteralName(), name, values, output, (end_time-start_time));
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
	
	@Override
	public void setOutputHandler(IOutputHandler handler) {
		this.handler = handler;
	}

}
