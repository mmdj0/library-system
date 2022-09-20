package Default;

import java.util.ArrayList;

public class Livre implements Affichable {
	
	public String titre;
	public String cote;
	public String type;
	private int numExemplaire;

	public static ArrayList <Livre> listeLivres =  new ArrayList<Livre>();
	public static ArrayList <String> historiqueRecherche = new ArrayList<String>();//Historique de recherche. Exemple "AdherantX a recherch� TitreX, resultat: Pas disponible"
	public static ArrayList <Livre> livresDemandes = new ArrayList<Livre>();//a chaque fois une personne emprente ou consulte un livre , pour la gestion
	
	
	
	public Livre (String titre,String cote,String type) {
		this.titre = titre;
		this.cote = cote;
		this.type = type;
	}
	
	public int getNumExemplaire() {
		return numExemplaire;
	}
	public void setNumExemplaire(int i){
		// si le numExemplaire diminue lors d'une emprente
		numExemplaire = i;
	}

	@Override
	public void afficherInfo() {
		System.out.println("**********************\nTitre: "+titre + "\nCote: "+cote+"\nType: "+type + "\nNumero d'exemplaire: "+numExemplaire+"\n**********************");
	}
	
	
	
	public static void afficherHistorique() {
		for (String s : historiqueRecherche) {
			System.out.println(s);
		}
	}
	
	public static void afficherLivresDemandes() {
		for(Livre l : livresDemandes) {
			l.afficherInfo();
		}
	}
	
	public static void afficherListe() {
		for(Livre l : listeLivres) {
			l.afficherInfo();
		}
		
	}
	

}
