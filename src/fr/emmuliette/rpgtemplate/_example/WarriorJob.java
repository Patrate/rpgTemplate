package fr.emmuliette.rpgtemplate._example;

import fr.emmuliette.rpgtemplate.jobs.AbstractJob;
import fr.emmuliette.rpgtemplate.jobs.JobOwner;
import fr.emmuliette.rpgtemplate.stats.StatOwner;

public class WarriorJob extends AbstractJob {

	public WarriorJob(JobOwner owner) {
		super("Warrior", owner);
	}

	@Override
	public void apply() {
		if (getOwner() instanceof StatOwner) {
			((StatOwner) getOwner()).getStat(StatEnum.STR.name()).addValue(3);
		}
	}

	@Override
	public void remove() {
		if (getOwner() instanceof StatOwner) {
			((StatOwner) getOwner()).getStat(StatEnum.STR.name()).addValue(-3);
		}
	}

	@Override
	public void levelUpAction() {
		if (getOwner() instanceof StatOwner) {
			((StatOwner) getOwner()).getStat(StatEnum.STR.name()).addValue(3);
		}
	}

	@Override
	public void levelDownAction() {
		if (getOwner() instanceof StatOwner) {
			((StatOwner) getOwner()).getStat(StatEnum.STR.name()).addValue(-3);
		}
	}

}
