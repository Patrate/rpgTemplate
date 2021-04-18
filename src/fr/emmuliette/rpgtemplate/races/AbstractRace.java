package fr.emmuliette.rpgtemplate.races;

public abstract class AbstractRace {
	private String name;
	
	public AbstractRace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public abstract void apply(RaceOwner owner);
	
	public abstract void remove(RaceOwner owner);

	@Override
	public String toString() {
		return name;
	}
}
