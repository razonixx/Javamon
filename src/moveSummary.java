import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class moveSummary extends JPanel{
	protected BFrame BFrame;
	private Image textBoxChica;
	
	public moveSummary(BFrame BFrame) {
		this.BFrame = BFrame;
		this.textBoxChica = new ImageIcon("GUI/textBoxChica3.png").getImage();	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 38)); 
		g.drawImage(this.textBoxChica, 10, 0, this);	
		switch (BFrame.BSelectMove.hoverAttack) {
		case 1:
			g.drawString("TYPE\\", 20, 50);
			g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack1.getType(), 50, 80);
			g.setFont(new Font("TimesRoman", Font.BOLD, 38)); 
			g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack1.getCurrentPP() + " / " + BFrame.BPanel.PlayerMon.playerMonAttack1.getTotalPP(), 110, 110);
			break;			
		case 2:
			g.drawString("TYPE\\", 20, 50);
			g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack2.getType(), 50, 80);
			g.setFont(new Font("TimesRoman", Font.BOLD, 38)); 
			g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack2.getCurrentPP() + " / " + BFrame.BPanel.PlayerMon.playerMonAttack2.getTotalPP(), 110, 110);
			break;	
		case 3:
			g.drawString("TYPE\\", 20, 50);
			g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack3.getType(), 50, 80);
			g.setFont(new Font("TimesRoman", Font.BOLD, 38)); 
			g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack3.getCurrentPP() + " / " + BFrame.BPanel.PlayerMon.playerMonAttack3.getTotalPP(), 110, 110);
			break;	
		case 4:
			g.drawString("TYPE\\", 20, 50);
			g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack4.getType(), 50, 80);
			g.setFont(new Font("TimesRoman", Font.BOLD, 38)); 
			g.drawString(BFrame.BPanel.PlayerMon.playerMonAttack4.getCurrentPP() + " / " + BFrame.BPanel.PlayerMon.playerMonAttack4.getTotalPP(), 110, 110);
			break;	

		default:
			break;
		}
	}
}
