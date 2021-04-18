package fr.emmuliette.rpgtemplate._example;

import fr.emmuliette.rpgtemplate.stats.AbstractStat;
import fr.emmuliette.rpgtemplate.stats.StatOwner;

public class IntelligenceStat extends AbstractStat{

	public IntelligenceStat(StatOwner owner, Integer value) {
		super(StatEnum.INT.name(), owner, value);
	}

	@Override
	protected void update() {
		
	}
}
