package program;

import controller.NodeHolder;
import controller.PathReader;
import factory.Factory;
import interfaces.INode;
import view.MainWindow;

public class Program {

	public static void main(String[] args) {
		test();
		
	}
	
	public static void test() {
		MainWindow mw = new MainWindow();
		NodeHolder nodeFactory = new NodeHolder(mw);
		mw.setInput(nodeFactory);
		
/*		nodeFactory.createNodes("C:/Repositories/designpatterns/Bestanden/circuit1.txt");
		nodeFactory.start();
		nodeFactory.showNodes();*/
	}
	
	

}
