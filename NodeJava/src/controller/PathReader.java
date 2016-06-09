package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import interfaces.IOutputHandler;
import view.ViewClass;

public class PathReader {

	private IOutputHandler output;
	
	public PathReader(IOutputHandler output){
		this.output = output;
	}
	
	public PathReader(){
		this.output = new ViewClass();
	}
	
	public ArrayList<String> getLines(String pathString){
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 try {
			Path path = Paths.get(pathString);
			if (!pathString.equals("") && Files.exists(path)) {
				output.write("Path is: " + path);
				if(pathString.toLowerCase().endsWith(".txt")){
					output.write("Found the file!");
					//Returns the file as an ArrayList of Strings.
					return getFile(pathString);
				}
				else{
					output.write("Filepath is not a .txt file");
				}
			}
			else{
				//vc.showText("Filepath does not exist");
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		 
		return null;
	};
	
	private ArrayList<String> getFile(String path) throws FileNotFoundException{
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null) {
			    list.add(line);
			}
		    fr.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return list;
	};
}
