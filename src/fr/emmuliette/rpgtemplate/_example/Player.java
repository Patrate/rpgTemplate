package fr.emmuliette.rpgtemplate._example;

import fr.emmuliette.rpgtemplate.BaseEntity;
import fr.emmuliette.rpgtemplate.races.AbstractRace;

public class Player extends BaseEntity {

	public Player(Class<? extends AbstractRace> race) throws Exception {
		super(new StatBuilder(), race);
	}
}
