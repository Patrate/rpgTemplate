package fr.emmuliette.rpgtemplate.example;

import fr.emmuliette.rpgtemplate.AbstractPlayer;
import fr.emmuliette.rpgtemplate.AbstractStat;

public class StrengthStat extends AbstractStat{

	public StrengthStat(AbstractPlayer owner, Integer value) {
		super(StatEnum.STR.name(), owner, value);
	}

	@Override
	protected void update() {
		
	}
}
