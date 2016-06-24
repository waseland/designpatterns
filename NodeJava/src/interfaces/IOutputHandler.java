package interfaces;

import java.util.ArrayList;

public interface IOutputHandler {
	public void doOutput(String name, boolean value);
	public void sendNodeValues(String name, String type, ArrayList<Boolean> inputs, boolean output, long time);
	public void write(String s);
}
