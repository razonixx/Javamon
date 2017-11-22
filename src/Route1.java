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

public class Route1 extends OWPanels{

	private static final long serialVersionUID = -7251804850040452027L;

	public Route1(OWFrame OWFrame) {
		this.OWFrame = OWFrame;
		this.background = new ImageIcon("Overworld/Route1.png").getImage();
		this.playerX = 355;
		this.playerY = 1110;
		this.setLayout(null);
		this.add(characterMovement);
		super.tm = new Timer(15, this);
		this.tm.start();
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		try {
			File soundFile = new File("sound/Route1.wav");
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
			break;

		case KeyEvent.VK_RIGHT:
			playerdx = 1;
			playerdy = 0;
			System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			break;

		case KeyEvent.VK_UP:
			if(OWFrame.Route1.mapY <= 680) {
				mapdx = 0;
				mapdy = 1;
				System.out.println("Map X: " + mapX + " Map Y: " + mapY);
			}else {
				playerdx = 0;
				playerdy = -1;
				mapdx = 0;
				mapdy = 0;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			}
			break;

		case KeyEvent.VK_DOWN:
			if(OWFrame.Route1.mapY >= 0) {
				mapdx = 0;
				mapdy = -1;
				System.out.println("Map X: " + mapX + " Map Y: " + mapY);
			}else {
				playerdx = 0;
				playerdy = 1;
				mapdx = 0;
				mapdy = 0;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			}
			break;

		default:
			System.out.println("entro a def");
			break;
		}
		
		if(!trainer1) {
			if(OWFrame.Route1.playerX >160 && OWFrame.Route1.playerX < 170) {
				if(OWFrame.Route1.mapY > 210 && OWFrame.Route1.mapY < 240) {
					super.trainerBattle(true);
					trainer1 = true;
				}
			}
		}
		if(!trainer2) {
			if(OWFrame.Route1.playerX >440 && OWFrame.Route1.playerX < 460) {
				if(OWFrame.Route1.mapY > 670 && OWFrame.Route1.mapY < 680) {
					super.trainerBattle(true);
					trainer2 = true;
				}
			}
		}
		
		if(trainer1 && trainer2) {
			if(OWFrame.Route1.playerX >310 && OWFrame.Route1.playerX < 360) {
				if(OWFrame.Route1.playerY > 740 && OWFrame.Route1.playerY < 750) {
					OWFrame.Route1.setVisible(false);
					OWFrame.Route1.setFocusable(false);
					OWFrame.Route1.clip.stop();
					OWFrame.Route1.mapdx = 0;
					OWFrame.Route1.playerdx = 0;
					OWFrame.Route1.mapdy = 0;
					OWFrame.Route1.playerdy = 0;
					OWFrame.ViridianCity.setVisible(true);
					OWFrame.ViridianCity.setFocusable(true);
					OWFrame.ViridianCity.clip.start();
					OWFrame.ViridianCity.mapdx = 0;
					OWFrame.ViridianCity.playerdx = 0;
					OWFrame.ViridianCity.mapdy = 0;
					OWFrame.ViridianCity.playerdy = 0;
					OWFrame.ViridianCity.mapY = -20;
					OWFrame.ViridianCity.playerY = 790;
					OWFrame.repaint();
				}
			}
		}
		
		if(OWFrame.Route1.playerX >315 && OWFrame.Route1.playerX < 360) {
			if(OWFrame.Route1.playerY > 1140) {
				OWFrame.Route1.setVisible(false);
				OWFrame.Route1.setFocusable(false);
				OWFrame.Route1.clip.stop();
				OWFrame.Route1.mapdx = 0;
				OWFrame.Route1.playerdx = 0;
				OWFrame.Route1.mapdy = 0;
				OWFrame.Route1.playerdy = 0;
				OWFrame.PalletTown.setVisible(true);
				OWFrame.PalletTown.setFocusable(true);
				OWFrame.PalletTown.clip.start();
				OWFrame.PalletTown.playerX = 280;
				OWFrame.PalletTown.playerY = 20;
				OWFrame.PalletTown.mapdx = 0;
				OWFrame.PalletTown.playerdx = 0;
				OWFrame.PalletTown.mapdy = 0;
				OWFrame.PalletTown.playerdy = 0;
				OWFrame.repaint();
			}
		}
	}
	
}

