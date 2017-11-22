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


public class ViridianCity extends OWPanels implements KeyListener, ActionListener{
	
	protected boolean fromRoute2 = false;
	protected boolean staticCamera = false;


	public ViridianCity(OWFrame OWFrame) {
		this.OWFrame = OWFrame;
		this.background = new ImageIcon("Overworld/ViridianCity.png").getImage();
		super.tm = new Timer(15, this);
		tm.start();
		this.playerX = 548;
		this.playerY = 790;
		this.mapY = -20;
		this.setLayout(null);
		this.add(characterMovement);
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
		g.drawImage(this.background, mapX, mapY, this);
		this.characterMovement.setBounds(playerX, playerY, 30, 30);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		characterMovement.timer.start();
		
		switch (k) {
		case KeyEvent.VK_LEFT:
			if(!staticCamera && OWFrame.ViridianCity.mapX <= 250) {
				mapdx = 1;
				mapdy = 0;	
				System.out.println("Map X: " + mapX + " Map Y: " + mapY);
			}else {
				playerdx = -1;
				playerdy = 0;
				mapdx = 0;
				mapdy = 0;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);	
				staticCamera = true;
			}
			if(staticCamera  && OWFrame.ViridianCity.playerX >= 520) {
				playerdx = -1;
				playerdy = 0;	
				mapdx = 0;
				mapdy = 0;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			}else {
				if(OWFrame.ViridianCity.mapX <= 250) {
					System.out.println("static cam false");
					staticCamera = false;
					playerdx = 0;
					playerdy = 0;
				}
			}	
			break;

		case KeyEvent.VK_RIGHT:
			if(!staticCamera && OWFrame.ViridianCity.mapX >= -230) {
				mapdx = -1;
				mapdy = 0;		
				System.out.println("Map X: " + mapX + " Map Y: " + mapY);
			}else {
				System.out.println("static cam true");
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
				staticCamera = true;
				playerdx = 1;
				playerdy = 0;
				mapdx = 0;
				mapdy = 0;
			}
			if(staticCamera  && OWFrame.ViridianCity.playerX <= 520) {
				playerdx = 1;
				playerdy = 0;	
				mapdx = 0;
				mapdy = 0;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			}else {
				if(OWFrame.ViridianCity.mapX >= -230) {
					System.out.println("static cam false");
					staticCamera = false;
					playerdx = 0;
					playerdy = 0;
				}
			}			
			break;

		case KeyEvent.VK_UP:
			if(OWFrame.ViridianCity.mapY <= 410) {
				mapdx = 0;
				mapdy = 1;
				System.out.println("Map X: " + mapX + " Map Y: " + mapY);
			}else {
				playerdx = 0;
				playerdy = -1;
				mapdx = 0;
				mapdy = 0;
				staticCamera = true;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			}
			break;

		case KeyEvent.VK_DOWN:
			if(!staticCamera && OWFrame.ViridianCity.mapY >= -25) {
				mapdx = 0;
				mapdy = -1;		
				System.out.println("Map X: " + mapX + " Map Y: " + mapY);
			}else {
				staticCamera = true;
				playerdx = 0;
				playerdy = 0;
			}
			if(staticCamera  && OWFrame.ViridianCity.playerY >= 650) {
				playerdx = 0;
				playerdy = 1;	
				mapdx = 0;
				mapdy = 0;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			}else {
				staticCamera = false;
				playerdx = 0;
				playerdy = 0;
			}			
			break;

		default:
			System.out.println("entro a def");
			break;
		}

		//Sombrero
		if(!trainer1) {
			if(OWFrame.ViridianCity.playerX >350 && OWFrame.ViridianCity.playerX < 400) {
				if(OWFrame.ViridianCity.playerY > 800 && OWFrame.ViridianCity.playerY < 820) {
					super.trainerBattle(true);
					trainer1 = true;
				}
			}
		}
		//Payaso
		if(!trainer3) {
			if(OWFrame.ViridianCity.mapX >= 15 && OWFrame.ViridianCity.mapX < 55) {
				if(OWFrame.ViridianCity.mapY > 160 && OWFrame.ViridianCity.mapY < 180) {
					super.trainerBattle(true);
					trainer3 = true;
				}
			}
		}
		//Mujer
		if(!trainer4) {
			if(OWFrame.ViridianCity.playerX >= 520 && OWFrame.ViridianCity.playerX < 560) {
				if(OWFrame.ViridianCity.playerY > 510 && OWFrame.ViridianCity.playerY < 530) {
					super.trainerBattle(true);
					trainer4 = true;
				}
			}
		}
		try {
			if(!this.BFrame.isVisible()) {
				this.clip.start();
			}
		}catch (Exception ex) {
		}
		
		if(trainer1 && trainer3 && trainer4) {
			if(OWFrame.ViridianCity.mapX >0 && OWFrame.ViridianCity.mapX < 100) {
				if(OWFrame.ViridianCity.playerY < 450) {
					OWFrame.ViridianCity.setVisible(false);
					OWFrame.ViridianCity.setFocusable(false);
					OWFrame.Route2.setFocusable(true);
					OWFrame.ViridianCity.clip.stop();
					OWFrame.Route2.setVisible(true);
					OWFrame.Route2.clip.start();
					OWFrame.Route2.fromViridian = true;
					OWFrame.repaint();
				}
			}
		}
		
		if(OWFrame.ViridianCity.mapX >-15 && OWFrame.ViridianCity.mapX < 25) {
			if(OWFrame.ViridianCity.mapY > -25 && OWFrame.ViridianCity.mapY < -20) {
				OWFrame.ViridianCity.setVisible(false);
				OWFrame.ViridianCity.setFocusable(false);
				OWFrame.Route1.setFocusable(true);
				OWFrame.ViridianCity.clip.stop();
				OWFrame.Route1.setVisible(true);
				OWFrame.Route1.mapX = 0;
				OWFrame.Route1.mapY = 740;
				OWFrame.Route1.playerX = 350;
				OWFrame.Route1.playerY = 760;
				OWFrame.Route1.clip.start();
				OWFrame.repaint();
			}
		}
		
		if(fromRoute2 ) {
			if(OWFrame.ViridianCity.playerX >510 && OWFrame.ViridianCity.playerX < 530) {
				if(OWFrame.ViridianCity.playerY > 825) {
					OWFrame.ViridianCity.setVisible(false);
					OWFrame.ViridianCity.setFocusable(false);
					OWFrame.Route1.setFocusable(true);
					OWFrame.ViridianCity.clip.stop();
					OWFrame.Route1.setVisible(true);
					OWFrame.Route1.mapX = 0;
					OWFrame.Route1.mapY = 740;
					OWFrame.Route1.playerX = 350;
					OWFrame.Route1.playerY = 760;
					OWFrame.Route1.clip.start();
					OWFrame.repaint();
				}
			}
		}
	}
}
