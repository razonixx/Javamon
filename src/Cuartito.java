import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Cuartito extends OWPanels{

	private static final long serialVersionUID = 9113446609707779158L;

	public Cuartito(OWFrame OWFrame) {
		this.OWFrame = OWFrame;
		this.background = new ImageIcon("Overworld/Cuartito.png").getImage();
		super.tm = new Timer(15, this);
		this.tm.start();
		this.playerX = 235;
		this.playerY = 446;
		this.setLayout(null);
		this.add(characterMovement);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		try {
			File soundFile = new File("sound/ViridianForest.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			this.clip = AudioSystem.getClip();
			clip.open(audioIn);
			//clip.start();
		} catch (UnsupportedAudioFileException | IOException  | LineUnavailableException e) {
		} 
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.background, this.mapX, this.mapY, this);
		this.characterMovement.setBounds(playerX, playerY, 30, 30);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		characterMovement.timer.start();
		switch (k) {
		case KeyEvent.VK_LEFT:
			playerdx = -1;
			playerdy = 0;
			System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			OWFrame.playerSprite = OWFrame.playerLeft;
			break;

		case KeyEvent.VK_RIGHT:
			playerdx = 1;
			playerdy = 0;
			System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			OWFrame.playerSprite = OWFrame.playerRight;
			break;

		case KeyEvent.VK_UP:
			playerdx = 0;
			playerdy = -1;
			System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			OWFrame.playerSprite = OWFrame.playerBack;
			break;

		case KeyEvent.VK_DOWN:
			playerdx = 0;
			playerdy = 1;
			System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			OWFrame.playerSprite = OWFrame.playerFront;
			break;

		default:
			System.out.println("entro a def");
			break;
		}	
		
		if(!trainer1) {
			if(OWFrame.Cuartito.playerX >200 && OWFrame.Cuartito.playerX < 220) {
				if(OWFrame.Cuartito.playerY > 65 && OWFrame.Cuartito.playerY < 80) {
					super.trainerBattle(true);
					trainer1 = true;
				}
			}
		}
		if(!trainer2) {
			if(OWFrame.Cuartito.playerX >390 && OWFrame.Cuartito.playerX < 420) {
				if(OWFrame.Cuartito.playerY > 50 && OWFrame.Cuartito.playerY < 70) {
					super.trainerBattle(true);
					trainer2 = true;
				}
			}
		}
		
		if(trainer1 && trainer2) {
			if(OWFrame.Cuartito.playerX >250 && OWFrame.Cuartito.playerX < 270) {
				if(OWFrame.Cuartito.playerY < 20) {
					OWFrame.Cuartito.setVisible(false);
					OWFrame.Cuartito.setFocusable(false);
					OWFrame.Cuartito.clip.stop();
					OWFrame.Cuartito.mapdx = 0;
					OWFrame.Cuartito.playerdx = 0;
					OWFrame.Cuartito.mapdy = 0;
					OWFrame.Cuartito.playerdy = 0;
					OWFrame.ViridianForest.setVisible(true);
					OWFrame.ViridianForest.setFocusable(true);
					OWFrame.ViridianForest.clip.start();
					OWFrame.ViridianForest.playerX = 1630;
					OWFrame.ViridianForest.playerY = 2800;
					OWFrame.repaint();
				}
			}
		}
		if(OWFrame.Cuartito.playerX >200 && OWFrame.Cuartito.playerX < 250) {
			if(OWFrame.Cuartito.playerY > 447) {
				OWFrame.Cuartito.setVisible(false);
				OWFrame.Cuartito.setFocusable(false);
				OWFrame.Route2.setFocusable(true);
				OWFrame.Cuartito.clip.stop();
				OWFrame.Route2.setVisible(true);
				OWFrame.Route2.mapX = 5;
				OWFrame.Route2.mapY = 470;
				OWFrame.Route2.playerX = 85;
				OWFrame.Route2.playerY = 1670;
				OWFrame.Route2.clip.start();
				OWFrame.repaint();
			}
		}
	}
}