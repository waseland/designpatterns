package interfaces;

public interface INode {
	public void doAction();
	public void addValue(Boolean value);
	public void addOutputNode(INode node);
	public void setInputAmount(int inputAmount);
}
