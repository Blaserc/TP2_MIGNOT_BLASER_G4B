package fr.unilim.info;
/**
 * Classe représentant un animal quelconque du zoo.
 * @author Adeline Mignot - Camille Blaser
 * @version 1.0
 * @since 10.12.2014
 */
public class Animal {
	
	private String espece;
	private boolean carnivore;
	private double poids;
	
	/**
	 * Constructeur d'un animal
	 * @param espece l'espèce de l'animal
	 * @param carn vrai si l'animal est carnassier, faux sinon
	 * @param poids le poids de l'animal
	 */
	public Animal(String espece, boolean carn, double poids) {
		this.setEspece(espece);
		this.setCarnivore(carn);
		this.setPoids(poids);
	}

	/**
	 * Obtenir l'espèce de l'animal
	 * @return l'espèce de l'animal
	 */
	public String getEspece() {
		return espece;
	}

	/**
	 * Modifier l'espèce de l'animal
	 * @param espece la nouvelle espèce de l'animal
	 */
	public void setEspece(String espece) {
		this.espece = espece;
	}

	/**
	 * Savoir si l'animal est carnivore ou non
	 * @return true si l'animal est carnivore, faux sinon
	 */
	public boolean isCarnivore() {
		return carnivore;
	}

	/**
	 * Modifier le régime alimentaire de l'animal
	 * @param carnivore true si l'animal devient carnivore, false sinon
	 */
	public void setCarnivore(boolean carnivore) {
		this.carnivore = carnivore;
	}

	/**
	 * Obtenir le poids de l'animal
	 * @return le poids de l'animal
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * Modifier le poids de l'animal
	 * @param poids le poids de l'animal
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	/**
	 * Vérifier si deux animaux sont les mêmes (même espèce, même poids, même régime)
	 * @return true si les animaux sont égaux, false sinon
	 */
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		if(!(o instanceof Animal)) {
			return false;
		}
		final Animal animo =(Animal) o;
		return this.getEspece()==animo.getEspece() && this.getPoids()==animo.getPoids();
	}

	/**
	 * Afficher en console l'espèce, le régime et le poids de l'animal
	 */
	@Override
	public String toString() {
		return "espece=["+this.getEspece()+"], carnivore=["+this.isCarnivore()+"], poids=["+this.getPoids()+"]";
	}
	
	/**
	 * Calculer la consommation de viande hebdomadaire d'un animal.
	 * @return la quantité de viande nécessaire pour l'animal en une semaine
	 */
	public double calculerViandeHebdo() {
		if(this.carnivore == true)
			return this.getPoids()/4;
		else
			return 0;
	}
}
