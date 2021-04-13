package fr.emmuliette.rpgtemplate.conditions;

public abstract class AbstractCondition {
	private ConditionOwner owner;
	
	/**
	 * Remove from the stat pov
	 */
	public final void remove() {
		this.owner = null;
	}
	
	/**
	 * Deactivate from the buff pov
	 */
	public final void deactivate() {
		owner.deactivate();
		this.owner = null;
	}
	
	public void setOwner(ConditionOwner owner) {
		this.owner = owner;
	}
	
	public final void tick() {
		step();
		if(!isActive()) {
			deactivate();
		}
	}
	public abstract void step();
	public abstract boolean isActive();
}
