package fr.emmuliette.rpgtemplate;

import java.util.HashSet;
import java.util.Set;

public class Ticker {
	private static final Ticker TICKER = new Ticker();
	private Set<Tickable> tickables;
	
	
	private Ticker() {
		tickables = new HashSet<Tickable>();
	}
	
	public static void tick() {
		for(Tickable tickable:TICKER.tickables) {
			tickable.tick();
		}
	}
	
	public static void register(Tickable tickable) {
		TICKER.tickables.add(tickable);
	}
	
	public static void unregister(Tickable tickable) {
		TICKER.tickables.remove(tickable);
	}
}
