import javax.swing.ImageIcon;

public class PlayerMon extends Pokemon{
	public Move playerMonAttack1;
	public Move playerMonAttack2;
	public Move playerMonAttack3;
	public Move playerMonAttack4;

	public PlayerMon(String name, String type, String type2, int lvl, int hp, int atk, int def, int spatk, int spdef, int spd, Move move1, Move move2, Move move3, Move move4) {
		this.setName(name);
		this.setBackSprite(new ImageIcon("sprites_back\\" + this.getName() + ".png").getImage());
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
		this.playerMonAttack1 = move1;
		this.playerMonAttack2 = move2;
		this.playerMonAttack3 = move3;
		this.playerMonAttack4 = move4;
	}
	
}
