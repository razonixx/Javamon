import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class PalletTown extends OWPanels{

	private static final long serialVersionUID = 502122373077628000L;

	public PalletTown(OWFrame OWFrame) {
		this.OWFrame = OWFrame;
		this.background = new ImageIcon("Overworld/PalletTown.png").getImage();
		this.setBackground(Color.BLACK);
		this.playerX = 200;
		this.playerY = 200;
		this.setLayout(null);
		this.add(characterMovement);
		super.tm = new Timer(1, this);
		this.tm.start();
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		try {
			File soundFile = new File("sound/PalletTown.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			this.clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException  | LineUnavailableException e) {
		} 
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.characterMovement.setBounds(playerX, playerY, 30, 30);
		g.drawImage(this.background, mapX, mapY, this);		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		characterMovement.timer.start();
		switch (k) {
		case KeyEvent.VK_LEFT:
				playerdx = -1;
				playerdy = 0;
				mapdx = 0;
				mapdy = 0;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			break;

		case KeyEvent.VK_RIGHT:
				playerdx = 1;
				playerdy = 0;
				mapdx = 0;
				mapdy = 0;
				System.out.println("Player X: " + playerX + " Player Y: " + playerY);
			break;

		case KeyEvent.VK_UP:
			if(OWFrame.PalletTown.mapY <= 0) {
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
			if(OWFrame.PalletTown.mapY >= -35) {
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
			if(OWFrame.PalletTown.playerX >140 && OWFrame.PalletTown.playerX < 173) {
				if(OWFrame.PalletTown.playerY > 180 && OWFrame.PalletTown.playerY < 230) {
					super.trainerBattle(true);
					trainer1 = true;
				}
			}
		}

		if(!trainer2) {
			if(OWFrame.PalletTown.playerX >= 250 && OWFrame.PalletTown.playerX < 260) {
				if(OWFrame.PalletTown.playerY > 400 && OWFrame.PalletTown.playerY < 420) {
					super.trainerBattle(true);
					trainer2 = true;
				}
			}
		}

		if(trainer1 && trainer2) {
			if(OWFrame.PalletTown.playerX >260 && OWFrame.PalletTown.playerX < 300) {
				if(OWFrame.PalletTown.playerY > 6 && OWFrame.PalletTown.playerY < 17) {
					OWFrame.PalletTown.setVisible(false);
					OWFrame.PalletTown.setFocusable(false);
					OWFrame.Route1.setFocusable(true);
					OWFrame.PalletTown.clip.stop();
					OWFrame.Route1.setVisible(true);
					OWFrame.Route1.playerY = 1110;
					OWFrame.Route1.clip.start();
					OWFrame.repaint();
				}
			}
		}
	}

}