package fr.emmuliette.rpgtemplate.example;

import java.lang.reflect.InvocationTargetException;

import fr.emmuliette.rpgtemplate.AbstractPlayer;
import fr.emmuliette.rpgtemplate.AbstractRace;

public class Player extends AbstractPlayer {
	
	public Player(AbstractRace race) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super(new StatBuilder(), race);
	}
}
