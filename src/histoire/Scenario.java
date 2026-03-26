package histoire;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;
import villagegaulois.VillageSansChefException;

public class Scenario {

	public static void main(String[] args) {
		Village village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Druide druide = new Druide("Panoramix", 2, 5, 10);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois assurancetourix = new Gaulois("Assurancetourix", 2);
		Gaulois bonemine = new Gaulois("Bonemine", 7);
		
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(assurancetourix);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(druide);
		village.ajouterHabitant(abraracourcix);
		
		try {

		    System.out.println(village.afficherVillageois());

		} catch (VillageSansChefException e) {

		    System.out.println(e.getMessage());

		}

		System.out.println(village.rechercherVendeursProduit("fleurs"));
		System.out.println(village.installerVendeur(bonemine, "fleurs", 20));
		System.out.println(village.rechercherVendeursProduit("fleurs"));
		System.out.println(village.installerVendeur(assurancetourix, "lyres", 5));
		System.out.println(village.installerVendeur(obelix, "menhirs", 2));
		System.out.println(village.installerVendeur(druide, "fleurs", 10));

		System.out.println(village.rechercherVendeursProduit("fleurs"));
		
		Etal etalFleur = village.rechercherEtal(bonemine);
		if (etalFleur != null) {

		    System.out.println(etalFleur.acheterProduit(10, abraracourcix));
		    System.out.println(etalFleur.acheterProduit(15, obelix));
		    System.out.println(etalFleur.acheterProduit(15, assurancetourix));

		} else {
		    System.out.println("Bonemine n'a pas d'étal !");
		}
		

		System.out.println(village.partirVendeur(bonemine));
		System.out.println(village.afficherMarche());
		
		System.out.println("TEST acheteur null :");
		System.out.println(etalFleur.acheterProduit(5, null));
		
		System.out.println("TEST quantité invalide :");
		System.out.println(etalFleur.acheterProduit(-5, abraracourcix));
		
		System.out.println("TEST étal vide :");
		Etal etalVide = new Etal();
		System.out.println(etalVide.acheterProduit(5, abraracourcix));
		
		
		
		Village villageSansChef = new Village("village test", 5, 2);
		try {
		    System.out.println(villageSansChef.afficherVillageois());
		} catch (VillageSansChefException e) {
		    System.out.println("Exception capturée : " + e.getMessage());
		}
	}

}
