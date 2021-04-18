package fr.emmuliette.rpgtemplate._example;

import fr.emmuliette.rpgtemplate.stats.AbstractStatBuilder;

public class StatBuilder extends AbstractStatBuilder {

	public StatBuilder() {
		super(1, StatEnum.STR.stat(), StatEnum.INT.stat());
	}

}
