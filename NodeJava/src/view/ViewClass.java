package view;

import java.util.ArrayList;

import interfaces.IOutputHandler;

public class ViewClass implements IOutputHandler {
	@Override
	public void doOutput(String name, boolean value) {
		System.out.println(name + ": " + value);
	}

	@Override
	public void write(String s) {
		System.out.println(s);
	}

	@Override
	public void sendNodeValues(String name, String type, ArrayList<Boolean> inputs, boolean output, long time) {
		System.out.print("Node " + name + "(" + type + ") received inputs ");
		
		for(Boolean b : inputs) {
			System.out.print(b + " ");
		}
		
		System.out.print("and sent ouput " + output + " in " + time + " nanoseconds.\n");
	}
}

