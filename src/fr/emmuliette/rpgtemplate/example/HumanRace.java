package fr.emmuliette.rpgtemplate.example;

import fr.emmuliette.rpgtemplate.AbstractPlayer;
import fr.emmuliette.rpgtemplate.AbstractRace;

public class HumanRace extends AbstractRace {

	public HumanRace() {
		super("Human");
	}

	@Override
	public void apply(AbstractPlayer owner) {
		owner.getStat(StatEnum.STR.name()).addValue(5);
	}

}
