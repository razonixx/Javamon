import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BSelectMove extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image textBoxChica;
	private BPanel BPanel;
	protected Move playerMove;
	private BFrame BFrame;
	protected BText BText;
	protected BControls BControls;
	protected JButton bMove1,
	bMove2,
	bMove3,
	bMove4;
	protected boolean bWait;
	protected boolean moveIsSelected = false;
	protected EnemyAI EnemyAI;
	protected boolean isEnemyDead = false,
			isPlayerDead = false;
	protected int hoverAttack = 0;
	private boolean isCritical = false;
	private boolean isSTAB = false;
	protected String effectiveness = "";

	public BSelectMove(BFrame BFrame, BPanel BPanel) {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(530, 132));
		this.textBoxChica = new ImageIcon("GUI/textBox.jpg").getImage();	
		this.BPanel = BPanel;
		this.BFrame = BFrame;
	}
	
	public void setUp() {
		playerMove.setCurrentPP(playerMove.getCurrentPP()-1);
		checkModifiers(BFrame.BPanel.PlayerMon, playerMove);
		BPanel.damage = calcDamage(BPanel.PlayerMon, BPanel.EnemyMon, playerMove);
		playerAttack();
		BFrame.BSelectMove.setVisible(false);	
		BFrame.BSelectMove.moveIsSelected = true;
		System.out.println(playerMove.getName());
		System.out.println(BFrame.BPanel.damage);
		if(playerMove.hasRecoil()) {
			recoilDamage(BFrame.BPanel.PlayerMon,(BFrame.BPanel.damage / 3));
		}
	}
	public void drawOptions() {
		bMove1 = new JButton();
		bMove1.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				playerMove = BFrame.BPanel.PlayerMon.playerMonAttack1;
				BFrame.BSelectMove.setUp();
			}
		});
		this.bMove1.setBounds(45, 30, 230, 35);
		this.bMove1.setBorderPainted(false);
		this.bMove1.setOpaque(false);
		this.bMove1.setContentAreaFilled(false);
		this.bMove1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				BFrame.moveSummary.setVisible(true);
				hoverAttack  = 1;
			}
			public void mouseExited(MouseEvent e) {
				bMove1.setBorderPainted(false);
				BFrame.moveSummary.setVisible(false);
			}
		});
		this.add(bMove1);

		bMove2 = new JButton();
		bMove2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				playerMove = BPanel.PlayerMon.playerMonAttack2;
				BFrame.BSelectMove.setUp();
			}
		});	
		this.bMove2.setBounds(250, 30, 190, 35);
		this.bMove2.setBorderPainted(false);
		this.bMove2.setOpaque(false);
		this.bMove2.setContentAreaFilled(false);
		this.bMove2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				BFrame.moveSummary.setVisible(true);
				hoverAttack  = 2;
			}
			public void mouseExited(MouseEvent e) {
				BFrame.moveSummary.setVisible(false);
			}
		});
		this.add(bMove2);	

		bMove3 = new JButton();
		bMove3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				playerMove = BPanel.PlayerMon.playerMonAttack3;
				BFrame.BSelectMove.setUp();
			}
		});	
		this.bMove3.setBounds(45, 75, 215, 35);
		this.bMove3.setBorderPainted(false);
		this.bMove3.setOpaque(false);
		this.bMove3.setContentAreaFilled(false);
		this.bMove3.setBorderPainted(false);
		this.bMove3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				BFrame.moveSummary.setVisible(true);
				hoverAttack  = 3;
			}
			public void mouseExited(MouseEvent e) {
				BFrame.moveSummary.setVisible(false);
			}
		});
		this.add(bMove3);

		bMove4 = new JButton();
		bMove4.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				playerMove = BPanel.PlayerMon.playerMonAttack4;
				BFrame.BSelectMove.setUp();
			}
		});
		this.bMove4.setBounds(250, 75, 180, 35);
		this.bMove4.setBorderPainted(false);
		this.bMove4.setOpaque(false);
		this.bMove4.setContentAreaFilled(false);
		this.bMove4.setBorderPainted(false);
		this.bMove4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				BFrame.moveSummary.setVisible(true);
				hoverAttack  = 4;
			}
			public void mouseExited(MouseEvent e) {
				BFrame.moveSummary.setVisible(false);
			}
		});
		this.add(bMove4);
	}
	
	public void checkEffectiveness(Move attacker, Pokemon defender) {
		if(attacker.getType() == "NORMAL" && defender.getType() == "ROCK") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "NORMAL" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "FIGHTING" && defender.getType() == "NORMAL") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FIGHTING" && defender.getType() == "FLYING") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "FIGHTING" && defender.getType() == "POISON") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "FIGHTING" && defender.getType() == "ROCK") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FIGHTING" && defender.getType() == "BUG") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "FIGHTING" && defender.getType() == "STEEL") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FIGHTING" && defender.getType() == "PSYCHIC") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "FIGHTING" && defender.getType() == "ICE") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FIGHTING" && defender.getType() == "DARK") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FLYING" && defender.getType() == "FIGHTING") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FLYING" && defender.getType() == "ROCK") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "FLYING" && defender.getType() == "BUG") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FLYING" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "FLYING" && defender.getType() == "GRASS") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FLYING" && defender.getType() == "ELECTRIC") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "POISON" && defender.getType() == "POISON") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "POISON" && defender.getType() == "GROUND") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "POISON" && defender.getType() == "ROCK") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "POISON" && defender.getType() == "GHOST") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "POISON" && defender.getType() == "GRASS") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GROUND" && defender.getType() == "POISON") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GROUND" && defender.getType() == "POISON") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GROUND" && defender.getType() == "ROCK") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GROUND" && defender.getType() == "BUG") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "GROUND" && defender.getType() == "STEEL") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GROUND" && defender.getType() == "FIRE") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GROUND" && defender.getType() == "GRASS") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "GROUND" && defender.getType() == "ELECTRIC") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "ROCK" && defender.getType() == "FIGHTING") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ROCK" && defender.getType() == "FIGHTING") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ROCK" && defender.getType() == "FLYING") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "ROCK" && defender.getType() == "GROUND") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ROCK" && defender.getType() == "BUG") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "ROCK" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ROCK" && defender.getType() == "FIRE") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "ROCK" && defender.getType() == "ICE") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "BUG" && defender.getType() == "FIGHTING") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "BUG" && defender.getType() == "FLYING") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "BUG" && defender.getType() == "ROCK") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "BUG" && defender.getType() == "POISON") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "BUG" && defender.getType() == "GHOST") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "BUG" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "BUG" && defender.getType() == "FIRE") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "BUG" && defender.getType() == "GRASS") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "BUG" && defender.getType() == "PSYCHIC") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "BUG" && defender.getType() == "DARK") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GHOST" && defender.getType() == "GHOST") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GHOST" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "GHOST" && defender.getType() == "PSYCHIC") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GHOST" && defender.getType() == "DARK") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "STEEL" && defender.getType() == "ROCK") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "STEEL" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "STEEL" && defender.getType() == "FIRE") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "STEEL" && defender.getType() == "WATER") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "STEEL" && defender.getType() == "ELECTRIC") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "STEEL" && defender.getType() == "ICE") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FIRE" && defender.getType() == "ROCK") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "FIRE" && defender.getType() == "BUG") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FIRE" && defender.getType() == "STEEL") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FIRE" && defender.getType() == "FIRE") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "FIRE" && defender.getType() == "WATER") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "FIRE" && defender.getType() == "GRASS") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FIRE" && defender.getType() == "ICE") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "FIRE" && defender.getType() == "DRAGON") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "WATER" && defender.getType() == "GROUND") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "WATER" && defender.getType() == "ROCK") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "WATER" && defender.getType() == "FIRE") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "WATER" && defender.getType() == "WATER") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "WATER" && defender.getType() == "GRASS") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "WATER" && defender.getType() == "DRAGON") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "GRASS" && defender.getType() == "FLYING") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "GRASS" && defender.getType() == "POISON") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "GRASS" && defender.getType() == "GROUND") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GRASS" && defender.getType() == "ROCK") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GRASS" && defender.getType() == "BUG") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "GRASS" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "GRASS" && defender.getType() == "FIRE") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "GRASS" && defender.getType() == "WATER") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "GRASS" && defender.getType() == "GRASS") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "GRASS" && defender.getType() == "DRAGON") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ELECTRIC" && defender.getType() == "FLYING") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "ELECTRIC" && defender.getType() == "WATER") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "ELECTRIC" && defender.getType() == "GRASS") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ELECTRIC" && defender.getType() == "ELECTRIC") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ELECTRIC" && defender.getType() == "DRAGON") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "PSYCHIC" && defender.getType() == "FIGHTING") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "PSYCHIC" && defender.getType() == "POISON") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "PSYCHIC" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "PSYCHIC" && defender.getType() == "PSYCHIC") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ICE" && defender.getType() == "FLYING") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "ICE" && defender.getType() == "GROUND") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "ICE" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ICE" && defender.getType() == "FIRE") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ICE" && defender.getType() == "WATER") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ICE" && defender.getType() == "GRASS") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "ICE" && defender.getType() == "ICE") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "ICE" && defender.getType() == "DRAGON") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "DRAGON" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "DRAGON" && defender.getType() == "DRAGON") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "DARK" && defender.getType() == "FIGHTING") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "DARK" && defender.getType() == "GHOST") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "DARK" && defender.getType() == "STEEL") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
		if(attacker.getType() == "DARK" && defender.getType() == "PSYCHIC") {
			this.effectiveness = "SUPEREFFECTIVE";
		}
		if(attacker.getType() == "DARK" && defender.getType() == "DARK") {
			this.effectiveness = "NOTVERYEFFECTIVE";
		}
	}

	
	public void checkModifiers(Pokemon pokemon, Move move) {	
		//Critcal
		if(new Random().nextInt(16/move.getCritModifier())==0) {
			isCritical = true;
		}
		//STAB
		if(pokemon.getType() == move.getType() || pokemon.getType2() == move.getType()) {
			isSTAB = true;
		}
	}

	public int calcDamage(Pokemon attacker, Pokemon defender, Move move) {
		double d = (((((2*attacker.getLvl())/5+2) * move.getPower() * (attacker.getAtk()/defender.getDef()))/50) + 2) * (((Math.random() * 78) + 217)/255);
		
		this.checkEffectiveness(move, defender);
		
		if(isCritical) {
			d*= 1.5; 
			System.out.println("Critical!");
			isCritical = false;
		}
		if(isSTAB) {
			d*= 1.5;
			System.out.println("STAB!");
			isSTAB = false;
		}
		switch (effectiveness) {
		case "INNEFECTIVE":
			d *= 0;
			break;
		case "NOTVERYEFFECTIVE2":
			d *= .5;
			System.out.println("Not Very Effective *.5");
			break;
		case "NOTVERYEFFECTIVE":
			d *= .25;
			System.out.println("Not Very Effective *.25");
			break;
		case "SUPEREFFECTIVE":
			d *= 2;
			System.out.println("Super Effective x2");
			break;	
		case "SUPEREFFECTIVE2":
			d *= 4;
			System.out.println("Super Effective x4");
			break;
		default:
			d*= 1;
			break;
		}
		return (int)d;
	}
	
	public void recoilDamage(Pokemon pokemon, int damage) {
		Thread wait = new Thread(new Runnable() {
			@Override
			public void run() {
				int c = damage;
				System.out.println("Recoil damage: " + c);
				BPanel.dps = 0;
				try {
					while(c != 0) {
						c--;
						if(pokemon.getCurrentHp() == 0) {
							isEnemyDead = true;
							break;
						}
						pokemon.setCurrentHp(pokemon.getCurrentHp() - 1);
						Thread.sleep(3000/damage);
						if(BPanel.dps == damage) {
							BFrame.BControls.playerAction = "";
							break;
						}
					}
				} catch (InterruptedException e) {
				}
			}
		});
		wait.start();
	}

	public void decreaseHP(Pokemon pokemon) {
		Thread wait = new Thread(new Runnable() {
			@Override
			public void run() {
				BFrame.BPanel.dps = 0;
				try {
					while(BFrame.BPanel.damage != BFrame.BPanel.damage*2) {
						BFrame.BPanel.dps++;
						if(pokemon == BFrame.BPanel.EnemyMon && pokemon.getCurrentHp() == 0) {
							isEnemyDead = true;
							BFrame.clip.stop();
							BFrame.OWPanels.clip.start();
							BFrame.OWPanels.battleFlag = false;
							BFrame.OWPanels.tm.start();
							BFrame.setVisible(false);
							BFrame.repaint();
							break;
						}
						if(pokemon == BFrame.BPanel.PlayerMon && pokemon.getCurrentHp() == 0) {
							isPlayerDead = true;
							BFrame.repaint();
							
							if(pokemon == BFrame.BPanel.playerTeam[0]) {
								BFrame.BChoosePokemon.pokemon1.setEnabled(false);
							}
							if(pokemon == BFrame.BPanel.playerTeam[1]) {
								BFrame.BChoosePokemon.pokemon2.setEnabled(false);
							}
							if(pokemon == BFrame.BPanel.playerTeam[2]) {
								BFrame.BChoosePokemon.pokemon3.setEnabled(false);
							}
							if(pokemon == BFrame.BPanel.playerTeam[3]) {
								BFrame.BChoosePokemon.pokemon4.setEnabled(false);
							}
							if(pokemon == BFrame.BPanel.playerTeam[4]) {
								BFrame.BChoosePokemon.pokemon5.setEnabled(false);
							}
							if(pokemon == BFrame.BPanel.playerTeam[5]) {
								BFrame.BChoosePokemon.pokemon6.setEnabled(false);
							}
							break;
						}
						pokemon.setCurrentHp(pokemon.getCurrentHp() - 1);
						BFrame.BPanel.repaint();
						Thread.sleep(3000/BFrame.BPanel.damage);
						if(BFrame.BPanel.dps == BFrame.BPanel.damage) {
							BFrame.BControls.playerAction = "";
							break;
						}
					}
					if(pokemon == BFrame.BPanel.EnemyMon) {
						if(BFrame.BPanel.EnemyMon.getCurrentHp() != 0) {
							BFrame.EnemyAI.enemyAttack();
							BFrame.BText.isPlayerTurn = false;
							BFrame.BSelectMove.effectiveness = "";
						}
					}else {
						if(pokemon == BFrame.BPanel.PlayerMon) {
							if(BFrame.BPanel.dps == BFrame.BPanel.damage) {
								BFrame.BControls.playerAction = "";
								BFrame.BSelectMove.moveIsSelected = false;
								BFrame.BText.isPlayerTurn = false;
								BFrame.BText.repaint();
								BFrame.BControls.setVisible(true);
								BFrame.BSelectMove.effectiveness = "";
							}	
						}
					}
				} catch (InterruptedException e) {
				}
			}
		});
		wait.start();
	}

	public void playerAttack() {
		if(BFrame.BPanel.PlayerMon.getSpd() > BFrame.BPanel.EnemyMon.getSpd()) {
			
		}else {
			
		}
		decreaseHP(BFrame.BPanel.EnemyMon);
		BFrame.BText.isPlayerTurn = true;
	}

	public void enemyAttack() {
		BFrame.BText.isPlayerTurn = false;
		decreaseHP(BFrame.BPanel.PlayerMon);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.textBoxChica, 10, 0, this);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack1.getName(), 35, 60);
		g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack2.getName(), 270, 60);
		g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack3.getName(), 35, 100);
		g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack4.getName(), 270, 100);
		drawOptions();
	}

}
