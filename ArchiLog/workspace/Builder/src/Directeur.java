import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.*;

public class Directeur {
	
	private static Pattern boldPattern= Pattern.compile("(\\*\\*[^\\*]+\\*\\*)[\\.");
	private static Pattern italicPattern= Pattern.compile("(_[^_]+_|\\*[^\\*]+\\*)[\\.]");
	
	public void export(String mdFile, String exportFile, Constructeur constructeur) throws IOException{
		try (BufferedReader reader = new BufferedReader(new FileReader (mdFile))){
			String line;
			String previousLine="";
			String nextLine="";
			
			while((line=reader.readLine())!=null) {
				if(line.startsWith("# ")) {
					constructeur.buildHeader1(line.substring(2));
				}
				if(line.startsWith("## ")) {
					constructeur.buildHeader2(line.substring(3));
				}
				if(line.startsWith("### ")) {
					constructeur.buildHeader3(line.substring(4));
				}
				if(line.contains("**")) {
					int idx = line.indexOf("*");
					constructeur.buildRawText(line.substring(0,idx-1));
					constructeur.buildBold(line.substring(idx));
				}
				if(line.contains("_")) {
					int idx = line.indexOf("_");
					constructeur.buildRawText(line.substring(0,idx-1));
					constructeur.buildItalic(line.substring(idx));
				}
				
				if (line.isEmpty()) {
					if(previousLine.startsWith("+ "))
						constructeur.onEndUnsortedList();
					else if(!previousLine.startsWith("#") && (!previousLine.isEmpty()))
						constructeur.onParagraphEnd();
				}
				
				if(previousLine.isEmpty()) {
					if(line.startsWith("+ "))
						constructeur.onBeginUnsortedList();
				}
				
				if(line.startsWith("+ ")) {
					constructeur.buildListItem(line.substring(2));
				}
				
				
			
				else {
					constructeur.buildRawText(line);
				}
				previousLine = line;
				
				
			}
			FileWriter fw = new FileWriter(exportFile);
			fw.write(constructeur.getResult());
			fw.close();
		}
		catch (IOException e) {
			e.getMessage();
		}
		
	}
	
}
