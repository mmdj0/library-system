package Default;

public class Bibliothecaire {
	
	
	private static int ctrAgent = 0;

	public void ajouterLivre(Livre l,int numExemplaire) { //la bibliothecaire ajoute de nouveaux livres ou des copies de livres deja existant dans la bibliotheque
		
		l.setNumExemplaire(numExemplaire);
		
		if(Livre.listeLivres.contains(l)) {
			l.setNumExemplaire(l.getNumExemplaire()+l.getNumExemplaire());
		}else{
			Livre.listeLivres.add(l);
		}
		
	}
	
	public void ajouterAuSystem(Agent ag) { //la bibliothecaire ajoute des agents au system
		ctrAgent++;
		ag.setLogin(new String("login"+ctrAgent));
		ag.setPassword(new String("password"+(int)(Math.random() * 10000000) + 1));
		System.out.println("************************");
		System.out.println("pour l'agent : "+ag.getNom()+" "+ag.getPrenom());
		System.out.println("login: "+ag.getLogin()+"\npassword "+ag.getPassword());
		System.out.println("************************");

	}
	
	public void voirStatistiques() { //pour voir le bon deroulement de la bibliotheque 
		
		System.out.println("------Historique des pr�ts------");
		Pret.afficherListePret();
		
		
		System.out.println("------Historique de recherche------");
		Livre.afficherHistorique();

		System.out.println("------Liste des reservations------");
		Reservation.afficheListeReservations();
		System.out.println("le taux de reservations: "+Reservation.afficheTauxReservations());

		
		System.out.println("------Liste des livres------");
		Livre.afficherListe();

		
		
	}
	
}
