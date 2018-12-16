package createShowSchedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.util.Pair;

public class Main {	
	private static boolean fileIsValid(String filename) {
		File file = new File(filename);
		if (file.exists()) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		final Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the file:");
		String filename = "../input/" + scan.next();
		
		if (!fileIsValid(filename)) {
			System.out.println("File could not be found.\n");
			return;
		}
		
		FileReader fr = null;
		try {
			fr = new FileReader(System.getProperty("user.dir") + "/" + filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		BufferedReader br = new BufferedReader(fr);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ShowSchedule showSchedule = gson.fromJson(br, ShowSchedule.class);
		
//		System.out.println("<li class=\"events-group\">");
//		System.out.println("\t<div class=\"top-info\">");
//		System.out.println("\t\t<span>Sunday</span>");
//		System.out.println("\t</div>");
//		System.out.println();
//		System.out.println("\t<ul>");

		// Generate HTML
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/output/htmloutput.html");
			for (Show show : showSchedule.showSchedule) {
				fw.write("\t\t<li class=\"single-event\" data-start=\"" + show.dataStart + "\" data-end=\""+ show.dataEnd + "\" data-content=\"" + show.showID + "\" data-event=\"event\">\n");
				fw.write("\t\t\t<a href=\"#0\">\n");
				fw.write("\t\t\t\t<em class=\"event-name\">" + show.eventName + "</em>\n");
				fw.write("\t\t\t\t<em class=\"dj-name\">" + show.djName + "</em>\n");
				fw.write("\t\t\t</a>\n");
				fw.write("\t\t</li>\n");
			}
			fw.close();
		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe.getMessage() + "\n");
		} catch (Exception e) {
			System.out.println("A general exception occurred.\n");
		}
	
		// Generate Javascript
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/output/jsoutput.js");
			for (Show show : showSchedule.showSchedule) {
				fw.write("if (showName == \"" + show.eventName + "\") {\n");
				fw.write("\tvar str = \"<div id=\'" +  show.showID + "\' class='content-loaded'>\";\n");
				if (!show.description.equals("")) {
					fw.write("\tstr += \"<p style=\'color: black\'>" + show.description + "</p><br>\";\n");
				}
				
				for (Pair<String, String> media : show.media.getMedia()) {
					fw.write("\tstr += \"<a href=\'" + media.getValue() + "\' target=\'_blank\'>View Show on " + media.getKey() + "</a><br>\";\n");
				}
				fw.write("\tstr += \'</div>\';\n");
				
				fw.write("\treturn str;\n");
				fw.write("}\n");
			}
			fw.close();
		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe.getMessage() + "\n");
		} catch (Exception e) {
			System.out.println("A general exception occurred.\n");
		}		
		System.out.println("Finished generating and outputting code to htmloutput.html and jsoutput.js.");
	}
}
