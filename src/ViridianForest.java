import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ViridianForest extends OWPanels{

	public ViridianForest(OWFrame OWFrame) {
		this.OWFrame = OWFrame;
		this.background = new ImageIcon("Overworld/ViridianForest.png").getImage();
		this.setLayout(null);
		this.add(characterMovement);
		super.tm = new Timer(5, this);
		this.tm.start();
		this.playerX = 1630;
		this.playerY = 2800;
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
		//super.wildEncounter();
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
		//Bug Catcher
		if(!trainer1) {
			if(OWFrame.ViridianForest.mapX >= 600 && OWFrame.ViridianForest.mapX <= 630) {
				if(OWFrame.ViridianForest.mapY > 700 && OWFrame.ViridianForest.mapY < 750) {
					super.trainerBattle(true);
					trainer1 = true;
				}
			}
		}
		//Headband
		if(!trainer2) {
			if(OWFrame.ViridianForest.mapX >= -630 && OWFrame.ViridianForest.mapX <= -600) {
				if(OWFrame.ViridianForest.mapY > 305 && OWFrame.ViridianForest.mapY < 325) {
					super.trainerBattle(true);
					trainer2 = true;
				}
			}
		}
		//Lentes
		if(!trainer3) {
			if(OWFrame.ViridianForest.mapX >= -790 && OWFrame.ViridianForest.mapX <= -750) {
				if(OWFrame.ViridianForest.mapY > 1580 && OWFrame.ViridianForest.mapY < 1635) {
					super.trainerBattle(true);
					trainer3 = true;
				}
			}
		}
		//Mohawk
		if(!trainer4) {
			if(OWFrame.ViridianForest.mapX >= -600 && OWFrame.ViridianForest.mapX <= -570) {
				if(OWFrame.ViridianForest.mapY > 2200 && OWFrame.ViridianForest.mapY < 2250) {
					super.trainerBattle(true);
					trainer4 = true;
				}
			}
		}
		//Gordo
		if(!trainer5) {
			if(OWFrame.ViridianForest.mapX >= -940 && OWFrame.ViridianForest.mapX <= -900) {
				if(OWFrame.ViridianForest.mapY > 2370 && OWFrame.ViridianForest.mapY < 2400) {
					super.trainerBattle(true);
					trainer5 = true;
				}
			}
		}
		//Viejito
		if(!trainer6) {
			if(OWFrame.ViridianForest.mapX >= 330 && OWFrame.ViridianForest.mapX <= 360) {
				if(OWFrame.ViridianForest.mapY > 2250 && OWFrame.ViridianForest.mapY < 2380) {
					super.trainerBattle(true);
					trainer6 = true;
				}
			}
		}
		//Ultimo
		if(!trainer7) {
			if(OWFrame.ViridianForest.mapX >= 730 && OWFrame.ViridianForest.mapX <= 760) {
				if(OWFrame.ViridianForest.mapY > 1320 && OWFrame.ViridianForest.mapY < 1370) {
					super.trainerBattle(true);
					trainer7 = true;
				}
			}
		}

		if(trainer1 && trainer2 && trainer3 && trainer4 && trainer5 && trainer6 && trainer7) {
			if(OWFrame.ViridianForest.mapX >880 && OWFrame.ViridianForest.mapX < 980) {
				if(OWFrame.ViridianForest.mapY > 2500) {
					OWFrame.ViridianForest.setVisible(false);
					OWFrame.ViridianForest.setFocusable(false);
					OWFrame.ViridianForest.clip.stop();
					OWFrame.ViridianForest.mapdx = 0;
					OWFrame.ViridianForest.playerdx = 0;
					OWFrame.ViridianForest.mapdy = 0;
					OWFrame.ViridianForest.playerdy = 0;
					OWFrame.Cuartito2.setFocusable(true);
					OWFrame.Cuartito2.setVisible(true);
					OWFrame.Cuartito2.mapX = 0;
					OWFrame.Cuartito2.mapY = 0;
					OWFrame.Cuartito2.playerX = 235;
					OWFrame.Cuartito2.playerY = 446;
					OWFrame.Cuartito2.clip.start();
					OWFrame.repaint();
				}
			}
		}

		if(OWFrame.ViridianForest.mapX >-85 && OWFrame.ViridianForest.mapX < 125) {
			if(OWFrame.ViridianForest.playerY > 2845) {
				OWFrame.ViridianForest.setVisible(false);
				OWFrame.ViridianForest.setFocusable(false);
				OWFrame.ViridianForest.clip.stop();
				OWFrame.ViridianForest.mapdx = 0;
				OWFrame.ViridianForest.playerdx = 0;
				OWFrame.ViridianForest.mapdy = 0;
				OWFrame.ViridianForest.playerdy = 0;
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