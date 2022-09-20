package Default;

public class Personne {
	
	//une personne sur internet qui veut voir la liste des livre ou chercher un
	public void voirListeLivre() {
		for (Livre p : Livre.listeLivres) {
			p.afficherInfo();
		}
	}
	
	public void chercherLivre(String titre){
		
		for (Livre l : Livre.listeLivres) {
			if (l.titre.equals(titre)) {
				Livre.historiqueRecherche.add(new String ("(Anonyme) a recherch� le titre: "+titre +", resulatat: disponible"));
				System.out.println("Le livre "+titre+" est diponible: Cote: "+l.cote+", numero d'exemplaire "+l.getNumExemplaire());
				return;
			}
		}
		Livre.historiqueRecherche.add(new String ("(Anonyme) a recherch� le titre: "+titre +", resulatat: pas disponible"));
		System.out.println("Le livre "+titre+" n'est pas diponible");
	}

}
