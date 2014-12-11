package fr.unilim.info.fixture;

import fr.unilim.info.Animal;
import fr.unilim.info.Zoo;


public class AnimalFixture {
	
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
