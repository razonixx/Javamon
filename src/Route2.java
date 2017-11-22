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

public class Route2 extends OWPanels{


	protected boolean fromViridian = true;	
	protected boolean fromCuartito2 = false;

	public Route2(OWFrame OWFrame) {
		this.OWFrame = OWFrame;
		this.background = new ImageIcon("Overworld/Route2.png").getImage();
		super.tm = new Timer(15, this);
		this.tm.start();
		this.playerX = 240;
		this.playerY = 1935;
		this.setLayout(null);
		this.add(characterMovement);
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
		if(fromViridian) {
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
		}

		if(fromCuartito2 ) {
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
				playerdx = 0;
				playerdy = -1;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
				break;

			case KeyEvent.VK_DOWN:
				playerdx = 0;
				playerdy = 1;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
				break;

			default:
				System.out.println("entro a def");
				break;
			}		
		}

		if(!trainer1) {
			if(OWFrame.Route2.playerX >= 265 && OWFrame.Route2.playerX < 275) {
				if(OWFrame.Route2.mapY > 640 && OWFrame.Route2.mapY < 680) {
					this.trainerBattle(true);
					trainer1 = true;
				}
			}
		}
		try {
			if(!this.BFrame.isVisible()) {
				this.clip.start();
			}
		}catch (Exception ex) {
		}

		if(trainer1) {
			if(OWFrame.Route2.playerX >80 && OWFrame.Route2.playerX < 90) {
				if(OWFrame.Route2.mapY > 735) {
					OWFrame.Route2.setVisible(false);
					OWFrame.Route2.setFocusable(false);
					OWFrame.Route2.clip.stop();
					OWFrame.Route2.mapdx = 0;
					OWFrame.Route2.playerdx = 0;
					OWFrame.Route2.mapdy = 0;
					OWFrame.Route2.playerdy = 0;
					OWFrame.Cuartito.setVisible(true);
					OWFrame.Cuartito.setFocusable(true);
					OWFrame.Cuartito.clip.start();
					OWFrame.Cuartito.playerX = 235;
					OWFrame.Cuartito.playerY = 446;
					OWFrame.Cuartito.mapdx = 0;
					OWFrame.Cuartito.playerdx = 0;
					OWFrame.Cuartito.mapdy = 0;
					OWFrame.Cuartito.playerdy = 0;
					OWFrame.repaint();
				}
			}
		}
		if(fromViridian) {
			if(OWFrame.Route2.playerX >180 && OWFrame.Route2.playerX < 245) {
				if(OWFrame.Route2.mapY < 0) {
					OWFrame.Route2.setVisible(false);
					OWFrame.Route2.setFocusable(false);
					OWFrame.ViridianCity.setFocusable(true);
					OWFrame.Route2.mapdx = 0;
					OWFrame.Route2.playerdx = 0;
					OWFrame.Route2.mapdy = 0;
					OWFrame.Route2.playerdy = 0;
					OWFrame.Route2.clip.stop();
					OWFrame.ViridianCity.setVisible(true);
					OWFrame.ViridianCity.mapX = 50;
					OWFrame.ViridianCity.mapY = 417;
					OWFrame.ViridianCity.playerX =520;
					OWFrame.ViridianCity.playerY = 440;
					OWFrame.ViridianCity.mapdx = 0;
					OWFrame.ViridianCity.playerdx = 0;
					OWFrame.ViridianCity.mapdy = 0;
					OWFrame.ViridianCity.playerdy = 0;
					OWFrame.ViridianCity.fromRoute2 = true;
					OWFrame.ViridianCity.clip.start();
					OWFrame.repaint();
				}
			}
		}
		if(fromCuartito2) {
			if(OWFrame.Route2.playerX >210 && OWFrame.Route2.playerX < 240) {
				if(OWFrame.Route2.playerY < 1510) {
					OWFrame.Route2.setVisible(false);
					OWFrame.Route2.setFocusable(false);
					OWFrame.Route2.mapdx = 0;
					OWFrame.Route2.playerdx = 0;
					OWFrame.Route2.mapdy = 0;
					OWFrame.Route2.playerdy = 0;
					OWFrame.Route2.clip.stop();
					OWFrame.PewterCity.setFocusable(true);
					OWFrame.PewterCity.setVisible(true);
					OWFrame.PewterCity.mapdx = 0;
					OWFrame.PewterCity.playerdx = 0;
					OWFrame.PewterCity.mapdy = 0;
					OWFrame.PewterCity.playerdy = 0;
					OWFrame.PewterCity.clip.start();
					OWFrame.repaint();
				}
			}
		}
	}

}
