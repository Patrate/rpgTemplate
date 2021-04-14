package fr.emmuliette.rpgtemplate.example;

import fr.emmuliette.rpgtemplate.AbstractJob;
import fr.emmuliette.rpgtemplate.AbstractPlayer;

public class WarriorJob extends AbstractJob {

	public WarriorJob(AbstractPlayer owner) {
		super("Warrior", owner);
	}

	@Override
	public void apply() {
		getOwner().getStat(StatEnum.STR.name()).addValue(3);
	}

	@Override
	public void remove() {
		getOwner().getStat(StatEnum.STR.name()).addValue(-3);
	}

	@Override
	public void levelUpAction() {
		getOwner().getStat(StatEnum.STR.name()).addValue(3);
	}

	@Override
	public void levelDownAction() {
		getOwner().getStat(StatEnum.STR.name()).addValue(-3);
	}

}
