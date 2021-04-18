package fr.emmuliette.rpgtemplate._example;

import fr.emmuliette.rpgtemplate.jobs.AbstractJob;
import fr.emmuliette.rpgtemplate.jobs.JobOwner;
import fr.emmuliette.rpgtemplate.stats.StatOwner;

public class WizardJob extends AbstractJob {

	public WizardJob(JobOwner owner) {
		super("Wizard", owner);
	}

	@Override
	public void apply() {
		if (getOwner() instanceof StatOwner) {
			((StatOwner) getOwner()).getStat(StatEnum.INT.name()).addValue(3);
		}
	}

	@Override
	public void remove() {
		if (getOwner() instanceof StatOwner) {
			((StatOwner) getOwner()).getStat(StatEnum.INT.name()).addValue(-3);
		}
	}

	@Override
	public void levelUpAction() {
		if (getOwner() instanceof StatOwner) {
			((StatOwner) getOwner()).getStat(StatEnum.INT.name()).addValue(3);
		}
	}

	@Override
	public void levelDownAction() {
		if (getOwner() instanceof StatOwner) {
			((StatOwner) getOwner()).getStat(StatEnum.INT.name()).addValue(-3);
		}
	}

}
