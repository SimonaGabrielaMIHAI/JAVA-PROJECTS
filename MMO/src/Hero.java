
public class Hero {

	public boolean isAlive = true;
	public boolean isStuned = false;
	public boolean isOvertimeDmg = false;
	public char type;
	public int HpInit;
	protected float Hp;
	public float HpAfterBattle;
	public float HpBonusLvl;
	public int lvl;
	protected float Xp;
	private float XpLevelUp = 250;
	public int coordX;
	public int coordY;
	public int round = 0;
	
	Ability FirstAbility;
	Ability SecondAbility;
	protected int countOvertime;
	protected float dmgOvertime;
	protected int overtimeLimit;
	
	public void updateXP(Hero lose){
		Xp = Xp + Math.max(0, 200 - (lvl - lose.lvl) * 40);
		while(Xp > XpLevelUp) {
			lvl++;
			Hp += HpBonusLvl;
			Hp = (float) HpInit + HpBonusLvl * lvl;
			XpLevelUp = 250 + lvl * 50;
			FirstAbility.lvlUpUpdate();
			SecondAbility.lvlUpUpdate();
		}
	}
	
	public void placeHero(int a, int b) {
		coordX = a;
		coordY = b;
		round++;
	}
	
	public void applyOvertimeDmg(){
		if(isOvertimeDmg == false) {
			return;
		}
		else {
			Hp -= dmgOvertime;
			countOvertime++;
			if(countOvertime == overtimeLimit) {
				isOvertimeDmg = false;
				isStuned = false;
				countOvertime = 0;
				overtimeLimit = 0;
			}
		}
	}
	
	public void move(char x) {
		if(x == '_') {
			placeHero(coordX,coordY);
			return;
		}
		if(x == 'U') {
			placeHero(coordX - 1, coordY);
			return;
		}
		if(x == 'D') {
			placeHero(coordX + 1, coordY);
			return;
		}
		if(x == 'L') {
			placeHero(coordX, coordY - 1);
			return;
		}
		if(x == 'R') {
			placeHero(coordX, coordY + 1);
			return;
		}
	
	}
	
}
