package fr.emmuliette.rpgtemplate.example;

import fr.emmuliette.rpgtemplate.AbstractPlayer;
import fr.emmuliette.rpgtemplate.stat.AbstractStat;

public class IntelligenceStat extends AbstractStat{

	public IntelligenceStat(AbstractPlayer owner, Integer value) {
		super(StatEnum.INT.name(), owner, value);
	}

	@Override
	protected void update() {
		
	}
}
