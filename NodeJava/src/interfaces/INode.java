package interfaces;

import java.util.ArrayList;

public interface INode extends Cloneable {
	public void doAction();
	public void addValue(Boolean value);
	public void addOutputNode(INode node);
	public void setInputAmount(int inputAmount);
	public void heightenInputAmount();
	public ArrayList<INode> getOutputNodes();
	public boolean isInput();
	public boolean isOutput();
	public String getLiteralName();
	public void setLiteralName(String name);
	public void clearValues();
	public boolean didWork();
	public void setOutputHandler(IOutputHandler handler);
	
	INode copy();
	String getName();
}
