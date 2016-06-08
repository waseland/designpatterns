package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IInputHandler {
	public void start();
	public boolean setCircuit(String s);
	public void showCircuit();
	public Map<String, IInputNode> getInputNodes();
	public void changeInputNodes(List<String> temp);
}