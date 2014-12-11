package fr.unilim.info;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

	private List<Animal> animaux;

	public Zoo() {
		this.animaux = new ArrayList<Animal>();
	}

	public void ajouterAnimal(Animal animal) {
		if (animal == null) {
			throw new IllegalArgumentException();
		}
		this.animaux.add(animal);
	}

	public void retirerAnimal(Animal animal) {
		if (!(this.animaux.remove(animal)))
			throw new IllegalArgumentException();
	}

	public boolean estVide() {
		return this.animaux.isEmpty();
	}

	@Override
	public String toString() {
		String res = "";
		for (Animal animal : this.animaux) {
			res += animal.toString() + "\n";
		}
		return res;
	}

	public double calculerQuantiteViandeZoo() {
		double res = 0;
		for (Animal animal : this.animaux) {
			res += animal.calculerViandeHebdo();
		}
		return res;
	}

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