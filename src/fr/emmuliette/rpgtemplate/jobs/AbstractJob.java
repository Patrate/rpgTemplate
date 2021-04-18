package fr.emmuliette.rpgtemplate.jobs;

public abstract class AbstractJob {
	private JobOwner owner;
	private String name;
	private int level;
	
	public AbstractJob(String name, JobOwner owner) {
		this.name = name;
		this.owner = owner;
		this.level = 1;
	}
	
	public abstract void apply();
	
	public abstract void remove();
	
	public void levelUp() {
		level += 1;
		levelUpAction();
	}

	public void levelDown() {
		if(level <= 1) {
			remove();
			owner.removeJob(this);
			return;
		}
		level -= 1;
		levelDownAction();
	}
	
	protected abstract void levelUpAction();
	
	protected abstract void levelDownAction();

	public JobOwner getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return name + " (" + level + ")";
	}
}
