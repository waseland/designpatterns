package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import org.junit.Test;

import controller.NodeHolder;
import interfaces.INode;
import nodes.AndNode;

public class NodeTest {

	/**
	 *  Create a node and test if the didWork function returns false if not enough input is supplied.
	 */
	@Test
	public void testNode() {
		AndNode andNode = new AndNode();
		andNode.setInputAmount(2);
		assertEquals("didWork() to return false", false, andNode.didWork());
	}
	
	/**
	 *  Test if the NodeHolder returns false when a wrong filetype is supplied.
	 */
	@Test
	public void testCreateCircuit() {
		NodeHolder holder = new NodeHolder();
		
		assertEquals("createCircuit() to return false", false, holder.setCircuit("test.pdf"));
		assertEquals("createCircuit() to return false", true, holder.getInputNodes().isEmpty());
	}
	
	
	/**
	 *  Test if a known working circuit's nodes all worked.
	 */
	@Test
	public void testRunCircuit() {		
		NodeHolder holder = new NodeHolder();
		
		assertEquals("createCircuit() to return true", true, holder.setCircuit("C:/Users/Marthijn/Documents/GitHub/designpatterns/Bestanden/circuit1.txt"));
		holder.start();
		assertEquals("inputNodes to be not null", false, holder.getInputNodes().isEmpty());
		assertEquals("outputNodes to be not null", false, holder.getOutputNodes().isEmpty());
		assertEquals("all nodes to have worked", true, checkAllNodes(holder.getNodes()));
	}
		
	private boolean checkAllNodes(Map<String, INode> nodes) {
		boolean didWork = true;
		
		for(String s : nodes.keySet()) {
			if(!nodes.get(s).didWork())
			{
				didWork = false;
			}
		}
		return didWork;
	}

}
