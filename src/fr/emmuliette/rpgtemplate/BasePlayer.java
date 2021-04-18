package fr.emmuliette.rpgtemplate;

import fr.emmuliette.rpgtemplate.races.AbstractRace;
import fr.emmuliette.rpgtemplate.stats.AbstractStatBuilder;

public class BasePlayer extends BaseEntity {
	private int statPoint;
	private int jobPoint;
	private int level;

	public BasePlayer(AbstractStatBuilder statBuilder, Class<? extends AbstractRace> race) throws Exception {
		super(statBuilder, race);
		this.statPoint = 0;
		this.jobPoint = 0;
		this.level = 0;
	}

	public int getStatPoint() {
		return statPoint;
	}

	public void setStatPoint(int statPoint) {
		this.statPoint = statPoint;
	}

	public int getJobPoint() {
		return jobPoint;
	}

	public void setJobPoint(int jobPoint) {
		this.jobPoint = jobPoint;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
