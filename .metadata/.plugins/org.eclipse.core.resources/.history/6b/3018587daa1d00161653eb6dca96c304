/*
 * met dank aan Mark van Velthoven
 */

package com.avans.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import com.avans.factory.commands.AbstractCommand;

public class Factory {

	private static final Map<String, AbstractCommand> commands;
	private static final ServiceLoader<AbstractCommand> loader;
	
	static {
		commands = new HashMap<String, AbstractCommand>();
		loader = ServiceLoader.load(AbstractCommand.class);
		
		for (AbstractCommand command : loader) {
			commands.put(command.getClass().getSimpleName(), command);
		}
	}
	
	public static final AbstractCommand create(final String name) {
		if (commands.containsKey(name)) {
			return commands.get(name).copy();
		}
		
		final String message = String.format("Command '%s' was not found, is the services file up to date?", name);
		throw new IllegalArgumentException(message);
	}

}
