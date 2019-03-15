
public class Slam extends Ability{
	
	Slam() {
		super.setModif(-20, 20, -10, 5);
		super.setDamageAndBonus(100, 40);
		super.setTerrain('L');
		super.setTerrainBonus(15);
		super.setOvertime(true);
	}
	
	@Override
	public void attack(Hero opponent, char land, int lvl) {
		float dmg = Math.round(super.raceModifier(opponent.type));
		if(land == super.terrain) {
			dmg = Math.round(super.applyTerrainBonus(dmg));
		}
		
		opponent.HpAfterBattle -= dmg; 
		opponent.isStuned = true;
		opponent.overtimeLimit = 1;
		opponent.countOvertime = 0;
		opponent.dmgOvertime = 0;
		
	}

}
