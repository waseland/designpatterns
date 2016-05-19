package interfaces;

public interface INode extends Cloneable {
	public void doAction();
	public void addValue(Boolean value);
	public void addOutputNode(INode node);
	public void setInputAmount(int inputAmount);
	
	INode copy();
}
