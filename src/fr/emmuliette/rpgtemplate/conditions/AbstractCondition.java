package fr.emmuliette.rpgtemplate.conditions;

public abstract class AbstractCondition {

	public final void tick() {
		step();
	}
	public abstract void step();
	public abstract boolean isValid();
}
