package Default;

import java.time.Clock;
import java.time.Duration;

//Isil A 

public class Main {
	
	
	public static Clock clock;//On utilise la classe Clock et LocalDate pour g�rer les dates
		//Periode d'emprunt = 7 jours
	public static void main(String[] args) {
		
		System.out.println("\n\t\t\t\tBIENVENUE\n");
		clock = clock.systemDefaultZone();//Affecter a clock la date d'aujourd'hui
		
		Bibliothecaire bibliothecaire = new Bibliothecaire();
		
		Livre livre1 = new Livre("titre1","cote1","type1");
		Livre livre2 = new Livre("titre2","cote2","type2");
		Livre livre3 = new Livre("titre3","cote3","type3");

		//la bibliothecaire ajoute des livres
		bibliothecaire.ajouterLivre(livre1, 12); 
		bibliothecaire.ajouterLivre(livre2, 0);//le nombre d'exemplaire est 0 pour pouvoir faire le scenario 8
		bibliothecaire.ajouterLivre(livre3, 23);
		
		Agent agent1 = new Agent("nomAgent1","prenomAgent1");
		Agent agent2 = new Agent("nomAgent2","prenomAgent2");
		
		// la bibliotecaire ajoute les agents au systeme
		bibliothecaire.ajouterAuSystem(agent1);
		bibliothecaire.ajouterAuSystem(agent2);
		
		Consultant consultant1 = new Consultant("nomConsultan1","prenomConsultant1",42342);
		Consultant consultant2 = new Consultant("nomConsultan2","prenomConsultant2",24342);
		
		Adherant adherant1 = new Adherant("nomAdherant1","prenomAdherant1",4346);
		Adherant adherant2 = new Adherant("nomAdherant2","prenomAdherant2",42226);
		
		// les agents ajoute les adherants au systeme
		agent1.ajouterAuSystem(adherant1);
		agent2.ajouterAuSystem(adherant2);
		
		
		//Veuillez choisir un sc�nario: 
		
		
		//Sc�nario 1: le consultant consultant1 cherche un livre
		
		/*
		consultant1.chercherLivre("titre1");
		consultant1.chercherLivre("titre4");
		Livre.afficherHistorique();
		*/
		
		//Sc�nario 2: l'agent agent1 note une consultation du consultant consultant2
		
		/*
		agent1.faireUneConsultation(consultant2);//Pour une consultation interne, l'agent note le num�ro de la carte d'adh�rent ou le num�ro de la pi�ce d'identit�, son type et le nom et pr�nom du consultant.
		Consultation.afficherListeConsultations();
		*/
		
		//Sc�nario 3: l'agent agent2 note un pr�t du livrre livre2 par l'adh�rant adherant1
		
		/*
		  //d'abord l'agent se connecte pour g�rer les pr�ts
		agent2.seConnecter(agent2.getLogin(), agent2.getPassword());
		agent2.faireUnPret(adherant1, livre2);//Pour chaque pr�t, on note le num�ro d'adh�rent, la c�te du livre ainsi que le num�ro d'exemplaire et la date de pr�t
		agent2.seDeconnecter();
		*/
		
		//Sc�anrio 4: l'adh�rant adherant1 fais un retard
		
		/*
		agent1.seConnecter(agent1.getLogin(), agent1.getPassword());
		agent1.faireUnPret(adherant1, livre3);
		clock = clock.offset(clock, Duration.ofDays(9));//Ajouter 9 jours a la date actuelle
		agent1.faireUneRestituion(adherant1, livre3);
		*/
		
		//Sc�nario 5: fin d'dh�sion pour l'adh�rant adherant2 
		
		/*
		clock = clock.offset(clock,Duration.ofDays(366));// ajouter 366 jours a la date contenue dans clock
		agent1.seConnecter(agent1.getLogin(),agent1.getPassword() );
		agent1.faireUnPret(adherant2, livre1);
		*/
		
		//Sc�nario 6: fin d'adh�sion pour l'adh�rant adherant1 et renouvellement
		
		/*clock = clock.offset(clock,Duration.ofDays(366));
		agent1.seConnecter(agent1.getLogin(), agent1.getPassword());
		agent1.faireUnPret(adherant2, livre1);
		adherant2.renouvlerAdhesion("login2password","adherant2password");//L'attribution des login /mot de passe est du ressort des agents lors de l'ajout de l'adh�rent au syst�me ou du renouvellement d'adh�sion
		agent1.faireUnPret(adherant2, livre1);*/
		
		//scénario 7: une personne sur internet veut voir la liste des livres et  chercher un

		/*Personne personne1 = new Personne();
		personne1.voirListeLivre();
		personne1.chercherLivre("titre1");*/

		//scénario 8 : l'adherant reserve un livre et annule la reservation

		/*adherant1.seConnecter(adherant1.getLogin(), adherant1.getPassword());
		adherant1.reserverLivre("titre2");
		adherant1.annulerReservation("titre0"); // il se trompe du livre 
		adherant1.annulerReservation("titre2");
		adherant1.seDeconnecter();*/

		//scenario 9: l'agent note une restitution et change le mot de pass d'un adherant
		/*agent1.seConnecter(agent1.getLogin(), agent1.getPassword());
		agent1.faireUneRestituion(adherant1, livre1);
		agent1.changerMotDePassDe(adherant1, "newPassword");
		agent1.seDeconnecter();*/

		//scenario 10: la bibliothecaire veut voir le deroulement de la bibliotheque

		/*bibliothecaire.voirStatistiques();*/

		// statistiques vu par le directeur 
		/*System.out.println("------Liste des adherants------");
		Adherant.afficherListeAdherant();

		System.out.println("------Liste des agents------");
		Agent.afficherListeAgent();

		System.out.println("------Liste des consultatins------");
		Consultation.afficherListeConsultations();
		System.out.println("le taux de consultations: "+Consultation.afficherTauxConsultations());
		adherant1.tauxRenouvellement(2022); //on prends 2022 comme exemple*/
		
		
		



    }
	
}


