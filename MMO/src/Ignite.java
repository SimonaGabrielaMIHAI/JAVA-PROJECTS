
public class Ignite extends Ability{
	
	Ignite() {
		super.setModif(-20, 20, -10, 5);
		super.setDamageAndBonus(150, 20);
		super.setDamageAndBonusOvertime(50, 30);
		super.setTerrain('V');
		super.setTerrainBonus(25);
		super.setOvertime(true);
	}
	
	@Override
	public void attack(Hero opponent, char land, int lvl) {
		
		float dmg = Math.round(super.raceModifier(opponent.type));
		
		if(land == super.terrain) {
			dmg = Math.round(super.applyTerrainBonus(dmg));
		}
		
		opponent.HpAfterBattle -= dmg; 
		opponent.isOvertimeDmg = true;
		opponent.dmgOvertime = dmgOvertime;
		opponent.countOvertime = 0;
		opponent.overtimeLimit = 2;
		System.out.println(dmg +"DMG IGNITE");
		
	}

}
