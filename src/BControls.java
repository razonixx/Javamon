import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BControls extends JPanel{

	private static final long serialVersionUID = 1L;
	private Image textBoxChica;
	public String playerAction = "";
	private BFrame BFrame;
	protected BSelectMove BSelectMove;
	private JButton bFight,
					bPkmn,
					bItem,
					bRun;
	
	public BControls(BFrame BFrame) {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(530, 132));
		this.textBoxChica = new ImageIcon("GUI/textBoxChica2.png").getImage();	
		this.BFrame = BFrame;
		
		bFight = new JButton();
		bFight.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				playerAction = "FIGHT";
				BFrame.BText.isPlayerTurn = true;
				BFrame.BControls.setVisible(false);	
				BFrame.BSelectMove.setVisible(true);
			}
		});
		this.bFight.setBounds(25, 30, 145, 35);
		this.bFight.setBackground(Color.WHITE);
		this.bFight.setBorderPainted(false);
		this.bFight.setOpaque(false);
		this.bFight.setContentAreaFilled(false);
		this.bFight.setBorderPainted(false);
		this.add(bFight);
		
		bPkmn = new JButton();
		bPkmn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				playerAction = "PKMN";
				BFrame.BText.isPlayerTurn = true;
				BFrame.BChoosePokemon.setVisible(true);
				BFrame.BControls.setVisible(false);
				System.out.println("Le picaste a pokemon");
				BFrame.BPanel.repaint();
			}
		});	
		this.bPkmn.setBounds(190, 30, 125, 35);
		this.bPkmn.setBorderPainted(false);
		this.bPkmn.setOpaque(false);
		this.bPkmn.setContentAreaFilled(false);
		this.bPkmn.setBorderPainted(false);
		this.add(bPkmn);	
		
		bItem = new JButton();
		bItem.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				playerAction = "ITEM";
				BFrame.BText.isPlayerTurn = true;
				System.out.println("Le picaste a Item");
			}
		});	
		this.bItem.setBounds(35, 75, 125, 35);
		this.bItem.setBorderPainted(false);
		this.bItem.setOpaque(false);
		this.bItem.setContentAreaFilled(false);
		this.bItem.setBorderPainted(false);
		this.add(bItem);
		
		bRun = new JButton();
		bRun.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				playerAction = "RUN";
				BFrame.BText.isPlayerTurn = true;
				System.out.println("Le picaste a run");
				BFrame.BControls.setVisible(false);		
				
				Thread wait11 = new Thread(new Runnable() {
					public void run() {
						try {
								BFrame.BText.isPlayerTurn = false;
								System.out.println("entro al thread");
								Thread.sleep(1000);
								playerAction = "";
								BFrame.BText.repaint();
								BFrame.BControls.setVisible(true);							
						} catch (InterruptedException e) {
						}
					}
				});
				wait11.start();
			}
		});
		this.bRun.setBounds(190, 75, 125, 35);
		this.bRun.setOpaque(false);
		this.bRun.setContentAreaFilled(false);
        this.bRun.setBorderPainted(false);
		this.add(bRun);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 33)); 
		g.drawImage(this.textBoxChica, 10, 0, this);	
		g.drawString("FIGHT", 35, 60);
		g.drawString("PKMN", 200, 60);
		g.drawString("ITEM", 40, 100);
		g.drawString("RUN", 200, 100);
		
	}

}
