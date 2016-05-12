package program;

import controller.NodeFactory;
import controller.PathReader;

public class Program {

	public static void main(String[] args) {
		
		/*PathReader pr = new PathReader();
		
		for(String s : pr.getLines("C:/Users/Marthijn/Documents/GitHub/designpatterns/Bestanden/circuit1.txt")) {
			System.out.println(s);
		}*/
		
		NodeFactory factory = new NodeFactory();
		
		factory.createNodes();

	}
	
	

}
