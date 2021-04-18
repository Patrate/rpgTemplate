package fr.emmuliette.rpgtemplate.conditions;

public class TimeCondition extends AbstractCondition {
	private int tick;
	private int speed;
	
	public TimeCondition(int tick, int speed) {
		// TODO: throw exception if tick <= 0 or if speed <= 0
		this.tick = tick;
		this.speed = speed;
	}
	
	public TimeCondition(int tick) {
		this(tick, 1);
	}
	
	@Override
	public void step() {
		this.tick -= speed;
	}

	@Override
	public boolean isValid() {
		return tick > 0;
	}

}
