package fr.emmuliette.rpgtemplate._example;

import fr.emmuliette.rpgtemplate.conditions.TimeCondition;
import fr.emmuliette.rpgtemplate.skills.SkillOwner;
import fr.emmuliette.rpgtemplate.skills.types.AbstractSelfSkill;
import fr.emmuliette.rpgtemplate.stats.Buff;
import fr.emmuliette.rpgtemplate.stats.StatOwner;

public class BigStrengthSkill extends AbstractSelfSkill {

	@Override
	public void cast(SkillOwner caster) {
		if(caster instanceof StatOwner) {
			Buff.giveBuff((StatOwner) caster, new Buff("BigStrength", StatEnum.STR.name(), 5, new TimeCondition(5)));
		}
	}
}
