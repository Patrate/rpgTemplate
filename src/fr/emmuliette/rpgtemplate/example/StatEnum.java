package fr.emmuliette.rpgtemplate.example;

import fr.emmuliette.rpgtemplate.AbstractStat;

public enum StatEnum {
	INT(IntelligenceStat.class), STR(StrengthStat.class);

	private Class<? extends AbstractStat> stat;
	
	private StatEnum(Class<? extends AbstractStat> stat) {
		this.stat = stat;
	}
	
	public Class<? extends AbstractStat> stat(){
		return stat;
	}
}
