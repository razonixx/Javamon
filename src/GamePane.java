import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


    public class GamePane extends JPanel {

        private MainCharacter mc;
        private KeyState keyState;
        private int frame;
        protected Timer timer;

        public GamePane() {
        	
            mc = new MainCharacter();

            timer = new Timer(20, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame++;
                    if (frame > 100) {
                        frame = 0;
                    };
                    repaint();
                }
            });
            
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Right");

            ActionMap am = getActionMap();
            am.put("Up", new KeyStateAction(KeyState.UP));
            am.put("Down", new KeyStateAction(KeyState.DOWN));
            am.put("Left", new KeyStateAction(KeyState.LEFT));
            am.put("Right", new KeyStateAction(KeyState.RIGHT));
            this.setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Image img = mc.getCharacter(keyState, frame);
            g2d.drawImage(img, 0, 0, this);
            g2d.dispose();
        }

        public class KeyStateAction extends AbstractAction {

            private KeyState state;

            public KeyStateAction(KeyState state) {
                this.state = state;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                keyState = state;
            }

        }

    }

    enum KeyState {

        UP, DOWN, LEFT, RIGHT;

    }

    class MainCharacter {

        private Map<KeyState, List<Image>> mapImage;

        public MainCharacter() {
            mapImage = new HashMap<>(25);
            try {
                mapImage.put(KeyState.UP, loadImages("playerSprites/Up"));
                mapImage.put(KeyState.DOWN, loadImages("playerSprites/Down"));
                mapImage.put(KeyState.LEFT, loadImages("playerSprites/Left"));
                mapImage.put(KeyState.RIGHT, loadImages("playerSprites/Right"));
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

        protected List<Image> loadImages(String name) throws IOException {

            List<Image> images = new ArrayList<>(25);
            images.add(ImageIO.read(new File(name + "1.png")));
            images.add(ImageIO.read(new File(name + "2.png")));

            return images;

        }

        public Image getCharacter(KeyState keyState, int frame) {

            Image img = null;
            List<Image> images = mapImage.get(keyState);
            if (images == null) {
                images = mapImage.get(KeyState.DOWN);
            }
            int index = (frame / 10) % 2 == 0 ? 0 : 1;
            img = images.get(index);

            return img;

        }

    }