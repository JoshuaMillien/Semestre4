public class RTF implements Constructeur {
	
	private final StringBuilder stb = new StringBuilder();
	
	@Override
	public void onParagraphBegin() {
		
		stb.append("{\\pard");
	}

	@Override
	public void onParagraphEnd() {
		
		stb.append("\\par}");
	}

	@Override
	public void buildHeader1(String s) {
		
		stb.append("{\\pard\\qc\\b\\fs40 titre 1 \\par}");
	}

	@Override
	public void buildHeader2(String s) {
		
		stb.append("{\\pard\\qc\\b\\fs30 titre 2 \\par}");
	}

	@Override
	public void buildHeader3(String s) {
		
		stb.append("{\\pard\\qc\\b\\fs20 titre 3 \\par}");
	}

	@Override
	public void onBeginUnsortedList() {
		
		stb.append("\\line{\\pard\\li500\\ql");
	}

	@Override
	public void buildListItem(String s) {
		
		stb.append("{\\b * } item \\line");
	}

	@Override
	public void onEndUnsortedList() {
		
		stb.append("\\line\\par}");
	}

	@Override
	public void buildRawText(String s) {
		
		stb.append(s);
	}

	@Override
	public void buildBold(String s) {
		
		stb.append("{\\b gras }");
	}

	@Override
	public void buildItalic(String s) {
		
		stb.append("{\\i italique }");
	}

	@Override
	public String getResult() {
		return stb.toString();
	}

}
