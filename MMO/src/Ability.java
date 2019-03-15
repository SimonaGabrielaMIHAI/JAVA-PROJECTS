
public class Ability {
	protected float modifRogue;
	protected float modifKnight;
	protected float modifPyro;
	protected float modifWizard;
	protected float damage;
	protected float damageBonusLvl;
	protected char terrain;
	protected float terrainBonus;
	private boolean isOvertime;
	protected float dmgOvertime;
	private float dmgOvertimeBonusLvl;
	
	public void attack(Hero opponent, char land, int lvl) {
	}
	
	public void setModif(float R, float K, float P, float W){
		modifRogue = R;
		modifKnight = K;
		modifPyro = P;
		modifWizard = W;
	}

	public void setDamageAndBonus(float dmg, float bonusDmg) {
		damage = dmg;
		damageBonusLvl = bonusDmg;
	}
	
	public void setDamageAndBonusOvertime(float dmg, float bonusDmg) {
		dmgOvertime = dmg;
		dmgOvertimeBonusLvl = bonusDmg;
	}

	public boolean isOvertime() {
		return isOvertime;
	}

	public void setOvertime(boolean overtime) {
		isOvertime = overtime;
	}
	
	public void lvlUpUpdate() {
		damage += damageBonusLvl;
		dmgOvertime += dmgOvertimeBonusLvl;
	}
	
	public float raceModifier(char opponent) {
		float newDamage = 0;
		if(opponent == 'R')
			newDamage = damage + (modifRogue * damage) / 100;
		if(opponent == 'K')
			newDamage = damage + (modifKnight * damage) / 100;
		if(opponent == 'P')
			newDamage = damage + (modifPyro * damage) / 100;
		if(opponent == 'W')
			newDamage = damage + (modifWizard * damage) / 100;
		
		return newDamage;
	}

	public void setTerrain(char terr) {
		terrain = terr;
	}

	public void setTerrainBonus(int terrBonus) {
		terrainBonus = terrBonus;		
	}
	
	protected float applyTerrainBonus(float dmg) {
		return (dmg + (dmg * terrainBonus) / 100);
	}

}


