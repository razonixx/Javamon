import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class OWFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	protected Image playerFront = new ImageIcon("playerSprites/Down1.png").getImage();
	protected Image playerBack = new ImageIcon("playerSprites/Up1.png").getImage();
	protected Image playerLeft = new ImageIcon("playerSprites/Left1.png").getImage();
	protected Image playerRight = new ImageIcon("playerSprites/Right1.png").getImage();
	protected Image playerSprite;
	
	protected PalletTown PalletTown = new PalletTown(this);
	protected Route1 Route1 = new Route1(this);
	protected ViridianCity ViridianCity = new ViridianCity(this);
	protected Route2 Route2 = new Route2(this);
	protected Cuartito Cuartito = new Cuartito(this);
	protected ViridianForest ViridianForest = new ViridianForest(this);
	protected Cuartito2 Cuartito2 = new Cuartito2(this);
	protected PewterCity PewterCity = new PewterCity(this);
	protected PewterGym PewterGym = new PewterGym(this);


	public OWFrame() {
		super("Pokemon");
		this.setLayout(null);
		this.setSize(530, 520);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("GUI/Pokeball.png").getImage());
		this.setVisible(true);
		this.setResizable(false);
		this.playerSprite = this.playerFront;
		this.add(this.PalletTown);
		this.add(this.Route1);
		this.add(this.ViridianCity);
		this.add(this.Route2);
		this.add(this.Cuartito);
		this.add(this.ViridianForest);
		this.add(this.Cuartito2);
		this.add(this.PewterCity);
		this.add(this.PewterGym);

		
		//this.PalletTown.setVisible(false);
		this.Route1.setVisible(false);
		this.ViridianCity.setVisible(false); 
		this.Route2.setVisible(false);
		this.Cuartito.setVisible(false);
		this.ViridianForest.setVisible(false);
		this.Cuartito2.setVisible(false);
		this.PewterCity.setVisible(false);
		this.PewterGym.setVisible(false);


		this.PalletTown.setBounds(0,0,530, 520);
		this.Route1.setBounds(-90, -740, 728, 1230);
		this.ViridianCity.setBounds(-308, -415, 1072, 950);
		this.Route2.setBounds(-5, -1485, 536, 1968);
		this.Cuartito.setBounds(0, 4,530, 520);
		this.ViridianForest.setBounds(-1400, -2518, 3352, 3000);
		this.Cuartito2.setBounds(0, 4,530, 520);
		this.PewterCity.setBounds(-308, -415, 1522, 1302);
		this.PewterGym.setBounds(0,-36,530, 520);
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		OWFrame overworld = new OWFrame();
	}
}
