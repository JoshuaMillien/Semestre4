import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;


/**
 * Classe permettant de compresser des fichiers .txt
 * @author Jean-François Condotta - 2016
 *
 */
/**
 * @author hectorcure
 *
 */
public class CompresseurTexteEtudiant {

	/**
	 * A COMPLETER (0)
	 * 
	 * Cette méthode doit lire le contenu d'un fichier texte et retourner les lignes de ce fichier
	 * dans un vecteur. En cas de problème le programme s'arrête.
	 * 
	 * @param fichier Le fichier texte à traiter.
	 * @return Un vecteur contenant les lignes du fichier.
	 * @throws FileNotFoundException 
	 */
	private Vector<String> lignesFromFile(File fichier){
		Vector<String> lignes=new Vector<String>();
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(fichier)));
			String line;
			while ((line = bf.readLine())!=null){
				lignes.add(line);
			}
		}
		catch (IOException e){
			e.getMessage();
		}
		/////// A COMPLETER (0) Environ 12 lignes.
		
		//////////////////////////////////////////
		return lignes;
	}


	/**
	 * A COMPLETER (1)
	 * 
	 * Cette méthode doit créer et écrire dans un fichier des lignes de texte. En cas de problème le programme s'arrête.
	 * @param lignes Les lignes à écrire dans le fichier.
	 * @param nomFichier Le nom du fichier.
	 */

	private void fileFromLignes(Vector<String> lignes,String nomFichier){
		/////// A COMPLETER (1) Environ 12 lignes.
		File f = new File(nomFichier);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(nomFichier));
	        PrintWriter pw = new PrintWriter(bw);
	        
			for (int i = 0 ; i<lignes.size();i++){
				pw.print(lignes.get(i));
				pw.print("\n");
				//System.out.println(lignes.get(i));
			}
			pw.close() ;
		}
		catch (Exception e){
			e.getStackTrace();
		}

		//////////////////////////////////////////
	}


	/**
	 * A COMPLETER (2)
	 * 
	 * Méthode permettant d'encoder une ligne de texte avec le format A.
	 * 
	 * @param ligne La ligne à encoder avec le format A. Cette ligne est différente de null.
	 * @return La ligne correspondant à l'enodage au format A de ligne.
	 */
	private String encoderLigneFormatA(String ligne){
		String ligneA="";
		int maxSegment=26;
		/////// A COMPLETER (2) Environ 12 lignes.
		int i = 0;
		while (i<ligne.length()){
			char car = ligne.charAt(i);
			int t =1;
			while ((t<26) && (t+i < ligne.length())&&(car==ligne.charAt(t+i)))
				t++;
			char car2 = (char)((int)'a'+t-1);
			ligneA = ligneA + car2 + car;
			i=i+t;
				
		}
		
		//////////////////////////////////////////
		return ligneA;
	}


	/**
	 * A COMPLETER (3)
	 * Méthode permettant d'encoder au format A un ensemble de lignes.
	 * 
	 * @param lignes Les lignes à convertir au format A.
	 * @return Un vecteur contenant les lignes au format A.
	 */
	private  Vector<String> encoderLignesFormatA(Vector<String> lignes){
		Vector<String> lignesA=new Vector<String>();
		/////// A COMPLETER (3) Environ 2 lignes.
		for (int i=0;i<lignes.size();i++){
			lignesA.add(encoderLigneFormatA(lignes.get(i)));
		}
		
		//////////////////////////////////////////
		return lignesA;
	}


	/**
	 * A COMPLETER (4)
	 * 
	 * Méthode permettant de convertir une liste de fichiers au format A.
	 * @param listeFichiers La liste des fichiers à traiter.
	 */
	private void traitementConvertA(Vector<File> listeFichiers){
		/////// A COMPLETER (4) Environ 7 lignes.
		File f;
		Vector<String> lignes=null;
		Vector<String> lignes2=null;

		for (int i =0;i<listeFichiers.size();i++){
			f = listeFichiers.get(i);
			lignes=(lignesFromFile(f));
			lignes2=encoderLignesFormatA(lignes);
			
		}
		
		//////////////////////////////////////////
	}

	/**
	 * A COMPLETER (5)
	 * 
	 * Méthode permettant de décoder une ligne de texte encodée avec le format A.
	 * 
	 * @param ligneA La ligne à décoder. Cette ligne est différente de null.
	 * @return La ligne correspondant au décodage de ligneA.
	 */
	private String decoderLigneFormatA(String ligneA){
		String ligne="";
		/////// A COMPLETER (5) Environ 9 lignes.
	
		
		//////////////////////////////////////////
		return ligne;
	}

	/**
	 * A COMPLETER (6)
	 * Méthode permettant de décoder un ensemble de lignes encodées au format A.
	 * 
	 * @param lignesA Les lignes à décoder.
	 * @return Un vecteur contenant les lignes décodées.
	 */

	private  Vector<String> decoderLgnesFormatA(Vector<String> lignesA){
		Vector<String> lignes=new Vector<String>();
		/////// A COMPLETER (6) Environ 2 lignes.
		for (int i=0;i<lignesA.size();i++)
			lignes.add(decoderLigneFormatA(lignesA.elementAt(i)));
		//////////////////////////////////////////
		return lignes;
	}


	/**
	 * A COMPLETER (7)
	 * 
	 * Méthode permettant de décoder et d'afficher les textes encodés au format A dans une liste de fchiers.
	 * @param listeFichiers La liste des fichiers à traiter.
	 */
	private void traitementAfficheA(Vector<File> listeFichiers){
		/////// A COMPLETER (7) Environ 8 lignes.
		
		
		//////////////////////////////////////////
	}

	/**
	 * A COMPLETER (8)
	 * 
	 * Méthode cherchant la position d'une séquence d'un même caractère d'au moins une longueur de trois dans une ligne de texte.
	 * 
	 * @param ligne La ligne dans laquelle est réalisée la recherche de la séquence (pos<longueur ligne).
	 * @param pos La position à partir de laquelle commence la recherche de la séquence.
	 * @return La position de la première séquence d'au moins trois fois le même caractère trouvée à une position
	 * strictement inférieur à pos+26 sinon retourne pos+26 si (pos+26<= longueur de ligne) ou longueur de ligne si (pos+26>longueur de ligne).
	 */
	private int chercheSequenceAvecLongueurAuMoins3(String ligne,int pos){
		int positionInitiale=pos;
		int posS=pos;
		char charS=ligne.charAt(posS);
		int tailleS=1;

		while (true){
			// A COMPLETER (8) Environ 15 lignes.
		
			//////////////////////////////////////////
		}
		
	}


	/**
	 * A COMPLETER (9)
	 * 
	 * Méthode permettant d'encoder une ligne de texte avec le format B.
	 * 
	 * @param ligne La ligne à encoder avec le format B. Cette ligne est différente de null.
	 * @return La ligne correspondant à l'enodage au format B de ligne.
	 */
	private String encoderLigneFormatB(String ligne){
		String ligneB="";
		int maxSegment=26;
		/////// A COMPLETER (9) Environ 18 lignes.
	
		
		//////////////////////////////////////////
		return ligneB;
	}


	/**
	 * A COMPLETER (10)
	 * Méthode permettant d'encoder au format B un ensemble de lignes.
	 * 
	 * @param lignes Les lignes à convertir au format B.
	 * @return Un vecteur contenant les lignes au format B.
	 */
	private  Vector<String> encoderLignesFormatB(Vector<String> lignes){
		Vector<String> lignesA=new Vector<String>();
		/////// A COMPLETER (10) Environ 2 lignes.
		for (int i=0;i<lignes.size();i++)
			lignesA.add(encoderLigneFormatB(lignes.elementAt(i)));
		//////////////////////////////////////////
		return lignesA;
	}


	/**
	 * A COMPLETER (11)
	 * 
	 * Méthode permettant de convertir une liste de fchiers au format B.
	 * @param listeFichiers La liste des fichiers à traiter.
	 */
	private void traitementConvertB(Vector<File> listeFichiers){
		/////// A COMPLETER (11) Environ 7 lignes.
		
		
		
		//////////////////////////////////////////
	}	

	/**
	 * A COMPLETER (12)
	 * 
	 * Méthode permettant de décoder une ligne de texte encodée avec le format B.
	 * 
	 * @param ligneB La ligne à décoder. Cette ligne est différente de null.
	 * @return La ligne correspondant au décodage de ligneB.
	 */
	private String decoderLigneFormatB(String ligneB){
		String ligne="";
		/////// A COMPLETER (12) Environ 15 lignes.
		
		
		//////////////////////////////////////////
		return ligne;
	}

	/**
	 * A COMPLETER (14)
	 * Méthode permettant de décoder un ensemble de lignes encodées au format B.
	 * 
	 * @param lignesB Les lignes à décoder.
	 * @return Un vecteur contenant les lignes décodées.
	 */

	private  Vector<String> decoderLgnesFormatB(Vector<String> lignesB){
		Vector<String> lignes=new Vector<String>();
		/////// A COMPLETER (14) Environ 2 lignes.
		
		
		
		//////////////////////////////////////////
		return lignes;
	}


	/**
	 * A COMPLETER (15)
	 * 
	 * Méthode permettant de décoder et d'afficher les textes encodés au format B dans une liste de fchiers.
	 * @param listeFichiers La liste des fichiers à traiter.
	 */
	private void traitementAfficheB(Vector<File> listeFichiers){
		/////// A COMPLETER (15) Environ 8 lignes.
	
		
		//////////////////////////////////////////
	}

	/**
	 * Un simple constructeur.
	 */
	public CompresseurTexteEtudiant() {
	}


	/**
	 * Permet de récupérer la liste des fichiers d'un dossier d'une certaine extension.
	 * 
	 * @param dossier Le nom du dossier.
	 * @param extension L'extension des fichiers à garder.
	 * @return La liste des fichiers du dossier portant l'etension souhaitée.
	 */
	public Vector<File> listerDossier(String dossier,String extension) {
		File d = new File(dossier);
		File[] fichiers = d.listFiles();
		Vector<File> resultat=new Vector<File>();

		if (fichiers!=null) 
			for (int i=0;i<fichiers.length;i++) 
				if ((fichiers[i].isFile())&&(fichiers[i].getName().endsWith(extension)))
					resultat.add(fichiers[i]);
		return resultat;
	}    

	/**
	 * Affiche les noms des fichiers d'une liste de fichiers.
	 * @param listeFichiers La liste des fichiers.
	 */
	private void afficherListeFichiers(Vector<File> listeFichiers){
		for (int i=0;i<listeFichiers.size();i++)
			System.out.println(listeFichiers.get(i).getAbsolutePath());
	}





	/**
	 * @param dossier Le dossier à traiter.
	 * @param operation La chaîne de caractères correspondant à l'opération demandée.
	 */
	private void traitement(String dossier,String operation){
		String extension="";
		if (operation.equals("convertA")){
			extension=".txt";
			System.out.println("**** Compression des fichiers .txt au format .txtA ***");
			System.out.println("**** Fichiers avec l'extension .txt trouvés  dans le dossier "+dossier+" ***");
			Vector<File> listeFichiers=listerDossier(dossier,extension);
			afficherListeFichiers(listeFichiers);
			traitementConvertA(listeFichiers);
		} else
			if (operation.equals("convertB")){
				extension=".txt";
				System.out.println("**** Compression des fichiers .txt au format .txtB ***");
				System.out.println("**** Fichiers avec l'extension .txt trouvés  dans le dossier "+dossier+" ***");
				Vector<File> listeFichiers=listerDossier(dossier,extension);
				afficherListeFichiers(listeFichiers);
				traitementConvertB(listeFichiers);
			} else
				if (operation.equals("afficheA")){
					extension=".txtA";
					System.out.println("**** Décompression des fichiers .txtA ***");
					System.out.println("**** Fichiers avec l'extension .txtA trouvés  dans le dossier "+dossier+" ***");
					Vector<File> listeFichiers=listerDossier(dossier,extension);
					afficherListeFichiers(listeFichiers);
					traitementAfficheA(listeFichiers);
				} else
					if (operation.equals("afficheB")){
						extension=".txtB";
						System.out.println("**** Décompression des fichiers .txtB ***");
						System.out.println("**** Fichiers avec l'extension .txtB trouvés  dans le dossier "+dossier+" ***");
						Vector<File> listeFichiers=listerDossier(dossier,extension);
						afficherListeFichiers(listeFichiers);
						traitementAfficheB(listeFichiers);
					} else {
						System.out.println("**** Deuxième argument non reconnu ! ***");
						System.exit(1);
					}
	}

	/**
	 * 
	 * Méthode permettant de décoder les textes encodés au format B dans une liste de fchiers.
	 * @param listeFichiers La liste des fichiers à traiter.
	 * @return Un vecteur contenant les vecteurs des lignes décodées pour chaque fichier.
	 * @throws FileNotFoundException 
	 */
	public Vector<Vector<String>> traitementDecoderB(Vector<File> listeFichiers) throws FileNotFoundException{
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		for (int i=0;i<listeFichiers.size();i++){
			File fichierSource=listeFichiers.elementAt(i);
			Vector<String> lignesB=lignesFromFile(fichierSource);
			Vector<String> lignes=decoderLgnesFormatB(lignesB);
			result.add(lignes);
		}
		return result;
	}

	
	public static void main(String[] args) {
		if (args.length!=2){
			System.out.println("**** Mauvais nombre d'arguments : <dossier> <convertA|convertB|afficheA|afficheB> ***");
			System.exit(1);
		};
		CompresseurTexteEtudiant compresseur=new CompresseurTexteEtudiant();
		compresseur.traitement(args[0],args[1]);
		
		//String a = "boooonjour";
		//System.out.println(compresseur.lignesFromFile(new File(args[0])).get(0));
		//System.out.println(compresseur.encoderLigneFormatA(a));
		
		
		Vector<String> lignes = compresseur.lignesFromFile(new File(args[0]));
		System.out.println(compresseur.encoderLignesFormatA(lignes));
		compresseur.fileFromLignes(lignes, "./exemplesTest.txt");
	}

}
