
public class Backstab extends Ability{
	
	protected int countCritical; 
	
	Backstab() {
		super.setModif(20, -10, 25, 25);
		super.setDamageAndBonus(200, 20);
		super.setTerrain('W');
		super.setTerrainBonus(15);
		super.setOvertime(false);
		countCritical = 3;
	}
	
	@Override
	public void attack(Hero opponent, char land, int lvl) {
		float dmg = damage;
		if(land == super.terrain && countCritical == 3) {
			damage = 1.5f * damage;
		}

		damage = Math.round(super.raceModifier(opponent.type));
		
		if(land == super.terrain) {
			damage = Math.round(super.applyTerrainBonus(damage));
		}
		
		opponent.HpAfterBattle -= damage; 
		System.out.println(damage + "ba");
		damage = dmg;
		if(countCritical == 3) {
			countCritical = 0;
		}
		else {
			countCritical++;
		}
		
	}
}
