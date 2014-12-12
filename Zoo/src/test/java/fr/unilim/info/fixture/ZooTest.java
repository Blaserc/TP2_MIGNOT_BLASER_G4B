package fr.unilim.info.fixture;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.unilim.info.Animal;
import fr.unilim.info.SoinEnum;
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
		int tailleAttendue = animauxZoo.getAnimaux().size()+1;
		//When
		animauxZoo.ajouterAnimal(poney);
		int tailleActuelle = animauxZoo.getAnimaux().size();
		//Then
		assertEquals(tailleAttendue, tailleActuelle);
		}
	
	@Test(expected = IllegalArgumentException.class)
	public void ajoutAnimalNull() {
		//Given
		//When
		animauxZoo.ajouterAnimal(null);
		//Then
	}
	
	@Test
	public void retirerAnimal() {
		//Given
		Animal wapiti = new Animal("wapiti", false, 150.2);
		animauxZoo.ajouterAnimal(wapiti);
		int tailleAttendue = animauxZoo.getAnimaux().size()-1;
		//When
		animauxZoo.retirerAnimal(wapiti);
		int tailleActuelle = animauxZoo.getAnimaux().size();
		//Then
		assertEquals(tailleAttendue, tailleActuelle);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void retirerAnimalAbsent() {
		//Given
		Animal poney = new Animal("poney", false, 200.9);
		//When
		animauxZoo.retirerAnimal(poney);
		//Then
		
	}
	
	@Test
	public void estVide() {
		//Given
		//When
		boolean resultat = animauxZoo.estVide();
		//Then
		assertFalse(resultat);
	}
	
	@Test
	public void TestToString() {
		//Given
		String expected = "espece=[koala], carnivore=[false], poids=[25.3]\n"
				+ "espece=[cheval], carnivore=[false], poids=[500.65]\n"
				+ "espece=[elan], carnivore=[false], poids=[200.4]\n"
				+ "espece=[bar], carnivore=[false], poids=[0.33]\n"
				+ "espece=[leopard], carnivore=[true], poids=[150.0]\n"
				+ "espece=[lion], carnivore=[true], poids=[205.0]\n"
				+ "espece=[pantere], carnivore=[true], poids=[90.45]\n"
				+ "espece=[chat], carnivore=[true], poids=[3.5]\n";
		//When
		String resultat = animauxZoo.toString();
		//Then
		assertEquals(expected, resultat);
	}
	
	@Test
	public void quantiteViande() {
		//Given
		double expected = (150.0+205.0+90.45+3.5)/4;
		//When
		double resultat = animauxZoo.calculerQuantiteViandeZoo();
		//Then
		assertEquals(expected, resultat, 0);
	}
	
	@Test
	public void testSoinDents() {
		//Given
		List<Animal> animauxAttendus = new ArrayList<Animal>();
		animauxAttendus.add(animauxZoo.getAnimaux().get(4));
		animauxAttendus.add(animauxZoo.getAnimaux().get(5));
		animauxAttendus.add(animauxZoo.getAnimaux().get(6));
		animauxAttendus.add(animauxZoo.getAnimaux().get(7));
		//When
		List<Animal> animauxASoigner = animauxZoo.recupererAnimauxASoigner(SoinEnum.DENTS);
		//Then
		assertEquals(animauxAttendus, animauxASoigner);
	}
	
	@Test
	public void testSoinPieds() {
		//Given
		List<Animal> animauxAttendus = new ArrayList<Animal>();
		animauxAttendus.add(animauxZoo.getAnimaux().get(1));
		animauxAttendus.add(animauxZoo.getAnimaux().get(2));
		animauxAttendus.add(animauxZoo.getAnimaux().get(5));
		//When
		List<Animal> animauxASoigner = animauxZoo.recupererAnimauxASoigner(SoinEnum.PIEDS);
		//Then
		assertEquals(animauxAttendus, animauxASoigner);
	}
}
