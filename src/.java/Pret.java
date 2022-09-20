package Default;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pret implements Affichable{
	
	public static ArrayList<Pret> listePrets = new ArrayList<Pret>();
	
	private int numAdherant;
	private String cote;
	private int numExemplaire;
	private LocalDate datePret;
	private LocalDate dateRestituion;
	private Agent agentPret;
	
	
	public Pret (int numAdherant,String cote,int numExemplaire,Agent ag) {
		this.numAdherant = numAdherant;
		this.cote = cote;
		this.numExemplaire = numExemplaire;
		this.datePret = LocalDate.now(Main.clock);
		dateRestituion = LocalDate.now(Main.clock).plusDays(7);
		agentPret = ag;
	}
	//getters
	public int getNumAdherant() {
		return numAdherant;
	}
	public String getCote() {
		return cote;
	}
	public int getNumExemplaire() {
		return numExemplaire;
	}
	public LocalDate getDateRestituion() {
		return dateRestituion;
	}
	public LocalDate getDatePret() {
		return datePret;
	}
	public Agent getAgentDePret() {
		return agentPret;
	}

	@Override
	public void afficherInfo() {
		
		System.out.println("---------------------");
		System.out.println("Num adh�rant: "+numAdherant);
		System.out.println("Cote livre: "+cote);
		System.out.println("Num�ro d'exemplaire : "+numExemplaire);
		System.out.println("Date de pr�t: "+datePret);
		System.out.println("Date de r�stitution: "+dateRestituion);
		
	}
	
	public static void afficherListePret() {
		for (Pret p : listePrets) {
			
			p.afficherInfo();
		}
	}
	
	public static void tauxPrets(int annee) { 
		int ctr=0;
		for (Pret p : listePrets) {
			if(p.getDatePret().getYear() == annee) {
				
				ctr++;
			}
		}
		System.out.println("Durant l'ann�e "+annee+" il ya eu: "+ctr+" pr�ts");
	}

}
