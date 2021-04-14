package fr.emmuliette.rpgtemplate.example;

import fr.emmuliette.rpgtemplate.AbstractJob;
import fr.emmuliette.rpgtemplate.AbstractPlayer;

public class WizardJob extends AbstractJob {

	public WizardJob(AbstractPlayer owner) {
		super("Wizard", owner);
	}

	@Override
	public void apply() {
		getOwner().getStat(StatEnum.INT.name()).addValue(3);
	}

	@Override
	public void remove() {
		getOwner().getStat(StatEnum.INT.name()).addValue(-3);
	}

	@Override
	public void levelUpAction() {
		getOwner().getStat(StatEnum.INT.name()).addValue(3);
	}

	@Override
	public void levelDownAction() {
		getOwner().getStat(StatEnum.INT.name()).addValue(-3);
	}

}
