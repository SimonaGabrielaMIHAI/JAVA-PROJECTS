
public class Deflect extends Ability{
	
	Deflect() {
		super.setModif(20, 40, 30, 0);
		super.setDamageAndBonus(35, 0);
		super.setTerrain('D');
		super.setTerrainBonus(10);
		super.setOvertime(false);
	}

	@Override
	public void attack(Hero opponent, char land, int lvl) {
		if(opponent.type == 'W') {
			return;
		}
		float dmgFirstAbil = opponent.FirstAbility.damage;
		float dmgSecondAbil = opponent.SecondAbility.damage;
		
		if(opponent.FirstAbility.terrain == land) {
			dmgFirstAbil = opponent.FirstAbility.applyTerrainBonus(dmgFirstAbil);
			dmgSecondAbil = opponent.SecondAbility.applyTerrainBonus(dmgSecondAbil);		
		}
		
		float dmgOpponent = Math.round(dmgFirstAbil) + Math.round(dmgSecondAbil);
		
		float proc = Math.min(damage + 2 * lvl, 70);
		
		float copy = damage;
		damage = (proc * dmgOpponent) / 100;
		damage = Math.round(super.raceModifier(opponent.type));
		opponent.HpAfterBattle -= damage;
		damage = copy;
		
	}
}
