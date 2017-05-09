package GameEditor;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import MainGame.MenuFrame;

import java.awt.HeadlessException;
import java.io.IOException;


public class BoardEditor extends JPanel implements MouseListener, MouseWheelListener, KeyListener, MouseMotionListener {

    /*
     *
     *
         * 
         *
         * 
         */
    private static final long serialVersionUID = 1L;
    String Editor[][] = new String[12][12];
    String ImageSelect[] = {"Wall", "Box", "Mario", "Goal"};
    String CourentImage = "Wall";
    int Mx, My;
    int index = 0;
    Image Mario;
    Image Wall;
    Image Box;
    Image Goal;

    FileWriter fw;
    FileReader fr;
    Frame Eframe;

    public BoardEditor(Frame ef) {
        ImageIcon iMario = new ImageIcon("Images/mario_down.gif");
        Mario = iMario.getImage();
        ImageIcon ibox = new ImageIcon("Images/Box.jpg");
        Box = ibox.getImage();
        ImageIcon iwall = new ImageIcon("Images/wall.jpg");
        Wall = iwall.getImage();
        ImageIcon igoal = new ImageIcon("Images/Goal.jpg");
        Goal = igoal.getImage();
        Eframe = ef;

        setFocusable(true);

        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        addKeyListener(this);

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 11; j++) {
                if ("Wall".equals(Editor[i][j]))
                    g2d.drawImage(Wall, i * 34, j * 34, null);
                if ("Mario".equals(Editor[i][j]))
                    g2d.drawImage(Mario, i * 34, j * 34, null);
                if ("Box".equals(Editor[i][j]))
                    g2d.drawImage(Box, i * 34, j * 34, null);
                if ("Goal".equals(Editor[i][j]))
                    g2d.drawImage(Goal, i * 34, j * 34, null);
            }
        }
        if (CourentImage.equals("Wall")) {
            g2d.drawImage(Wall, Mx, My, null);

        } else if (CourentImage.equals("Box")) {
            g2d.drawImage(Box, Mx, My, null);

        } else if (CourentImage.equals("Mario")) {
            g2d.drawImage(Mario, Mx, My, null);

        } else if (CourentImage.equals("Goal")) {
            g2d.drawImage(Goal, Mx, My, null);

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Mx = e.getX() - 17;
        My = e.getY() - 17;
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key = e.getKeyChar();
        if (key == 'S'||key =='s') {
            try {
                fw = new FileWriter(JOptionPane.showInputDialog(null, "input the path to save :", "Map Editor", JOptionPane.QUESTION_MESSAGE));
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 12; j++) {
                        if ("Wall".equals(Editor[j][i]))
                            fw.write('0');
                        else if ("Mario".equals(Editor[j][i]))
                            fw.write('1');
                        else if ("Box".equals(Editor[j][i]))
                            fw.write('2');
                        else if ("Goal".equals(Editor[j][i]))
                            fw.write('3');
                        else if (Editor[j][i] == null)
                            fw.write(' ');
                    }
                    fw.write("\r\n");
                }
                fw.close();
            } catch (HeadlessException ex) {
            } catch (IOException ex) {
            }
        } else if (key == 'r'||key =='R') {
            try {
                fr = new FileReader(JOptionPane.showInputDialog(null, "input the path to read :", "Map Editor", JOptionPane.QUESTION_MESSAGE));
                int i = 0;
                int x = 0, y = 0;

                while ((i = fr.read()) != -1) {
                    char strImg = (char) i;
                    if (strImg == '0')
                        Editor[x][y] = "Wall";
                    else if (strImg == '1')
                        Editor[x][y] = "Mario";
                    else if (strImg == '2')
                        Editor[x][y] = "Box";
                    else if (strImg == '3')
                        Editor[x][y] = "Goal";
                    else if (strImg == ' ')
                        Editor[x][y] = null;
                    else if (strImg == '\r' || strImg == '\n')
                        x--;
                    if (x == 11) {
                        y++;
                        x = 0;
                    } else
                        x++;
                }
            } catch (HeadlessException ex) {} catch (IOException ex) {}
            repaint();
        } else if (key == KeyEvent.VK_ESCAPE) {
            MenuFrame frm = new MenuFrame();
            Eframe.dispose();
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int rot = e.getWheelRotation();
        if (rot < 0) {
            if (index > 0)
                index--;
        } else if (rot > 0) {
            if (index < 3)
                index++;
        }
        CourentImage = ImageSelect[index];
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX() / 34;
        int y = e.getY() / 34;
        if (e.getButton() == MouseEvent.BUTTON1)
            Editor[x][y] = CourentImage;
        else if (e.getButton() == MouseEvent.BUTTON3)
            Editor[x][y] = null;
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }


}


