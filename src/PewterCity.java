import java.awt.Color;
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

public class PewterCity extends OWPanels{

	private static final long serialVersionUID = 4557056139083021789L;

	public PewterCity(OWFrame OWFrame) {
		super();
		this.OWFrame = OWFrame;
		this.background = new ImageIcon("Overworld/PewterCity.png").getImage();
		this.setLayout(null);
		this.add(characterMovement);
		super.tm = new Timer(15, this);
		this.tm.start();
		this.mapX = -150;
		this.mapY = -400;
		this.playerX = 570;
		this.playerY = 840;
		this.setBackground(Color.BLACK);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		try {
			File soundFile = new File("sound/ViridianCity.wav");
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
			mapdx = 1;
			mapdy = 0;
			System.out.println("Map X: " + mapX + " Map Y: " + mapY);
			break;

		case KeyEvent.VK_RIGHT:
			mapdx = -1;
			mapdy = 0;
			System.out.println("Map X: " + mapX + " Map Y: " + mapY);
			break;

		case KeyEvent.VK_UP:
			mapdx = 0;
			mapdy = 1;
			System.out.println("Map X: " + mapX + " Map Y: " + mapY);
			break;

		case KeyEvent.VK_DOWN:
			mapdx = 0;
			mapdy = -1;
			System.out.println("Map X: " + mapX + " Map Y: " + mapY);
			break;

		default:
			System.out.println("entro a def");
			break;
		}
		if(!trainer1) {
			if(OWFrame.PewterCity.mapX >= -400 && OWFrame.PewterCity.mapX <= -380) {
				if(OWFrame.PewterCity.mapY > -190 && OWFrame.PewterCity.mapY < -120) {
					super.trainerBattle(true);
					trainer1 = true;
				}
			}
		}
		if(!trainer2) {
			if(OWFrame.PewterCity.mapX >= -680 && OWFrame.PewterCity.mapX <= -660) {
				if(OWFrame.PewterCity.mapY > 610 && OWFrame.PewterCity.mapY < 680) {
					super.trainerBattle(true);
					trainer2 = true;
				}
			}
		}
		if(!trainer3) {
			if(OWFrame.PewterCity.mapX >= 370 && OWFrame.PewterCity.mapX <= 390) {
				if(OWFrame.PewterCity.mapY > 630 && OWFrame.PewterCity.mapY < 700) {
					super.trainerBattle(true);
					trainer3 = true;
				}
			}
		}
		
		if(trainer1 && trainer2 && trainer3) {
			if(OWFrame.PewterCity.mapX >-50 && OWFrame.PewterCity.mapX < -35) {
				if(OWFrame.PewterCity.mapY > 165 && OWFrame.PewterCity.mapY < 175) {
					OWFrame.PewterCity.setVisible(false);
					OWFrame.PewterCity.setFocusable(false);
					OWFrame.PewterCity.clip.stop();
					OWFrame.PewterCity.mapdx = 0;
					OWFrame.PewterCity.playerdx = 0;
					OWFrame.PewterCity.mapdy = 0;
					OWFrame.PewterCity.playerdy = 0;
					OWFrame.PewterGym.setFocusable(true);
					OWFrame.PewterGym.setVisible(true);
					OWFrame.PewterGym.mapX = 0;
					OWFrame.PewterGym.mapY = 0;
					OWFrame.PewterGym.playerX = 235;
					OWFrame.PewterGym.playerY = 446;
					OWFrame.PewterGym.clip.start();
					OWFrame.repaint();
				}
			}
		}
		
		if(OWFrame.PewterCity.mapX >-85 && OWFrame.PewterCity.mapX < 125) {
			if(OWFrame.PewterCity.playerY > 2845) {
				OWFrame.PewterCity.setVisible(false);
				OWFrame.PewterCity.setFocusable(false);
				OWFrame.PewterCity.clip.stop();
				OWFrame.PewterCity.mapdx = 0;
				OWFrame.PewterCity.playerdx = 0;
				OWFrame.PewterCity.mapdy = 0;
				OWFrame.PewterCity.playerdy = 0;
				OWFrame.Cuartito.setFocusable(true);
				OWFrame.Cuartito.setVisible(true);
				OWFrame.Cuartito.playerX = 255;
				OWFrame.Cuartito.playerY = 21;
				OWFrame.Cuartito.clip.start();
				OWFrame.repaint();
			}
		}
	}
}
