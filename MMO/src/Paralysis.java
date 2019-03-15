
public class Paralysis extends Ability{

	Paralysis() {
		super.setModif(-10, -20, 20, 25);
		super.setDamageAndBonus(40, 10);
		super.setTerrain('W');
		super.setTerrainBonus(15);
		super.setOvertime(true);
	}
	
	@Override
	public void attack(Hero opponent, char land, int lvl) {
		float dmg = Math.round(super.raceModifier(opponent.type));
		if(land == super.terrain) {
			dmg = Math.round(super.applyTerrainBonus(dmg));
			opponent.overtimeLimit = 6;
		}
		else {
			opponent.overtimeLimit = 3;
		}
		opponent.isOvertimeDmg = true;
		opponent.dmgOvertime = dmg;
		opponent.isStuned = true;
				
		opponent.HpAfterBattle -= dmg;
		System.out.println(dmg + "aaaaaaaaa");
		
	}
}
