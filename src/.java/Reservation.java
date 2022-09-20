package Default;

import java.util.ArrayList;


public class Reservation implements Affichable{
	
	private Adherant adherant;
	private Livre livre;
	
	public static ArrayList <Reservation> listeReservation = new ArrayList<Reservation>();
	
	public Reservation(Adherant ad,Livre l){
		adherant = ad;
		livre = l;
	}

	public static void afficheListeReservations(){
		for(Reservation r : listeReservation){
			r.afficherInfo();
		}
	}

	public static int afficheTauxReservations(){
		int cpt=0;
		for(Reservation r : listeReservation){
			cpt++;
		}
		return cpt;
	}
	
	public Adherant getAdherant() {
		return adherant;
	}
	
	public Livre getLivre() {
		return livre;
	}

	@Override
	public void afficherInfo() {
		// TODO Auto-generated method stub
		adherant.afficherInfo();
		System.out.println();
		System.out.println("a reservé ce livre");
		System.out.println();
		livre.afficherInfo();
	}
}
