
public class Drain extends Ability {

	Drain() {
		super.setModif(-20, 20, -10, 5);
		super.setDamageAndBonus(20, 5);
		super.setTerrain('D');
		super.setTerrainBonus(10);
		super.setOvertime(false);
	}

	@Override
	public void attack(Hero opponent, char land, int lvl) {
		float dmg;
		
		dmg = Math.round(super.raceModifier(opponent.type));
		
		if(land == super.terrain) {
			dmg = Math.round(super.applyTerrainBonus(dmg));
		}
		float oppHp = opponent.HpInit + opponent.lvl * opponent.HpBonusLvl;
		dmg = dmg * Math.min(0.3f * oppHp, opponent.Hp) / 100;	
		
		opponent.HpAfterBattle -= dmg;
	}
}
