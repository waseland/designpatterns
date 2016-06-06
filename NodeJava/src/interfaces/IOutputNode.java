package interfaces;

public interface IOutputNode extends INode {
	public void sendOutput();
	public void setOutputHandler(IOutputHandler handler);
}
