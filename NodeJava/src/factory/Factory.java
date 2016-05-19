/*
 * met dank aan Mark van Velthoven
 */

package factory;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import interfaces.INode;

public class Factory {

	private static final Map<String, INode> commands;
	private static final ServiceLoader<INode> loader;
	
	static {
		commands = new HashMap<String, INode>();
		loader = ServiceLoader.load(INode.class);
		
		for (INode command : loader) {
			commands.put(command.getClass().getSimpleName(), command);
		}
	}
	
	public static final INode create(final String name) {
		if (commands.containsKey(name)) {
			return commands.get(name).copy();
		}
		
		final String message = String.format("Command '%s' was not found, is the services file up to date?", name);
		throw new IllegalArgumentException(message);
	}

}
