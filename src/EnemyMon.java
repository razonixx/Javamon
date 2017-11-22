import javax.swing.ImageIcon;

public class EnemyMon extends Pokemon{
	
	protected Move enemyMonAttack1;
	protected Move enemyMonAttack2;
	protected Move enemyMonAttack3;
	protected Move enemyMonAttack4;
	
	public EnemyMon(String name, String type, String type2, int lvl, int hp, int atk, int def, int spatk, int spdef, int spd, Move move1, Move move2, Move move3, Move move4) {
		this.setName(name);
		this.setFrontSprite(new ImageIcon("sprites_front\\" + this.getName() + ".png").getImage());
		this.setType(type);
		this.setType2(type2);
		this.setLvl(lvl);
		this.setTotalHp(hp);
		this.setCurrentHp(hp);
		this.setAtk(atk);
		this.setDef(def);
		this.setSpatk(spatk);
		this.setSpdef(spdef);
		this.setSpd(spd);
		this.enemyMonAttack1 = move1;
		this.enemyMonAttack2 = move2;
		this.enemyMonAttack3 = move3;
		this.enemyMonAttack4 = move4;
	}
}
