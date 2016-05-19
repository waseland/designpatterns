package program;

import controller.NodeFactory;
import controller.PathReader;
import factory.Factory;
import interfaces.INode;

public class Program {

	public static void main(String[] args) {
		
		/*PathReader pr = new PathReader();
		
		for(String s : pr.getLines("C:/Users/Marthijn/Documents/GitHub/designpatterns/Bestanden/circuit1.txt")) {
			System.out.println(s);
		}*/
		
		//NodeFactory factory = new NodeFactory();
		
		//factory.createNodes();
		
		//Factory f = new Factory();
		test();
		
	}
	
	public static void test() {
		try 
		{
			final INode input = Factory.create("InputNode");
			final INode not = Factory.create("NotNode");
			final INode output = Factory.create("OutputNode");
			
			input.addOutputNode(not);
			not.addOutputNode(output);
			input.setInputAmount(1);
			input.addValue(true);
			
		} 
		catch ( IllegalArgumentException exception )
		{
			System.out.println( exception.getMessage() );
		}
	}
	
	

}
