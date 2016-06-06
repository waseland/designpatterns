package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import factory.Factory;
import interfaces.IInputNode;
import interfaces.INode;
import interfaces.IOutputHandler;
import interfaces.IOutputNode;
import view.ViewClass;

public class NodeFactory {
	private Map<String, IInputNode> inputNodes = new HashMap<String, IInputNode>();
	private Map<String, INode> nodes = new HashMap<String, INode>();
	private Map<String, IOutputNode> outputNodes = new HashMap<String, IOutputNode>();
	private IOutputHandler handler = new ViewClass();
	// private Map<String, String> nodeTypes = new HashMap<String, String>();

	public NodeFactory() {
		/*
		 * nodeTypes.put("AND", ""); nodeTypes.put("NOT", "");
		 * nodeTypes.put("NAND", ""); nodeTypes.put("NOR", "");
		 * nodeTypes.put("OR", ""); nodeTypes.put("XOR", "");
		 */
	}

	public ArrayList<IInputNode> createCircuit() {
		return null;
	}

	public void createNodes(String url) {
		PathReader pr = new PathReader();

		// "C:/Users/Marthijn/Documents/GitHub/designpatterns/Bestanden/circuit1.txt"

		for (String s : pr.getLines(url)) {
			if (!s.startsWith("#") && !s.isEmpty()) {

				if (s.contains(":") && s.endsWith(";")) {
					s = s.replace(";", "");
					s = s.replaceAll("\\s+", "");

					String[] parts = s.split(":", 2);

					String name = parts[0];
					String type = parts[1];
					
					if (!nodes.containsKey(name)) {
						try {
							INode node = Factory.createFromName(type);
							node.setLiteralName(name);
							
							if (node.isInput()) {
								inputNodes.put(name, (IInputNode) node);
							} else if (node.isOutput()) {
								IOutputNode newNode = (IOutputNode) node;
								newNode.setOutputHandler(handler);
								outputNodes.put(name, (IOutputNode) newNode);
							}
							nodes.put(name, node);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						INode node = nodes.get(name);
						String[] names = type.split(",");
						for(String n : names) {
							node.addOutputNode(nodes.get(n));
							nodes.get(n).heightenInputAmount();
						}
						// Find name, add output.
					}
				}
			}
		}
	}
	
	public void start() {
		for(String s : inputNodes.keySet()) {
			inputNodes.get(s).doAction();
		}
	}
	
	public void showNodes() {
		for(String name : nodes.keySet()) {
			String outputs = "";
			for(INode n : nodes.get(name).getOutputNodes()) {
				outputs += n.getLiteralName() + ", ";
			}
			if(nodes.get(name).getOutputNodes().size() < 1) {
				outputs = "FINAL";
			}
			handler.write("NODE: " + nodes.get(name).getLiteralName() + " - OUTPUT: " + outputs);
		}
	}

	public INode createSingleNode(String name, String type) {

		return null;
	}
}
