package fr.emmuliette.rpgtemplate;

public abstract class AbstractJob {
	private AbstractPlayer owner;
	private String name;
	
	public AbstractJob(String name, AbstractPlayer owner) {
		this.name = name;
		this.owner = owner;
	}
	
	public abstract void apply();
	
	public abstract void remove();
	
	public abstract void levelUp();
	
	public abstract void levelDown();

	public AbstractPlayer getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return name;
	}
}
