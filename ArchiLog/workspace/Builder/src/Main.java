import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Directeur directeur = new Directeur();
		HTML html = new HTML();
		directeur.export("/export/etu/joshua.millien/S4/ArchiLog/workspace/Builder/src/test.md", 
				"/export/etu/joshua.millien/S4/ArchiLog/workspace/Builder/src/exportFile.html", html);
		
	}
}
