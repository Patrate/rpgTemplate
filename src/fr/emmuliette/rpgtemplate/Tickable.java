package fr.emmuliette.rpgtemplate;

public abstract class Tickable {

	public Tickable() {
		Ticker.register(this);
	}
	
	public abstract void tick();
	
	public final void unregister() {
		Ticker.unregister(this);
	}
}
