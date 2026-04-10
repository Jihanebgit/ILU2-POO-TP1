package villagegaulois;

import personnages.Gaulois;

public class Etal {
	private Gaulois vendeur;
	private String produit;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	public void occuperEtal(Gaulois vendeur, String produit, int quantite) {
		this.vendeur = vendeur;
		this.produit = produit;
		this.quantite = quantite;
		quantiteDebutMarche = quantite;
		etalOccupe = true;
	}

// PAS de JETER (!throw) d'exception faire copier coller du code depart pour ca et revoir consigne : libererEtal
	public String libererEtal() {
		StringBuilder chaine= new StringBuilder();
		try {
		etalOccupe = false;
		chaine.append("Le vendeur ");
		chaine.append(vendeur.getNom());
		chaine.append(" quitte son étal, ");
		int produitVendu = quantiteDebutMarche - quantite;
		if (produitVendu > 0) {
			chaine.append(
					"il a vendu " + produitVendu + " parmi " + produit + ".\n");
		} else {
			chaine.append("il n'a malheureusement rien vendu.\n");
		}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return chaine.toString();
	}

	public String afficherEtal() {
		if (etalOccupe) {
			return "L'étal de " + vendeur.getNom() + " est garni de " + quantite + " " + produit + "\n";
		}
		return "L'étal est libre";
	}

	public String acheterProduit(int quantiteAcheter, Gaulois acheteur) {

		// quantité invalide (pas d'exception )
		if (quantiteAcheter < 1) {
			throw new IllegalArgumentException("Quantité non autorisé");
		}

		// étal vide
		if (!etalOccupe) {
			throw new IllegalStateException("Etal non occupé");
		}

		StringBuilder chaine = new StringBuilder();

		try {
			acheteur.getNom();
			chaine.append(acheteur.getNom()).append(" veut acheter ").append(quantiteAcheter).append(" ")
					.append(produit).append(" à ").append(vendeur.getNom());

			if (quantite == 0) {
				chaine.append(", malheureusement il n'y en a plus !");
				quantiteAcheter = 0;
			}

			if (quantiteAcheter > quantite) {
				chaine.append(", comme il n'y en a plus que ").append(quantite).append(", ").append(acheteur.getNom())
						.append(" vide l'étal de ").append(vendeur.getNom()).append(".\n");

				quantiteAcheter = quantite;
				quantite = 0;
			}

			if (quantite != 0) {
				quantite -= quantiteAcheter;

				chaine.append(". ").append(acheteur.getNom()).append(", est ravi de tout trouver sur l'étal de ")
						.append(vendeur.getNom()).append("\n");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return chaine.toString();
	}

	public boolean contientProduit(String produit) {
		return produit.equals(this.produit);
	}

}
