import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class BPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private Image background,
	flechaEnemigo,
	flechaNombre;

	protected JProgressBar playerMonHP,
	enemyMonHP;

	public String playerMonName;
	public String playerAction;

	protected Pokemon[] playerTeam = new Pokemon[6];
	
	protected Pokemon[] enemyTeam = new Pokemon[20];


	protected PlayerMon PlayerMon;
	protected EnemyMon EnemyMon;

	public int monActive = 2,
			//enemyMonActive = 8,
			enemyMonActive = (int)Math.ceil(Math.random() * 12),
			damage, 
			dps,
			enemyGoDown = 0,
			playerGoDown = 0;

	protected BFrame BFrame;

	public BPanel(BFrame BFrame) {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(530, 340));
		
		//(String name, String type, String type2, int lvl, int hp, int atk, int def, int spatk, int spdef, int spd, Move move1, Move move2, Move move3, Move move4)
		this.playerTeam[0] = new PlayerMon("AERODACTYL", "ROCK", "FLYING",    52, 161, 430, 88, 83, 99, 156, new Move("WING ATTACK"), new Move("STONE EDGE"), new Move("HEAD SMASH"), new Move("EARTHQUAKE"));
		this.playerTeam[1] = new PlayerMon("PIKACHU",    "ELECTRIC", "",      47, 104, 171, 57, 66, 66, 104, new Move("THUNDERSHOCK"), new Move("VOLT TACKLE"), new Move("QUICK ATTACK"), new Move("IRON TAIL"));
		this.playerTeam[2] = new PlayerMon("TYRANITAR",  "ROCK", "DARK",      65, 225, 499, 168, 148, 155, 104, new Move("STONE EDGE"), new Move("CRUNCH"), new Move("EARTHQUAKE"), new Move("FIRE BLAST"));
		this.playerTeam[3] = new PlayerMon("MEWTWO",     "PSYCHIC", "",       71, 253, 493, 154, 245, 154, 211, new Move("PSYSTRIKE"), new Move("THUNDER"), new Move("BLIZZARD"), new Move("SHADOW BALL"));
		this.playerTeam[4] = new PlayerMon("LUGIA",      "PSYCHIC", "FLYING", 71, 253, 454, 245, 154, 211, 183, new Move("AEROBLAST"), new Move("AQUA TAIL"), new Move("PSYSHOCK"), new Move("DRAGON PULSE"));
		this.playerTeam[5] = new PlayerMon("MACHAMP",    "FIGHTING", "",      60, 196, 479, 119, 101, 125, 89, new Move("DYNAMIC PUNCH"), new Move("MACH PUNCH"), new Move("ICE PUNCH"), new Move("FIRE PUNCH"));
		this.PlayerMon = (PlayerMon) playerTeam[monActive];
		
		//(String name, String type, String type2, int lvl, int hp, int atk, int def, int spatk, int spdef, int spd, Move move1, Move move2, Move move3, Move move4)
		this.enemyTeam[1] = new EnemyMon("SCIZOR", "BUG", "STEEL",      71, 302, 511, 169, 105, 140, 119, new Move("X-SCISSOR"), new Move("BUG BITE"), new Move("BULLET PUNCH"), new Move("IRON HEAD"));
		this.enemyTeam[2] = new EnemyMon("ARCANINE", "FIRE", "",        65, 312, 468, 129, 155, 129, 148, new Move("EARTHQUAKE"), new Move("EXTREMESPEED"), new Move("FLAMETHROWER"), new Move("FIRE BLAST"));
		this.enemyTeam[3] = new EnemyMon("HO-OH", "FLYING", "FIRE",     90, 418, 566, 310, 230, 194, 194, new Move("SACRED FIRE"), new Move("FLAME CHARGE"), new Move("BRAVE BIRD"), new Move("FIRE BLAST"));
		this.enemyTeam[4] = new EnemyMon("SKARMORY", "STEEL", "FLYING", 74, 303, 346, 235, 87, 131, 131, new Move("BRAVE BIRD"), new Move("IRON HEAD"), new Move("WING ATTACK"), new Move("BODY SLAM"));
		this.enemyTeam[5] = new EnemyMon("SNORLAX", "NORMAL", "", 		80, 470, 505, 133, 133, 205, 77, new Move("HYPER BEAM"), new Move("BODY SLAM"), new Move("DYNAMIC PUNCH"), new Move("CRUNCH"));
		this.enemyTeam[6] = new EnemyMon("LAPRAS", "WATER", "ICE", 		60, 344, 425, 119, 125, 137, 95, new Move("BLIZZARD"), new Move("SURF"), new Move("ICE BEAM"), new Move("BODY SLAM"));
		this.enemyTeam[7] = new EnemyMon("AERODACTYL", "ROCK", "FLYING",72, 319, 478, 120, 113, 135, 214, new Move("WING ATTACK"), new Move("STONE EDGE"), new Move("HEAD SMASH"), new Move("EARTHQUAKE"));
		this.enemyTeam[8] = new EnemyMon("PIKACHU",    "ELECTRIC", "",  57, 224, 185, 68, 79, 79, 125, new Move("THUNDERSHOCK"), new Move("VOLT TACKLE"), new Move("QUICK ATTACK"), new Move("IRON TAIL"));
		this.enemyTeam[9] = new EnemyMon("TYRANITAR",  "ROCK", "DARK",  73, 351, 523, 188, 166, 173, 116, new Move("STONE EDGE"), new Move("CRUNCH"), new Move("EARTHQUAKE"), new Move("FIRE BLAST"));
		this.enemyTeam[10] = new EnemyMon("MEWTWO",     "PSYCHIC", "",  100, 453, 544, 216, 256, 216, 296, new Move("PSYSTRIKE"), new Move("THUNDER"), new Move("BLIZZARD"), new Move("SHADOW BALL"));
		this.enemyTeam[11] = new EnemyMon("LUGIA", "PSYCHIC", "FLYING", 94, 432, 503, 323, 203, 278, 240, new Move("AEROBLAST"), new Move("AQUA TAIL"), new Move("PSYSHOCK"), new Move("DRAGON PULSE"));
		this.enemyTeam[12] = new EnemyMon("MACHAMP",    "FIGHTING", "", 75, 343, 423, 148, 125, 155, 110, new Move("DYNAMIC PUNCH"), new Move("MACH PUNCH"), new Move("ICE PUNCH"), new Move("FIRE PUNCH"));
		this.EnemyMon = (EnemyMon)enemyTeam[enemyMonActive];
		
		this.playerMonHP = new JProgressBar(0, PlayerMon.getTotalHp());
		this.playerMonHP.setValue(PlayerMon.getCurrentHp());
		this.playerMonHP.setBounds(290, 270, 180, 11);
		this.playerMonHP.setForeground(Color.GREEN);
		this.add(playerMonHP);

		this.enemyMonHP = new JProgressBar(0, EnemyMon.getTotalHp());
		this.enemyMonHP.setValue(EnemyMon.getCurrentHp());
		this.enemyMonHP.setBounds(65, 75, 180, 11);
		this.enemyMonHP.setForeground(Color.GREEN);
		this.add(enemyMonHP);

		this.background = new ImageIcon("GUI/background.jpg").getImage();
		this.flechaNombre = new ImageIcon("GUI/flechaNombre.jpg").getImage();
		this.flechaEnemigo = new ImageIcon("GUI/flechaNombre2.jpg").getImage();
	}

	public void resetField() {
		this.hpCalc(BFrame.BPanel.getGraphics());
		BFrame.BPanel.playerGoDown = 0;
		BFrame.BSelectMove.moveIsSelected = false;
		BFrame.BSelectMove.isEnemyDead = false;
		BFrame.BSelectMove.isPlayerDead = false;
		BFrame.BText.isPlayerTurn = true;
	}

	public void hpCalc(Graphics g) {
		if((EnemyMon.getTotalHp() / 4) > (EnemyMon.getCurrentHp())) {
			this.enemyMonHP.setForeground(Color.RED);
		}else {
			if((EnemyMon.getTotalHp() / 2) > (EnemyMon.getCurrentHp())) {
				this.enemyMonHP.setForeground(Color.YELLOW);
			}
		}
		if((EnemyMon.getTotalHp() / 2) < (EnemyMon.getCurrentHp())) {
			this.enemyMonHP.setForeground(Color.GREEN);
		}

		if((PlayerMon.getTotalHp() / 4) > (PlayerMon.getCurrentHp())) {
			this.playerMonHP.setForeground(Color.RED);
		}else {
			if((PlayerMon.getTotalHp() / 2) > (PlayerMon.getCurrentHp())) {
				this.playerMonHP.setForeground(Color.YELLOW);
			}
		}
		if((PlayerMon.getTotalHp() / 2) < (PlayerMon.getCurrentHp())) {
			this.playerMonHP.setForeground(Color.GREEN);
		}

		this.playerMonHP.setMaximum(this.PlayerMon.getTotalHp());
		this.playerMonHP.setValue(this.PlayerMon.getCurrentHp());
		this.enemyMonHP.setMaximum(this.EnemyMon.getTotalHp());
		this.enemyMonHP.setValue(this.EnemyMon.getCurrentHp());

		g.setFont(new Font("TimesRoman", Font.PLAIN, 33)); 
		g.drawString(Integer.toString(PlayerMon.getCurrentHp()), 350, 312);
		g.drawString("/", 410, 312);
		g.drawString(Integer.toString(PlayerMon.getTotalHp()), 420, 312);
	}

	public void drawField(Graphics g) {
		g.drawImage(background, 0, 0, this);
		g.drawImage(this.flechaNombre, 233, 255, this);
		g.drawImage(this.flechaEnemigo, 10, 65, this);
	}

	public void drawOverlay(Graphics g) {
		g.drawString(this.PlayerMon.getName(), 263, 232);
		g.drawString(":L" + Integer.toString(this.PlayerMon.getLvl()), 353, 265);
		g.drawString(this.EnemyMon.getName(), 18, 32);
		g.drawString(":L" + Integer.toString(this.EnemyMon.getLvl()), 65, 65);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 14)); 
		g.drawString("HP:", 266, 280);
		g.drawString("HP:", 40, 85);
	}

	public void drawPlayerMon(Graphics g) {
		this.PlayerMon = (PlayerMon) playerTeam[monActive];
		g.drawImage(this.PlayerMon.getBackSprite(), 30 - playerGoDown, 140, this);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 38));
	}

	public void drawEnemyMon(Graphics g) {
		g.drawImage(this.EnemyMon.getFrontSprite(), 285 + enemyGoDown, 5, this);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 38));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawField(g);
		this.drawEnemyMon(g);
		this.drawPlayerMon(g);
		this.drawOverlay(g);
		this.hpCalc(g);
		if(this.EnemyMon.getCurrentHp() == 0) {
			enemyGoDown+= 1000;
			this.drawEnemyMon(g);
		}
		if(this.PlayerMon.getCurrentHp() == 0) {
			playerGoDown+= 1000;
			this.drawPlayerMon(g);
		}
	}


}
