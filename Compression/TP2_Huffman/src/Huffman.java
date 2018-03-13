import java.util.Vector;

public class Huffman {
	
	public static void encode (String s) {
		int ascii = 65;
		int[] frequences = new int[26];
		for (int i =0;i<s.length();i++) {
			int c = (int)s.charAt(i) - ascii;
			frequences[c] ++;		
		}
		
		Vector<Arbre> arbres = new Vector<Arbre>();
		
		for (int i : frequences) {
			System.out.print(i+ " ");
		}
		
	}
	
	public Arbre plusPetit(Vector<Arbre> arbres) {
		Arbre mini = arbres.get(0);
		for (Arbre node : arbres) {
			if (node.getFrequence()<mini.getFrequence()) {
				mini = node;
			}
		}
		
		return mini;	
	}

}
