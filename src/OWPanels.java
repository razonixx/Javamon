import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OWPanels extends JPanel implements ActionListener, KeyListener{
	protected GamePane characterMovement = new GamePane();
	protected Timer tm;
	protected Clip clip;
	protected OWFrame OWFrame;
	protected BFrame BFrame;
	protected Image background;

	protected boolean trainer1 = false;
	protected boolean trainer2 = false;
	protected boolean trainer3 = false;
	protected boolean trainer4 = false;
	protected boolean trainer5 = false;
	protected boolean trainer6 = false;
	protected boolean trainer7 = false;
	protected boolean battleFlag = false;


	protected int mapX;
	protected int mapY;
	protected int mapdx = 0;
	protected int mapdy = 0;
	protected int playerX;
	protected int playerY;
	protected int playerdx = 0;
	protected int playerdy = 0;

	public void wildEncounter() {
		if(!battleFlag && new Random().nextInt(120)==0) {
			mapdx = 0;
			playerdx = 0;
			mapdy = 0;
			playerdy = 0;
			OWFrame.ViridianForest.clip.stop();
			OWFrame.ViridianForest.BFrame = new BFrame(this);
			this.tm.stop();
			battleFlag = true;
		}
	}
	
	public void trainerBattle(boolean music) {
		mapdx = 0;
		playerdx = 0;
		mapdy = 0;
		playerdy = 0;
		this.BFrame = new BFrame(this);
		if(music) {
			this.clip.stop();
			this.BFrame.clip.start();
		}
		this.tm.stop();
		battleFlag = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mapX += mapdx;
		mapY += mapdy;
		playerX += playerdx;
		playerY += playerdy;
		this.repaint();			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		mapdx = 0;
		playerdx = 0;
		mapdy = 0;
		playerdy = 0;
		characterMovement.timer.stop();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
