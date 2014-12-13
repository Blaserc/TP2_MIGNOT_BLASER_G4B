package fr.unilim.info.fixture;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.unilim.info.Animal;

/**
 * Classe testant la validité des méthodes sur les animaux.
 * @author Adeline Mignot - Camille Blaser
 * @version 1.0
 * @since 10.12.2014
 */
public class AnimalTest {
	
	/**
	 * Tester si notre méthode equals renvoie true lorsque elle compare un animal avec lui-même.
	 */
	@Test
	public void equalsMemeObjet() {
		//Given
		Animal cheval = new Animal("cheval", false, 800);
		
		//When
		boolean resultat = cheval.equals(cheval);
		
		//Then
		assertTrue(resultat);
	}
	
	/**
	 * Tester si notre méthode equals renvoie false 
	 * quand elle compare un animal avec un objet quelconque n'étant pas une instance d'animal
	 */
	@Test
	public void equalsNotInstanceofAnimal() {
		//Given
		Animal dada = new Animal("dada", false, 300);
		int entier = 3;
		
		//When
		boolean resultat = dada.equals(entier);
		
		//Then
		assertFalse(resultat);
	}
	
	/**
	 * Teser si notre méthode equals renvoie true
	 * lorsqu'elle compare deux animaux de mêmes espèce, régime et poids
	 */
	@Test
	public void equalsInstanceofAnimalTrue() {
		//Given
		Animal dada = new Animal("dada", false, 300);
		Animal dada2 = new Animal("dada", false, 300);
		
		//When
		boolean resultat = dada.equals(dada2);
		
		//Then
		assertTrue(resultat);
	}

	/**
	 * Tester si notre méthode equals renvoie false
	 * lorsqu'elle compare deux animaux de même poids
	 * mais d'espèces et régimes différents
	 */
	@Test
	public void equalsInstanceofAnimalFalseNom() {
		//Given
		Animal dada = new Animal("dada", false, 300);
		Animal lion = new Animal("lion", true, 300);
		
		//When
		boolean resultat = dada.equals(lion);
		
		//Then
		assertFalse(resultat);
	}
	
	/**
	 * Tester si notre méthode equals renvoie false
	 * lorsqu'elle compare deux animaux de même régime
	 * mais d'espèces et de poids différents
	 */
	@Test
	public void equalsInstanceofAnimalFalsePoidsEtNom() {
		//Given
		Animal dada = new Animal("dada", false, 300);
		Animal poney = new Animal("poney", false, 400);
		
		//When
		boolean resultat = dada.equals(poney);
		
		//Then
		assertFalse(resultat);
	}
	
	/**
	 * Tester si notre méthode equals renvoie false
	 * lorsqu'elle compare deux animaus de mêmes poids et régime
	 * mais d'espèces différentes
	 */
	@Test
	public void equalsInstanceofAnimalFalsePoids() {
		//Given
		Animal dada = new Animal("dada", false, 300);
		Animal poney = new Animal("dada", false, 350.5);
		
		//When
		boolean resultat = dada.equals(poney);
		
		//Then
		assertFalse(resultat);
	}
	
	/**
	 * Tester si notre méthode to String renvoie ce qu'on attend.
	 */
	@Test
	public void toStringTest() {
		//Given
		Animal amy = new Animal("baleine", false, 1000);
		String resultatAttendu = "espece=[baleine], carnivore=[false], poids=[1000.0]";
		
		//When
		String resultatDonne = amy.toString();
		
		//Then
		assertEquals(resultatAttendu, resultatDonne);
	}
}
