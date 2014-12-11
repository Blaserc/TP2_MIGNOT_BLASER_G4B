package fr.unilim.info;

public class Animal {
	
	private String espece;
	private boolean carnivore;
	private double poids;
	
	public Animal(String espece, boolean carn, double poids) {
		this.setEspece(espece);
		this.setCarnivore(carn);
		this.setPoids(poids);
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public boolean isCarnivore() {
		return carnivore;
	}

	public void setCarnivore(boolean carnivore) {
		this.carnivore = carnivore;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}
	
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

	@Override
	public String toString() {
		return "espece=["+this.getEspece()+"], carnivore=["+this.isCarnivore()+"], poids=["+this.getPoids()+"]";
	}
	
	public double calculerViandeHebdo() {
		if(this.carnivore == true)
			return this.getPoids()/4;
		else
			return 0;
	}
}
