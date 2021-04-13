package fr.emmuliette.rpgtemplate.example;

import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Player p = new Player();
		System.out.println(p);
	}

}
