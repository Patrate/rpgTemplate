package fr.emmuliette.rpgtemplate.example;

import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Player p = new Player(new HumanRace());
		p.addJob(WarriorJob.class);
		System.out.println(p);
		
		p.addJob(WarriorJob.class);
		p.addJob(WizardJob.class);
		System.out.println(p);
		
		p.getJob(WizardJob.class).levelUp();
		System.out.println(p);

		p.getJob(WarriorJob.class).levelDown();
		System.out.println(p);
	}

}
