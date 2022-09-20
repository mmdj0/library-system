package Default;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Agent implements Affichable{
	
	private String nom;
	private String prenom;
	private boolean connected;
	private String login;
	private String password;

	public static ArrayList <Agent> listeAgents = new ArrayList<Agent>();

	public Agent(String nom,String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		connected = false;
	}
	//getters
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	//setters
	public void setLogin(String l) {
		login = l;
	}
	
	public void setPassword(String p) {
		password = p;
	}

	public void ajouterAuSystem(Adherant ad) {
        
        ad.setLogin(new String("user"+ad.getNumAdherant()));
        ad.setPassword(new String("KITABI"+(int)(Math.random() * 10000000) + 1));
        ad.setDateInscription(LocalDate.now(Main.clock));
		System.out.println("************************");
		System.out.println("pour l'adherant : "+ad.getNom()+" "+ad.getPrenom());
		System.out.println("login: "+ad.getLogin()+"\npassword "+ad.getPassword());
		System.out.println("************************");
    }
	
	public void changerMotDePassDe(Adherant adherant,String newPassword) {
		
		adherant.setPassword(newPassword);
		System.out.println("le nouveau mot de passe de "+adherant.nom+" "+adherant.prenom+ " est: "+newPassword);
	}
	
	public void faireUneConsultation(Consultant cs){ //faire une consultation par un consultant(non adherant)
		
		Consultation.listeConsultation.add(new Consultation(cs.getNom(), cs.getPrenom(), "Non Adherant", cs.getNumIdentitee()));

	}
	
	public static void faireUneConsultation(Adherant ad){ //faire une consultation par un adherant
		
		Consultation.listeConsultation.add(new Consultation(ad.getNom(), ad.getPrenom(), "Adh�rant", ad.getNumAdherant()));

	}
	
	public void seConnecter(String login,String password) { //connection de l'agent
		
		try {
			if (this.login.equals(login) && this.password.equals(password)) {
				
				connected = true;
				System.out.println("vous vous etes connecté");
			}else {
				
				System.out.println("Login ou mot de passe incorrect");
			}
			
		}catch(NullPointerException e){
			System.out.println("Vous n'�tes pas ajout� au syst�me veuillez consulter le biblioth�caire");
		}
	}
	public void seDeconnecter() {
		connected = false;
		System.out.println("vous vous etes déconnecté");
	}
	
	public void faireUnPret(Adherant ad,Livre l) {
		
		if (connected) {
			
			if (LocalDate.now(Main.clock).isAfter(ad.getDateFinAdhesion())) {
				System.out.println("Votre adh�sion est termin�, veuillez renouvler");
			}else {
				
				if (ad.getPriveDePret() == false) {
					
					if (l.getNumExemplaire() > 0) {
						
						Pret nouvPret = new Pret(ad.getNumAdherant(),l.cote,l.getNumExemplaire(),this);
						nouvPret.afficherInfo();
						Pret.listePrets.add(nouvPret);
						ad.listeLivresEmrpunte.add(l);
						l.setNumExemplaire(l.getNumExemplaire() - 1);
						
					}else {
						
						System.out.println("Pr�t impossible, livre non diponbile");
					}
				}else {
					
					System.out.println("Vous �tes priv� de pr�ts jusqu'�: "+ad.getDateFinPriveDePret());
			
				}
				
			}
				
		}else
			System.out.println("Vous devez vous connecter pour g�rer les pr�ts");
		
	}
	
	public void faireUneRestituion(Adherant ad,Livre l) {
		ad.listeLivresEmrpunte.remove(l);
		for (Livre a : Livre.listeLivres) {
			if (a.equals(l)) {
				a.setNumExemplaire(a.getNumExemplaire()+1);
			}
		}
		
		for (Pret p : Pret.listePrets) {
			
			if (p.getNumAdherant() == ad.getNumAdherant() && p.getCote().equals(l.cote)) {
				
				if (LocalDate.now(Main.clock).isAfter(p.getDateRestituion())) {
					
					
					long daysBetween = ChronoUnit.DAYS.between(p.getDateRestituion(), LocalDate.now(Main.clock));
					
					ad.setDateFinPrivePret(LocalDate.now(Main.clock).plusDays(2*daysBetween));
					System.out.println("Vous �tes priv� de pr�ts jusqu'a: "+ ad.getDateFinPriveDePret());
				}
			}
		}
		
		
	}

	public static void afficherListeAgent() {
		System.out.println("Il ya: "+listeAgents.size()+ " Agents");
		for (Agent a : listeAgents) {
			a.afficherInfo();
		}
	}
	
	@Override
	public void afficherInfo() {
		System.out.println("**********************\n Nom: "+nom+"\nPrenom: "+prenom+"\n**********************");
		
	}
}
