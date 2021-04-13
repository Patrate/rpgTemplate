package fr.emmuliette.rpgtemplate;

public abstract class AbstractRace {
	private String name;
	
	public AbstractRace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public abstract void apply(AbstractPlayer owner);

	
	@Override
	public String toString() {
		return name;
	}
}
