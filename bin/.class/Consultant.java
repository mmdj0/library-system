package Default;

public class Consultant implements Affichable {
	protected String nom;
	protected String prenom;
	protected int numIdentitee;

	public Consultant (String nom , String prenom , int numIdentitee) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.numIdentitee = numIdentitee;
		
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public int getNumIdentitee() {
		return numIdentitee;
	}

	public void chercherLivre(String titre){
		for (Livre l : Livre.listeLivres) {
			if (l.titre.equals(titre) && l.getNumExemplaire() > 0) {
				Livre.historiqueRecherche.add(new String ("("+nom+" "+prenom+")"+" a recherch� le titre: "+titre +", r�sulatat: disponible"));
				System.out.println("Le livre "+titre+" est diponible: Cote: "+l.cote+", numero d'exemplaire "+l.getNumExemplaire());
				return;
			}
			
		}
		Livre.historiqueRecherche.add(new String ("("+nom+" "+prenom+")"+" a recherch� le titre: "+titre +", r�sulatat: pas disponible"));
		System.out.println("Le livre "+titre+" n'est pas diponible");
		
	}


	@Override
	public void afficherInfo() {
		System.out.println("**********************\nNom: "+nom+"\nPrenom: "+prenom+"\nNumero d'identitee: "+numIdentitee+"\n**********************");
		
	}
	


}
