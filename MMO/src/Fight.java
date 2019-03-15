
public class Fight {
	
	public Fight() {
		
	}


	public void Attack(Hero first, Hero second, char land) {		
		if(checkAlive(first) == false || checkAlive(second) == false) {
			System.out.println("aiiiiici");
			return;
		}
		System.out.println(first.Hp + "HASP" + second.Hp);
		
		first.FirstAbility.attack(second, land, first.lvl);
		first.SecondAbility.attack(second, land, first.lvl);
		second.FirstAbility.attack(first, land, second.lvl);
		second.SecondAbility.attack(first, land, second.lvl);
		
		first.Hp = first.HpAfterBattle;
		second.Hp = second.HpAfterBattle;
		if(checkAlive(first) == false && checkAlive(second) == true) {
			second.updateXP(first);
		}
		if(checkAlive(second) == false && checkAlive(first) == true) {
			first.updateXP(second);
		}
	}
	
	public void applyOvertime(Hero a) {
		if(a.isOvertimeDmg == false) {
			return;
		}
		if(a.countOvertime < a.overtimeLimit) {
			a.Hp -= a.dmgOvertime;
			a.countOvertime++;
			return;
		}
		if(a.overtimeLimit != 0)
		{
			a.isOvertimeDmg = false;
			a.isStuned = false;
			a.overtimeLimit = 0;
			a.countOvertime = 0;
		}
	}
	
	public boolean checkAlive(Hero a) {
		if(a.Hp <= 0) {
			a.isAlive = false;
			return false;
		}
		return true;
	}
}
