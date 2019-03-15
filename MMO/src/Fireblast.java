
public class Fireblast extends Ability{

	Fireblast() {
		super.setModif(-20, 20, -10, 5);
		super.setDamageAndBonus(350, 50);
		super.setTerrain('V');
		super.setTerrainBonus(25);
		super.setOvertime(false);
	}
	
	@Override
	public void attack(Hero opponent, char land, int lvl) {
		float dmg = Math.round(super.raceModifier(opponent.type));
		if(land == super.terrain) {
			dmg = Math.round(super.applyTerrainBonus(dmg));
		}
		
		opponent.HpAfterBattle -= dmg; 
		System.out.println(dmg+"DMG FIREBLAST");
		
	}
		
}
