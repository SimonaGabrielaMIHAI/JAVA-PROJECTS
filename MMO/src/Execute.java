
public class Execute extends Ability{
	
	Execute() {
		super.setModif(15, 0, 10, -20);
		super.setDamageAndBonus(200, 30);
		super.setTerrain('L');
		super.setTerrainBonus(15);
		super.setOvertime(false);
	}

	@Override
	public void attack(Hero opponent, char land, int lvl) {
		float opHp = opponent.HpInit + opponent.HpBonusLvl * opponent.lvl;
		float proc = Math.min(20 + lvl, 40);
		float HpLimit = (proc * opHp) / 100;
		
		if(HpLimit > opponent.Hp) {
			opponent.HpAfterBattle = 0;
			return;
		}
		
		float dmg = Math.round(super.raceModifier(opponent.type));
		if(land == super.terrain) {
			dmg = Math.round(super.applyTerrainBonus(dmg));
		}
		
		opponent.HpAfterBattle -= dmg;	
		System.out.println(dmg + "DMG EXECUTE");
	}
}
