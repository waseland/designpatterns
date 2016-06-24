package nodes;

import java.util.ArrayList;

import interfaces.IInputNode;
import interfaces.INode;
import interfaces.IOutputHandler;
import visitor.InputNodeVisitor;

public class InputHighNode implements IInputNode {

	private ArrayList<INode> outputNodes = new ArrayList<INode>();
	private ArrayList<Boolean> values = new ArrayList<Boolean>();
	private int inputAmount;
	private String literalName;
	private String name = "INPUT_HIGH";
	private boolean isInput = true;
	private boolean isOutput = false;
	private IOutputHandler handler;
	
	public String getName() {
		return name;
	}
	
	public InputHighNode() {
		outputNodes = new ArrayList<INode>();
		inputAmount = 0;
	}
	
	@Override
	public void doAction() {
		for(INode node : outputNodes) {
			node.addValue(true);
		}
	}

	@Override
	public void addOutputNode(INode node) {
		outputNodes.add(node);
	}
	
	public void setOutputNodes(ArrayList<INode> outputNodes){
		this.outputNodes = outputNodes;
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
		if(values.size() == inputAmount) {
			doAction();
		}
	}

	@Override
	public INode copy() {
		return new InputHighNode();
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

	@Override
	public void accept(InputNodeVisitor inputNodeVisitor) {
		// TODO Auto-generated method stub
		inputNodeVisitor.visit(this);
	}
}
