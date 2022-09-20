package Default;

import java.util.ArrayList;

public class Consultation implements Affichable{
	
	public static ArrayList<Consultation> listeConsultation = new ArrayList<Consultation>();
	
	private String nomConsultant;
	private String prenomConsultant;
	private String typeConsultant;
	private int numConsultant;
	
	
	public Consultation(String nomConsultant,String prenomConsultant,String typeConsultant,int numConsultant) {
		this.nomConsultant = nomConsultant;
		this.prenomConsultant = prenomConsultant;
		this.typeConsultant = typeConsultant;
		this.numConsultant = numConsultant;
	}
	
	
	public String getNomConsultant() {
		return nomConsultant;
	}
	public String getPrenomConsultant() {
		return prenomConsultant;
	}
	public String getTypeConsultant() {
		return typeConsultant;
	}
	public int getNum() {
		return numConsultant;
	}

	public static int afficherTauxConsultations() {
		int cpt=0;
		for (Consultation e : listeConsultation) {
			cpt++;
		}
		return cpt;
	}

	public static void afficherListeConsultations() {
		for (Consultation e : listeConsultation) {
			e.afficherInfo();
		}
	}
	@Override
	public void afficherInfo() {
		// TODO Auto-generated method stub
		if (typeConsultant.equals("Non Adherant")) {
			System.out.println("**********************\nNom du consultant: "+nomConsultant + "\nPrenom du consultant: "+prenomConsultant+"\nType du consultant: "+typeConsultant + "\nNum identit�e: "+numConsultant+"\n**********************");
		}else {
			System.out.println("**********************\nNom du consultant: "+nomConsultant + "\nPrenom du consultant: "+prenomConsultant+"\nType du consultant: "+typeConsultant + "\nNum adh�rant: "+numConsultant+"\n**********************");
		}
		
	}

}
