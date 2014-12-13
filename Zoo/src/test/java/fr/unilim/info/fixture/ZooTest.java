package fr.unilim.info.fixture;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.unilim.info.Animal;
import fr.unilim.info.SoinEnum;
import fr.unilim.info.Zoo;

/**
 * Classe testant la validité des méthodes sur un zoo.
 * @author Adeline Mignot - Camille Blaser
 * @version 1.0
 * @since 10.12.2014
 */
public class ZooTest {
	
	Zoo animauxZoo;
	
	/**
	 * Initialisation d'un zoo avant chaque méthode de test.
	 */
	@Before
	public void setUp() {
		animauxZoo = AnimalFixture.creerListeAnimaux();
	}

	/**
	 * Tester si le zoo comptabilise un animal de plus 
	 * lorsqu'on en ajoute un
	 */
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
	
	/**
	 * Tester si une exception est propagée
	 * lorsqu'on tente d'entrer un animal null dans le zoo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void ajoutAnimalNull() {
		//Given
		//When
		animauxZoo.ajouterAnimal(null);
		//Then
	}
	
	/**
	 * Tester si le zoo comptabilise un animal de moins
	 * lorsqu'on ôte un animal du zoo
	 */
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
	
	/**
	 * Tester si un exception est propagée
	 * lorsqu'on tente de retirer du zoo un animal n'y étant pas
	 */
	@Test(expected = IllegalArgumentException.class)
	public void retirerAnimalAbsent() {
		//Given
		Animal poney = new Animal("poney", false, 200.9);
		//When
		animauxZoo.retirerAnimal(poney);
		//Then
		
	}
	
	/**
	 * Tester si un zoo non vide est considéré comme tel
	 */
	@Test
	public void estVide() {
		//Given
		//When
		boolean resultat = animauxZoo.estVide();
		//Then
		assertFalse(resultat);
	}
	
	/**
	 * Tester si l'affichage du zoo correspond à l'affichage
	 * des caractéristiques des animaux, ligne par ligne
	 */
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
	
	/**
	 * Tester si la quantité de viande calculée correspond
	 * à la somme du poids des carnivores divisée par 4
	 */
	@Test
	public void quantiteViande() {
		//Given
		double expected = (150.0+205.0+90.45+3.5)/4;
		//When
		double resultat = animauxZoo.calculerQuantiteViandeZoo();
		//Then
		assertEquals(expected, resultat, 0);
	}
	
	/**
	 * Tester si les animaux carnivores bénéficient tous
	 * du soin des dents et sont les seuls
	 */
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
	
	/**
	 * Tester si les animaux de plus de 200kg bénéficient tous
	 * du soin des pieds, et son les seuls
	 */
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
