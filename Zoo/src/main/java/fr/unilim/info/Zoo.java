package fr.unilim.info;

/**
 * Classe représentant un zoo.
 * @author Adeline Mignot - Camille Blaser
 * @version 1.0
 * @since 10.12.2014
 */
import java.util.ArrayList;
import java.util.List;

public class Zoo {

	private List<Animal> animaux;

	/**
	 * Constructeur par défaut d'un zoo. Initialise la liste.
	 */
	public Zoo() {
		this.animaux = new ArrayList<Animal>();
	}

	/**
	 * Obtenir la liste des animaux du zoo.
	 * @return la liste des animaux du zoo
	 */
	public List<Animal> getAnimaux() {
		return this.animaux;
	}
	
	/**
	 * Ajouter un animal au zoo.
	 * @param animal l'animal à ajouter au zoo
	 */
	public void ajouterAnimal(Animal animal) {
		if (animal == null) {
			throw new IllegalArgumentException();
		}
		this.animaux.add(animal);
	}

	/**
	 * Retirer un animal du zoo.
	 * @param animal l'animal à ôter du zoo
	 */
	public void retirerAnimal(Animal animal) {
		if (!(this.animaux.remove(animal)))
			throw new IllegalArgumentException();
	}

	/**
	 * Permet de savoir si le zo est vide
	 * @return true si le zoo est vide, false sinon
	 */
	public boolean estVide() {
		return this.animaux.isEmpty();
	}

	/**
	 * Afficher en console la liste des animaux du zoo.
	 * Sur chaque ligne apparaitra l'espèce, le régime et le poids d'un animal
	 */
	@Override
	public String toString() {
		String res = "";
		for (Animal animal : this.animaux) {
			res += animal.toString()+"\n";
		}
		return res;
	}

	/**
	 * Calculer la quantité de viande nécessaire dans le zoo pour une semaine
	 * @return la quantité de viande nécessaire
	 */
	public double calculerQuantiteViandeZoo() {
		double res = 0;
		for (Animal animal : this.animaux) {
			res += animal.calculerViandeHebdo();
		}
		return res;
	}

	/**
	 * Obtenir la liste des animaux à soigner, selon le soin choisi.
	 * @param soin le soin choisi dans l'énumération SoinEnum
	 * @return la liste des animaux à soigner
	 */
	public List<Animal> recupererAnimauxASoigner(SoinEnum soin) {
		List<Animal> animauxASoigner = new ArrayList<Animal>();
		if (soin == SoinEnum.DENTS) {
			for (Animal animal : this.animaux) {
				if (animal.isCarnivore() == true)
					animauxASoigner.add(animal);
			}
		} else if (soin == SoinEnum.PIEDS) {
			for (Animal animal : this.animaux) {
				if (animal.getPoids() > 200)
					animauxASoigner.add(animal);
			}
		}
		return animauxASoigner;
	}
}