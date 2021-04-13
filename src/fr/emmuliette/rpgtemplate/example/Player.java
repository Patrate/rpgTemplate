package fr.emmuliette.rpgtemplate.example;

import java.lang.reflect.InvocationTargetException;

import fr.emmuliette.rpgtemplate.AbstractPlayer;

public class Player extends AbstractPlayer {
	
	public Player() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super(new StatBuilder(), new HumanRace(), WarriorJob.class);
	}
}
