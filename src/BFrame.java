import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class BFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	protected Clip clip;
	protected BPanel BPanel = new BPanel(this);
	protected BControls BControls = new BControls(this);
	protected BText BText = new BText(this);
	protected BSelectMove BSelectMove = new BSelectMove(this, this.BPanel);
	protected moveSummary moveSummary = new moveSummary(this);
	protected BChoosePokemon BChoosePokemon = new BChoosePokemon(this);
	protected EnemyAI EnemyAI = new EnemyAI(this);
	protected OWPanels OWPanels;

	
	public BFrame(OWPanels panel) {
		super("Pokemon");
		this.setLayout(null);
		this.setSize(530, 520);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("GUI/Pokeball.png").getImage());
		this.OWPanels = panel;
		this.add(BChoosePokemon);
		this.add(this.moveSummary);
		this.add(this.BPanel);
		this.add(this.BSelectMove);
		this.add(this.BControls);
		this.add(this.BText);

		this.BChoosePokemon.setVisible(false);
		this.BSelectMove.setVisible(false);
		this.moveSummary.setVisible(false);
		
		this.BChoosePokemon.setBounds(-5, -40, 530, 920);
		this.BPanel.setBounds(0,0,530, 340);
		this.BControls.setBounds(168, 335, 340, 132);
		this.BText.setBounds(-13, 335, 530, 132);
		this.BSelectMove.setBounds(-13, 335, 530, 132);
		this.moveSummary.setBounds(0, 206, 230, 132);
		
		try {
			File soundFile = new File("sound/Battle_Music.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	         this.clip = AudioSystem.getClip();
	         clip.open(audioIn);
	         //clip.start();
		} catch (UnsupportedAudioFileException | IOException  | LineUnavailableException e) {
		} 
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3 && BText.isPlayerTurn) {
					BControls.setVisible(true);
					BSelectMove.setVisible(false);
					BChoosePokemon.setVisible(false);
				}
			}
		});
		this.setVisible(true);
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//BFrame battle = new BFrame();
	}
}
