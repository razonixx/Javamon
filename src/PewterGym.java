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

public class PewterGym extends OWPanels{
	
	private static final long serialVersionUID = -5664758497268049285L;
	protected boolean music = false;

	public PewterGym(OWFrame OWFrame) {
		super();
		this.OWFrame = OWFrame;
		this.background = new ImageIcon("Overworld/PewterGym.png").getImage();
		this.setLayout(null);
		this.add(characterMovement);
		super.tm = new Timer(15, this);
		this.tm.start();
		this.playerX = 250;
		this.playerY = 450;
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		try {
			File soundFile = new File("sound/PewterGym.wav");
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
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(trainer1 && trainer2 && trainer3 && trainer4 && !this.music) {
			System.out.println("Ganaste!");
			this.music = true;
			this.clip.stop();
			try {
				File soundFile = new File("sound/VictoryTheme.wav");
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
				this.clip = AudioSystem.getClip();
				clip.open(audioIn);
				clip.start();
			} catch (UnsupportedAudioFileException | IOException  | LineUnavailableException e1) {
			} 
		}
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
		if(!trainer1) {
			if(OWFrame.PewterGym.playerX >= 260 && OWFrame.PewterGym.playerX <= 300) {
				if(OWFrame.PewterGym.playerY > 330 && OWFrame.PewterGym.playerY < 340) {
					super.trainerBattle(false);
					trainer1 = true;
				}
			}
		}
		if(!trainer2) {
			if(OWFrame.PewterGym.playerX >= 55 && OWFrame.PewterGym.playerX <= 80) {
				if(OWFrame.PewterGym.playerY > 250 && OWFrame.PewterGym.playerY < 300) {
					super.trainerBattle(false);
					trainer2 = true;
				}
			}
		}
		if(!trainer3) {
			if(OWFrame.PewterGym.playerX >= 425 && OWFrame.PewterGym.playerX <= 450) {
				if(OWFrame.PewterGym.playerY > 250 && OWFrame.PewterGym.playerY < 290) {
					super.trainerBattle(false);
					trainer3 = true;
				}
			}
		}
		
		if(trainer1 && trainer2 && trainer3 && !trainer4) {
			if(OWFrame.PewterGym.playerX >= 240 && OWFrame.PewterGym.playerX <= 260) {
				if(OWFrame.PewterGym.playerY > 120 && OWFrame.PewterGym.playerY < 130) {
					super.trainerBattle(false);
					trainer4 = true;
				}
			}
		}
		
		if(OWFrame.PewterGym.playerX > 210 && OWFrame.PewterGym.playerX < 290) {
			if(OWFrame.PewterGym.playerY > 470) {
				OWFrame.PewterGym.setVisible(false);
				OWFrame.PewterGym.setFocusable(false);
				OWFrame.PewterGym.clip.stop();
				OWFrame.PewterGym.mapdx = 0;
				OWFrame.PewterGym.playerdx = 0;
				OWFrame.PewterGym.mapdy = 0;
				OWFrame.PewterGym.playerdy = 0;
				OWFrame.PewterCity.setFocusable(true);
				OWFrame.PewterCity.setVisible(true);
				OWFrame.PewterCity.mapX = -40;
				OWFrame.PewterCity.mapY = 175;
				OWFrame.PewterCity.clip.start();
				OWFrame.repaint();
			}
		}
	}

}
