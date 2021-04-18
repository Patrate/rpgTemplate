package fr.emmuliette.rpgtemplate._example;

import fr.emmuliette.rpgtemplate.races.AbstractRace;
import fr.emmuliette.rpgtemplate.races.RaceOwner;
import fr.emmuliette.rpgtemplate.stats.StatOwner;

public class HumanRace extends AbstractRace {

	public HumanRace() {
		super("Human");
	}


	@Override
	public void apply(RaceOwner owner) {
		if(owner instanceof StatOwner) {
			((StatOwner)owner).getStat(StatEnum.STR.name()).addValue(5);
		}
	}

	@Override
	public void remove(RaceOwner owner) {
		if(owner instanceof StatOwner) {
			((StatOwner)owner).getStat(StatEnum.STR.name()).addValue(-5);
		}
	}

}
