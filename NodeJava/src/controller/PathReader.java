package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import view.ViewClass;

public class PathReader {

	public PathReader(){
		getPath();
	}
	public void getPath(){
		 ViewClass vc = new ViewClass();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("---------------------------");
		 System.out.println("Enter Pathname to text file");
		 
		 try {
			String pathName = br.readLine();
			
			Path path = Paths.get(pathName);
			if (!pathName.equals("") && Files.exists(path)) {
				vc.showText("Path is: " + path);
				if(pathName.endsWith(".txt")){
					vc.showText("Found the file!");
					getFile(pathName);
				}
				else{
					vc.showText("Filepath is not a .txt file");
					getPath();
				}
			}
			else{
				vc.showText("Filepath does not exist");
				getPath();
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
	};
	
	public void getFile(String path) throws FileNotFoundException{
		 try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null) {
			    System.out.println(line);
			}
		    fr.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	};
}