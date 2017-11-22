import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//TODO: Aveces se pinta lo que hace el enemigo y a veces no, no se porque

public class BText extends JPanel{
	private static final long serialVersionUID = 1L;

	protected Image textBox;
	protected BFrame BFrame;
	protected boolean isPlayerTurn = false;
	boolean bWait = true;
	private boolean playerEffectiveFlag = false;

	private boolean playerIneffectiveFlag = false;


	public BText(BFrame BFrame) {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(530, 132));
		this.textBox = new ImageIcon("GUI/textBox.jpg").getImage();	
		this.BFrame = BFrame;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 38));
		g.drawImage(this.textBox, 10, 0, this);

		//Enemy Fainted
		if(BFrame.BSelectMove.isEnemyDead) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 38)); 
			g.drawString(BFrame.BPanel.EnemyMon.getName(), 33, 59);
			g.drawString(" fainted ! ", 40, 96);
			BFrame.BText.repaint();
		}

		//Player Fainted
		if(BFrame.BSelectMove.isPlayerDead) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 38)); 
			g.drawString(BFrame.BPanel.PlayerMon.getName(), 33, 59);
			g.drawString(" fainted ! ", 40, 96);
			BFrame.BChoosePokemon.setVisible(true);
			BFrame.BText.repaint();
		}

		//Player clicks RUN
		if(BFrame.BControls.playerAction == "RUN") {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 38)); 
			g.drawString("There's no running from a", 33, 56);
			g.drawString("TRAINER battle !", 33, 96);
			this.repaint();
		}

		//Player clicks FIGHT
		if(BFrame.BSelectMove.isPlayerDead == false && BFrame.BSelectMove.isEnemyDead == false 
				&& isPlayerTurn && BFrame.BSelectMove.moveIsSelected && playerEffectiveFlag == false 
				&& playerIneffectiveFlag  == false) {	
			this.repaint();
			g.setFont(new Font("TimesRoman", Font.PLAIN, 38)); 
			g.drawString(BFrame.BPanel.PlayerMon.getName(), 33, 59);
			g.drawString(" used " + BFrame.BSelectMove.playerMove.getName() + " !", 40, 96);
		}

		//Enemy Attacks
		if(BFrame.EnemyAI.moveN != 0) {
			System.out.println("Entro a pintar accion de enemigo");
			switch (BFrame.EnemyAI.moveN) {
			case 1:
				g.setFont(new Font("TimesRoman", Font.PLAIN, 38)); 
				g.drawString("Enemy " + BFrame.BPanel.EnemyMon.getName(), 33, 59);
				g.drawString(" used " + BFrame.BPanel.EnemyMon.enemyMonAttack1.getName() + " !", 40, 96);
				BFrame.EnemyAI.moveN = 0;
				break;

			case 2:
				g.setFont(new Font("TimesRoman", Font.PLAIN, 38)); 
				g.drawString("Enemy " + BFrame.BPanel.EnemyMon.getName(), 33, 59);
				g.drawString(" used " + BFrame.BPanel.EnemyMon.enemyMonAttack2.getName() + " !", 33, 96);
				BFrame.EnemyAI.moveN = 0;
				break;

			case 3:
				g.setFont(new Font("TimesRoman", Font.PLAIN, 38)); 
				g.drawString("Enemy " + BFrame.BPanel.EnemyMon.getName(), 33, 59);
				g.drawString(" used " + BFrame.BPanel.EnemyMon.enemyMonAttack3.getName() + " !", 33, 96);
				BFrame.EnemyAI.moveN = 0;
				break;

			case 4:
				g.setFont(new Font("TimesRoman", Font.PLAIN, 38)); 
				g.drawString("Enemy " + BFrame.BPanel.EnemyMon.getName(), 33, 59);
				g.drawString(" used " + BFrame.BPanel.EnemyMon.enemyMonAttack4.getName() + " !", 33, 96);
				BFrame.EnemyAI.moveN = 0;
				break;
			default:
				break;
			}
		}
		if(!BFrame.BControls.isDisplayable()) {
			this.repaint();
		}
	}
}
