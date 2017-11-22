import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BChoosePokemon extends JPanel{
	protected BFrame BFrame;
	private Image textBoxChoose;
	protected JButton pokemon1, 
	pokemon2,
	pokemon3,
	pokemon4,
	pokemon5,
	pokemon6;
	protected boolean pokemonSwitched;


	public BChoosePokemon(BFrame BFrame) {
		super();
		this.setLayout(null);
		this.BFrame = BFrame;
		this.textBoxChoose = new ImageIcon("GUI/textBoxChoose.png").getImage();

		pokemon1 = new JButton(BFrame.BPanel.playerTeam[0].getName());
		pokemon1.addActionListener(new ActionListener() {		

			@Override
			public void actionPerformed(ActionEvent e) {
				BFrame.BPanel.monActive = 0;
				BFrame.BChoosePokemon.setVisible(false);
				BFrame.BControls.setVisible(true);
				if(BFrame.BSelectMove.isPlayerDead == true) {
					BFrame.BPanel.playerGoDown = 0;
					BFrame.BSelectMove.isPlayerDead = false;
					BFrame.BSelectMove.moveIsSelected = false;
					BFrame.BControls.setVisible(true);
				}
			}
		});		
		this.pokemon1.setBounds(105, 100, 200, 35);
		this.pokemon1.setFont(new Font("TimesRoman", Font.PLAIN, 23));
		this.pokemon1.setBackground(Color.WHITE);
		this.pokemon1.setBorderPainted(false);
		this.add(pokemon1);

		pokemon2 = new JButton(BFrame.BPanel.playerTeam[1].getName());
		pokemon2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				BFrame.BPanel.monActive = 1;
				BFrame.BChoosePokemon.setVisible(false);
				BFrame.BControls.setVisible(true);
				if(BFrame.BSelectMove.isPlayerDead == true) {
					BFrame.BPanel.playerGoDown = 0;
					BFrame.BSelectMove.isPlayerDead = false;
					BFrame.BSelectMove.moveIsSelected = false;
					BFrame.BControls.setVisible(true);
				}
			}
		});		
		this.pokemon2.setBounds(105, 165, 150, 35);
		this.pokemon2.setFont(new Font("TimesRoman", Font.PLAIN, 23));
		this.pokemon2.setBackground(Color.WHITE);
		this.pokemon2.setBorderPainted(false);
		this.add(pokemon2);

		pokemon3 = new JButton(BFrame.BPanel.playerTeam[2].getName());
		pokemon3.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				BFrame.BPanel.monActive = 2;
				BFrame.BChoosePokemon.setVisible(false);
				BFrame.BControls.setVisible(true);
				if(BFrame.BSelectMove.isPlayerDead == true) {
					BFrame.BPanel.playerGoDown = 0;
					BFrame.BSelectMove.isPlayerDead = false;
					BFrame.BSelectMove.moveIsSelected = false;
					BFrame.BControls.setVisible(true);
				}
			}
		});		
		this.pokemon3.setBounds(105, 225, 200, 35);
		this.pokemon3.setFont(new Font("TimesRoman", Font.PLAIN, 23));
		this.pokemon3.setBackground(Color.WHITE);
		this.pokemon3.setBorderPainted(false);
		this.add(pokemon3);
		
		pokemon4 = new JButton(BFrame.BPanel.playerTeam[3].getName());
		pokemon4.addActionListener(new ActionListener() {		

			@Override
			public void actionPerformed(ActionEvent e) {
				BFrame.BPanel.monActive = 3;
				BFrame.BChoosePokemon.setVisible(false);
				BFrame.BControls.setVisible(true);
				if(BFrame.BSelectMove.isPlayerDead == true) {
					BFrame.BPanel.playerGoDown = 0;
					BFrame.BSelectMove.isPlayerDead = false;
					BFrame.BSelectMove.moveIsSelected = false;
					BFrame.BControls.setVisible(true);
				}
			}
		});		
		this.pokemon4.setBounds(105, 285, 200, 35);
		this.pokemon4.setFont(new Font("TimesRoman", Font.PLAIN, 23));
		this.pokemon4.setBackground(Color.WHITE);
		this.pokemon4.setBorderPainted(false);
		this.add(pokemon4);
		
		pokemon5 = new JButton(BFrame.BPanel.playerTeam[4].getName());
		pokemon5.addActionListener(new ActionListener() {		

			@Override
			public void actionPerformed(ActionEvent e) {
				BFrame.BPanel.monActive = 4;
				BFrame.BChoosePokemon.setVisible(false);
				BFrame.BControls.setVisible(true);
				if(BFrame.BSelectMove.isPlayerDead == true) {
					BFrame.BPanel.playerGoDown = 0;
					BFrame.BSelectMove.isPlayerDead = false;
					BFrame.BSelectMove.moveIsSelected = false;
					BFrame.BControls.setVisible(true);
				}
			}
		});		
		this.pokemon5.setBounds(105, 345, 200, 35);
		this.pokemon5.setFont(new Font("TimesRoman", Font.PLAIN, 23));
		this.pokemon5.setBackground(Color.WHITE);
		this.pokemon5.setBorderPainted(false);
		this.add(pokemon5);
		
		pokemon6 = new JButton(BFrame.BPanel.playerTeam[5].getName());
		pokemon6.addActionListener(new ActionListener() {		

			@Override
			public void actionPerformed(ActionEvent e) {
				BFrame.BPanel.monActive = 5;
				BFrame.BChoosePokemon.setVisible(false);
				BFrame.BControls.setVisible(true);
				if(BFrame.BSelectMove.isPlayerDead == true) {
					BFrame.BPanel.playerGoDown = 0;
					BFrame.BSelectMove.isPlayerDead = false;
					BFrame.BSelectMove.moveIsSelected = false;
					BFrame.BControls.setVisible(true);
				}
			}
		});		
		this.pokemon6.setBounds(105, 410, 200, 35);
		this.pokemon6.setFont(new Font("TimesRoman", Font.PLAIN, 23));
		this.pokemon6.setBackground(Color.WHITE);
		this.pokemon6.setBorderPainted(false);
		this.add(pokemon6);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(textBoxChoose, 0, 0, this);
		g.drawImage(new ImageIcon("menuSprites/AERODACTYL.png").getImage(), 42, 90, this);
		g.drawImage(new ImageIcon("menuSprites/PIKACHU.png").getImage(), 42, 155, this);
		g.drawImage(new ImageIcon("menuSprites/TYRANITAR.png").getImage(), 42, 215, this);
		g.drawImage(new ImageIcon("menuSprites/TYRANITAR.png").getImage(), 42, 275, this);
		g.drawImage(new ImageIcon("menuSprites/AERODACTYL.png").getImage(), 42, 335, this);
		g.drawImage(new ImageIcon("menuSprites/TYRANITAR.png").getImage(), 42, 395, this);
	}

}
