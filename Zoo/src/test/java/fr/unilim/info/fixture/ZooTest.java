package fr.unilim.info.fixture;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import com.sun.tracing.dtrace.Attributes;
import fr.unilim.info.Animal;
import fr.unilim.info.Zoo;

public class ZooTest {
	
	Zoo animauxZoo;
	
	@Before
	public void setUp() {
		animauxZoo = AnimalFixture.creerListeAnimaux();
	}

	@Test
	public void ajoutAnimal() {
		//Given
		Animal poney = new Animal("poney", false, 200.9);
		//When
		animauxZoo.ajouterAnimal(poney);
		//Then
		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void retirerAnimal() {
		//Given
		Animal poney = new Animal("poney", false, 200.9);
		//When
		animauxZoo.retirerAnimal(poney);
		//Then
		
	}

}
