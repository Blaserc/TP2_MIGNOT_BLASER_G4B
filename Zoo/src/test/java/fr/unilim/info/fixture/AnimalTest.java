package fr.unilim.info.fixture;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.unilim.info.Animal;

public class AnimalTest {
	
	@Test
	public void equalsMemeObjet() {
		//Given
		Animal cheval = new Animal("cheval", false, 800);
		
		//When
		boolean resultat = cheval.equals(cheval);
		
		//Then
		assertTrue(resultat);
	}
	
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
