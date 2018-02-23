
public class HTML implements Constructeur {

	private final StringBuilder stb = new StringBuilder();
	
	public HTML() {
		stb.append("<html> \n <body>\n");
	}
	
	public void onParagraphBegin() {
		// TODO Stub de la méthode généré automatiquement
		stb.append("<p>");
	}

	@Override
	public void onParagraphEnd() {
		// TODO Stub de la méthode généré automatiquement
		stb.append("</p>\n");
	}

	@Override
	public void buildHeader1(String s) {
		// TODO Stub de la méthode généré automatiquement
		stb.append("<h1>" + s + "</h1>\n");
	}

	@Override
	public void buildHeader2(String s) {
		// TODO Stub de la méthode généré automatiquement
		stb.append("<h2>" + s + "</h2>\n");
	}

	@Override
	public void buildHeader3(String s) {
		// TODO Stub de la méthode généré automatiquement
		stb.append("<h3>" +s+"</h3>\n");
	}

	@Override
	public void onBeginUnsortedList() {
		// TODO Stub de la méthode généré automatiquement
		stb.append("<ul>\n");
	}

	@Override
	public void buildListItem(String s) {
		// TODO Stub de la méthode généré automatiquement
		stb.append("<li> item </li>\n");
	}

	@Override
	public void onEndUnsortedList() {
		// TODO Stub de la méthode généré automatiquement
		stb.append("</ul>\n");
	}

	@Override
	public void buildRawText(String s) {
		// TODO Stub de la méthode généré automatiquement
		stb.append(s);
		stb.append("\n");
	}

	@Override
	public void buildBold(String s) {
		// TODO Stub de la méthode généré automatiquement
		stb.append("<b>");
		stb.append(s);
		stb.append("</b>\n");
	}

	@Override
	public void buildItalic(String s) {
		// TODO Stub de la méthode généré automatiquement
		stb.append("<i>" + s +"</i>");
	}

	@Override
	public String getResult() {
		// TODO Stub de la méthode généré automatiquement
		return stb.toString() + "</body>\n" + "</html>";
	}
	
}
