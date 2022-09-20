package Default;

import java.time.LocalDate;
import java.util.ArrayList; 
public class Adherant extends Consultant implements Affichable{
	
	private int numAdherant;
	private static int ctrNumAdherant = 0;
	private boolean priveDePret;
	private LocalDate dateFinPrivePret;
	private LocalDate dateFinAdhesion;
	private boolean connected;
	private String login;
	private String password;
	private LocalDate dateInscription;

	
	public static ArrayList <Adherant> listeAdherants = new ArrayList <Adherant> ();
	public ArrayList <Livre> listeLivresEmrpunte = new ArrayList <Livre> ();
	public ArrayList <Livre> listeLivresReserve = new ArrayList <Livre> ();
	
	

	public Adherant(String nom,String prenom,int numIdentitee) {

		super(nom,prenom,numIdentitee);
		ctrNumAdherant++;
		numAdherant = ctrNumAdherant;
		dateFinAdhesion = LocalDate.now(Main.clock).plusYears(1);
		listeAdherants.add(this);
	}
	
	public static void afficherListeAdherant() {
		System.out.println("Il ya: "+listeAdherants.size()+ " Adh�rants");
		for (Adherant a : listeAdherants) {
			a.afficherInfo();
		}
	}

	public static void tauxRenouvellement(int annee) {
        int ctr = 0;
        for (Adherant a : listeAdherants) {
            if (a.getDateFinAdhesion().minusYears(1).getYear() == annee && a.getDateInscription().getYear() != annee) {
                ctr++;
            }
        }
        System.out.println("Durant l'année "+annee+" il ya eu: "+ctr+" renouvellement d'adhésion");
    }
	
	/*public static void tauxRenouvellement(int annee) {
		int ctr = 0;
		for (Adherant a : listeAdherants) {
			if (a.getDateFinAdhesion().minusYears(1).getYear() == annee) {
				ctr++;
			}
		}
		System.out.println("Durant l'ann�e "+annee+" il ya eu: "+ctr+" renouvellement d'adh�sion");
	}*/
	
	//Getters
	public int getNumAdherant() {
		return numAdherant;
	}
	
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public boolean getPriveDePret() {
		return priveDePret;
	}
	public LocalDate getDateFinPriveDePret() {
		return dateFinPrivePret;
	}
	public LocalDate getDateFinAdhesion() {
		return dateFinAdhesion;
	}
	public LocalDate getDateInscription() {
        return dateInscription;
    }
	
	//Setters
	public void setDateFinPrivePret(LocalDate dateFinPriveDePret) {
		this.dateFinPrivePret = dateFinPriveDePret;
		priveDePret = true;
	}
	
	public void setLogin(String l) {
		login = l;
	}
	
	public void setPassword(String p) {
		password = p;
	}

	public void setDateInscription(LocalDate dateInscription){
        
        this.dateInscription = dateInscription;
        
    }

	public void renouvlerAdhesion(String newLogin,String newPassword) {
		
		if (LocalDate.now(Main.clock).isAfter(dateFinAdhesion)) {
			password = newPassword;
			login = newLogin;
			dateFinAdhesion = LocalDate.now(Main.clock).plusYears(1);
		}else {
			System.out.println("Votre adh�sion n'est pas encore termin�");
		}
		
	}
	public void seConnecter(String login,String password) { //connection pour l'adherant
		
		if (LocalDate.now(Main.clock).isAfter(dateFinAdhesion)) {
			System.out.println("Votre adh�sion est termin�");
		}else {
			
			try {
				if (this.login.equals(login) && this.password.equals(password)) {
					
					connected = true;
					System.out.println("vous vous etes connecté");
				}else {
					
					System.out.println("Login ou mot de passe incorrect");
				}
				
			}catch(NullPointerException e){
				System.out.println("Vous n'�tes pas ajout� au syst�me veuillez consulter un agent");
			}
		}	
	}
	
	public void seDeconnecter() {
		connected = false;
		System.out.println("vous vous etes déconnecté");

	}
	
	public void reserverLivre(String titre) {
		
		if (connected) {
			
			for (Livre l : Livre.listeLivres) {
				if (l.titre.equals(titre)) {
					if (listeLivresReserve.contains(l)){
						System.out.println("Vous avez d�ja r�serv� le livre: "+titre);
					}else {
						if (l.getNumExemplaire() > 0) {
                            
                            System.out.println("Ce livre est disponible");
						}
						else{
							Reservation.listeReservation.add(new Reservation(this, l));
							listeLivresReserve.add(l);
							System.out.println("Vous venez de r�server le livre: "+titre);
						}
					}
					return;
				}
			}
			System.out.println("Ce livre n'est pas disponible");
			
			
		}else {
			System.out.println("Veuillez vous connecter a fin de pouvoir r�server un livre");
		}
		
	}
	
	public void annulerReservation(String titre) {
		
		for (Reservation a : Reservation.listeReservation) {
			if (a.getAdherant().equals(this) && a.getLivre().titre.equals(titre)) {
				Reservation.listeReservation.remove(a);
				listeLivresReserve.remove(a);
				System.out.println("Vous venez d'anuller la r�servation du livre: "+titre);
				return;
			}
		}
		System.out.println("Vous n'avez pas reserv� ce livre");
		
	}
	
	@Override
	public void afficherInfo() {
        
        System.out.println("**********************\nNom: "+nom+"\nPrenom: "+prenom+"\nNum adherant: "+numAdherant+"\nDate inscription: "+dateInscription+"\nDate fin d'adhésion: "+dateFinAdhesion+"\n**********************");
    }

	public void voirListeLivre() {
		Livre.afficherListe();
	}
	
	public void voirListeLivreEmprunte() {
		for (Livre l : listeLivresEmrpunte) {
			l.afficherInfo();
		}
	}
	
	public void voirListeLivreReserve() {
		for (Livre l : listeLivresReserve) {
			l.afficherInfo();
		}
	}

}
