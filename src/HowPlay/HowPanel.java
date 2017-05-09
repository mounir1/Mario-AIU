package HowPlay;

import static MainGame.MenuFrame.pathToFile;
import static MainGame.MenuFrame.users;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;

public class HowPanel extends JPanel implements KeyListener, ActionListener {

    Frame Hframe;
    JButton bestscore = new JButton("Best Scores");
    JPanel p;
    public static Path FilePath = Paths.get("Players/output.tex");

    ImageIcon imario = new ImageIcon("Images/mario_down.gif");
    ImageIcon ibox = new ImageIcon("Images/Box.jpg");
    ImageIcon iMarioRight = new ImageIcon("Images/mario_right.gif");
    ImageIcon igoal = new ImageIcon("Images/Goal.jpg");
    ImageIcon idonebox = new ImageIcon("Images/Box_ok.jpg");
    Image mario = imario.getImage();
    Image box = ibox.getImage();
    Image marioright = iMarioRight.getImage();
    Image Goal = igoal.getImage();
    Image donebox = idonebox.getImage();

    /**
     * BY Mounir Abderrahmani
     *
     *
     *
     */
    private static final long serialVersionUID = 1L;

    public HowPanel(Frame h) {
        setLayout(null);
        //bestscore.setContentAreaFilled(true);
        bestscore.setForeground(Color.blue);

        bestscore.setBounds(147, 260, 120, 30);
        add(bestscore);

        Hframe = h;

        setFocusable(true);
        bestscore.addActionListener(this);
        addKeyListener(this);

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.black);
        g.setFont(getFont());
        g.drawString("almost all copy right reserved ", 220, 400);
        Font font = new Font("SanSerif", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("Welcom to Mario in Antalya  ", 30, 25);
        Font font1 = new Font("SanSerif", Font.BOLD, 15);
        g.setFont(font1);
        g.drawString("these are some guids about the game :", 10, 50);
        g.setColor(Color.RED);
        g.drawString("1- use the arrows to indicate Mario's Direction", 20, 70);
        g.drawString("2- push the box to the Goal using Mario", 20, 90);
        g.drawString("3- press R to reset the level if you get stuck !!", 20, 110);
        g.drawString("and you loose points for that ! ", 30, 130);
        //g.drawString(" and you loose 50 points ", 30, 150);
        g.drawString("4- press ESC to go to the main menu !", 20, 150);
        g.drawString("5- hard degree has only one trick find it ", 20, 170);
        g.drawString("each box goes to only one goal", 30, 190);
        g.setFont(new Font("SanSerif", Font.BOLD, 20));
        g.setColor(Color.DARK_GRAY);
        g.drawString("wait for the upcoming versions ", 10, 340);
        g.drawString("mounir1.wordpress.com !", 20, 380);
        g2d.drawImage(mario, 20, 220, null);
        g2d.drawImage(box, 60, 220, null);
        g2d.drawImage(Goal, 100, 220, null);
        //g.drawLine(45, 215, 70,215);
        g2d.drawImage(marioright, 150, 220, null);
        g2d.drawImage(box, 190, 220, null);
        g2d.drawImage(Goal, 230, 220, null);
        g2d.drawImage(marioright, 280, 220, null);
        g2d.drawImage(donebox, 320, 220, null);

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
        int touch = e.getKeyCode();
        if (touch == KeyEvent.VK_ESCAPE) {
            MainGame.MenuFrame frm = new MainGame.MenuFrame();
            Hframe.dispose();
        }

    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bestscore) {
            int size;
            
            try {
                users = (ArrayList<String>) Files.readAllLines(pathToFile);
                MainGame.MenuFrame.Update();
            } catch (IOException ex) {
                Logger.getLogger(HowPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (users.size() < 20) {
                size = users.size();
            } else {
                size = 20;
            }
            Object[] cols = {"Num", "Name", "Level", "Score"};
            Object[][] rows = new Object[size][cols.length];
            for (int i = 0; i < size; i++) {
                //for (int j = 0; j < cols.length; j++) {
                    rows[i][0] = ("    " + (i+1));
                    rows[i][1] = ("    " + users.get(i).split(" ")[0]);
                    rows[i][2] = ("    " + (String)(users.get(i).split(" ")[1]));
                    rows[i][3] = ("    " + (String) (users.get(i).split(" ")[2]));

                
            }
            JTable table = new JTable(rows, cols);
            table.setSize(5, 5);
            JOptionPane.showMessageDialog(null, new JScrollPane(table));
            
        }
    }
}
