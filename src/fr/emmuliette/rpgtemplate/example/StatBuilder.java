package fr.emmuliette.rpgtemplate.example;

import fr.emmuliette.rpgtemplate.stat.AbstractStatBuilder;

public class StatBuilder extends AbstractStatBuilder {

	public StatBuilder() {
		super(1, StatEnum.STR.stat(), StatEnum.INT.stat());
	}

}
