package fr.emmuliette.rpgtemplate._example;

import fr.emmuliette.rpgtemplate.stats.AbstractStat;
import fr.emmuliette.rpgtemplate.stats.StatOwner;

public class StrengthStat extends AbstractStat{

	public StrengthStat(StatOwner owner, Integer value) {
		super(StatEnum.STR.name(), owner, value);
	}

	@Override
	protected void update() {
		
	}
}
