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

import view.ViewClass;

public class PathReader {

	public PathReader(){
		//getPath();
	}
	
	public ArrayList<String> getLines(String pathString){
		 ViewClass vc = new ViewClass();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("---------------------------");
		 System.out.println("Enter Pathname to text file");
		 
		 try {
			//String pathName = br.readLine();
			
			Path path = Paths.get(pathString);
			if (!pathString.equals("") && Files.exists(path)) {
				vc.write("Path is: " + path);
				if(pathString.endsWith(".txt")){
					vc.write("Found the file!");
					//Returns the file as an ArrayList of Strings.
					return getFile(pathString);
				}
				else{
					vc.write("Filepath is not a .txt file");
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
