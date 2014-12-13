package fr.unilim.info.fixture;

import fr.unilim.info.Animal;
import fr.unilim.info.Zoo;

/**
 * Classe simulant la création d'un zoo de 8 animaux.
 * @author Adeline Mignot - Camille Blaser
 * @version 1.0
 * @since 10.12.2014
 */
public class AnimalFixture {
	
	/**
	 * Créer le zoo et lui ajouter des animaux.
	 * @return le zoo créé
	 */
	public static Zoo creerListeAnimaux() {
		
		Zoo animauxDuZoo = new Zoo();
		
		animauxDuZoo.ajouterAnimal(new Animal("koala", false, 25.3));
		animauxDuZoo.ajouterAnimal(new Animal("cheval", false, 500.65));
		animauxDuZoo.ajouterAnimal(new Animal("elan", false, 200.4));
		animauxDuZoo.ajouterAnimal(new Animal("bar", false, 0.33));
		animauxDuZoo.ajouterAnimal(new Animal("leopard", true, 150));
		animauxDuZoo.ajouterAnimal(new Animal("lion", true, 205));
		animauxDuZoo.ajouterAnimal(new Animal("pantere", true, 90.45));
		animauxDuZoo.ajouterAnimal(new Animal("chat", true, 3.5));
		
		return animauxDuZoo;
	}

}
