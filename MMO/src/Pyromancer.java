
public class Pyromancer extends Hero{
		
	Pyromancer(){
		type = 'P';
		Hp = 500;
		HpInit = 500;
		HpBonusLvl = 50;
		HpAfterBattle = 500;
		FirstAbility = new Fireblast();
		SecondAbility = new Ignite();
	}
	
}