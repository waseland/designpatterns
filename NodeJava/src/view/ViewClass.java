package view;

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
}

