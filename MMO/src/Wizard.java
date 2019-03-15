
public class Wizard extends Hero{
	
	Wizard() {
		type = 'W';
		HpInit = 400;
		Hp = 400;
		HpAfterBattle = 400;
		HpBonusLvl = 30;
		FirstAbility = new Drain();
		SecondAbility = new Deflect();
	}

}
