package fr.emmuliette.rpgtemplate._example;

import fr.emmuliette.rpgtemplate.Ticker;

public class _Main {

	public static void main(String[] args) throws Exception {


		System.out.println("\t>Creating an Human (+5 str) warrior (+3 str)");
		Player p = new Player(HumanRace.class);
		p.addJob(WarriorJob.class);
		System.out.println(p);


		System.out.println("\t>adding wizard (+3 int)");
		p.addJob(WarriorJob.class); // We can't add a job already present
		p.addJob(WizardJob.class);
		System.out.println(p);


		System.out.println("\t>Level up wizard (+3 int)");
		p.getJob(WizardJob.class).levelUp();
		System.out.println(p);


		System.out.println("\t>Leveling down warrior (-3 str)");
		p.getJob(WarriorJob.class).levelDown();
		System.out.println(p);
		

		System.out.println("\t>Casting 'bigStrength' (+5 str)");
		new BigStrengthSkill().cast(p);
		System.out.println(p);

		Ticker.tick();
		System.out.println("\t>Tic");
		System.out.println(p);
		

		Ticker.tick();
		System.out.println("\t>Tic");
		System.out.println(p);
		

		Ticker.tick();
		System.out.println("\t>Tic");
		System.out.println(p);
		

		Ticker.tick();
		System.out.println("\t>Tic");
		System.out.println(p);
		

		Ticker.tick();
		System.out.println("\t>Tic");
		System.out.println(p);
		

		Ticker.tick();
		System.out.println("\t>Tic");
		System.out.println(p);
		
	}

}
