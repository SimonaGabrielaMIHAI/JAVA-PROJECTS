
public class Rogue extends Hero{
	
	Rogue() {
		type = 'R';
		HpInit = 600;
		Hp = 600;
		HpAfterBattle = 600;
		HpBonusLvl = 40;
		FirstAbility = new Backstab();
		SecondAbility = new Paralysis();
	}

}
