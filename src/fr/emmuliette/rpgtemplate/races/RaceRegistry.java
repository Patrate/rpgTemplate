package fr.emmuliette.rpgtemplate.races;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class RaceRegistry {
	private static final RaceRegistry REGISTRY = new RaceRegistry();
	private final Map<Class<? extends AbstractRace>, AbstractRace> races;
	
	private RaceRegistry() {
		races = new HashMap<Class<? extends AbstractRace>, AbstractRace>();
	}
	
	public static AbstractRace getRace(Class<? extends AbstractRace> raceClass) throws Exception {
		if(REGISTRY.races.containsKey(raceClass)) {
			return REGISTRY.races.get(raceClass);
		}
		try {
			REGISTRY.races.put(raceClass, raceClass.getDeclaredConstructor().newInstance());
			return REGISTRY.races.get(raceClass);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO throw exception if can't register a class
			throw new Exception("Couldn't register class " + raceClass.getSimpleName() + ":\n" + e.getMessage());
		}
	}
}