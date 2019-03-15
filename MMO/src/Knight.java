
public class Knight extends Hero{
	
	Knight(){
		type = 'K';
		HpInit = 900;
		Hp = 900;
		HpAfterBattle = 900;
		HpBonusLvl = 80;
		FirstAbility = new Execute();
		SecondAbility = new Slam();
	}

}
