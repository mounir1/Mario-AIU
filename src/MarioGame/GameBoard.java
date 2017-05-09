package MarioGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by mounir.abderrahmani on 20.11.2014.
 */
public class GameBoard extends JPanel implements KeyListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String Game[][] = new String[12][12];
    public static boolean hard = false;
    public static int Level;
    public static String Player = "";
    public static int SCORE_END = 0;
    private static ArrayList<Wall> Walls;
    private static ArrayList<Goal> Goals;
    private static ArrayList<Box> Boxes;
    Wall wall;
    Mario mario;
    Box box, box2;
    Goal goal;
    Font levelFont = new Font("SanSerif", Font.BOLD, 30);
    FileReader fr;
    Frame Gframe;
    Calendar min = Calendar.getInstance();
    boolean Done = false;

    int moves = 0;
    int Score = 0;
    public static int SCORE = 0;
    int timing;
    int nbrofdoneboxes = 0;

    public GameBoard(Frame gf) {

        fillLevel();
        Gframe = gf;
        setFocusable(true);
        addKeyListener(this);

    }

    public void Levels() {
        switch (Level) {
            case 1:
                moves = 25;
                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "  The Target :\n"
                        + "less than " + moves + " moves", "Level:" + Level, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                moves = 30;
                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "  The Target :\n"
                        + "less than " + moves + " moves", "Level:" + Level, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                if (hard) {
                    moves = 51;
                } else {
                    moves = 55;
                }
                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "  The Target :\n"
                        + "less than " + moves + " moves", "Level:" + Level, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 4:
                if (hard) {
                    moves = 62;
                } else {
                    moves = 52;
                }

                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "  The Target :\n"
                        + "less than " + moves + " moves", "Level:" + Level, JOptionPane.INFORMATION_MESSAGE);
                break;

            case 5:
                if (hard) {
                    moves = 37;
                } else {
                    moves = 30;
                }
                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "  The Target :\n"
                        + "less than " + moves + " moves", "Level:" + Level, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 6:
                if (hard) {
                    moves = 58;
                } else {
                    moves = 40;
                }
                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "  The Target :\n"
                        + "less than " + moves + " moves", "Level:" + Level, JOptionPane.INFORMATION_MESSAGE);

                break;
            case 7:
                if (hard) {
                    moves = 55;
                } else {
                    moves = 45;
                }
                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "  The Target :\n"
                        + "less than " + moves + " moves", "Level:" + Level, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 8:
                if (hard) {
                    moves = 71;
                } else {
                    moves = 34;
                }
                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "  The Target :\n"
                        + "less than " + moves + " moves", "Level:" + Level, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 9:
                if (hard) {
                    moves = 122;
                } else {
                    moves = 115;
                }
                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "  The Target :\n"
                        + "less than " + moves + " moves", "Level:" + Level, JOptionPane.INFORMATION_MESSAGE);
                break;
            case -10:
                if (hard) {
                    moves = 70;
                } else {
                    moves = 120;
                }
                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "  The Target :\n"
                        + "less than " + moves + " moves", "Level:" + Level, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 10:
                moves = 60;
                this.timing = 50000;
                JOptionPane.showMessageDialog(null, "well done\n"
                        + "Congrats !! " + Player + " ");
                break;

        }

    }

    public void fillLevel() {
        try {
            fr = new FileReader("Maps/level" + Level + ".level");
            int x = 0, y = 0, i = 0;
            Walls = new ArrayList<Wall>();
            Boxes = new ArrayList<Box>();
            Goals = new ArrayList<Goal>();

            while ((i = fr.read()) != -1) {
                char strImg = (char) i;
                if (strImg == '0') {
                    Game[x][y] = "Wall";
                    wall = new Wall(x * 34, y * 34);
                    Walls.add(wall);
                } else if (strImg == '1') {
                    Game[x][y] = "Mario";
                    mario = new Mario(x * 34, y * 34);
                } else if (strImg == '2') {
                    Game[x][y] = "Box";
                    box = new Box(x * 34, y * 34);
                    Boxes.add(box);
                } else if (strImg == '3') {
                    Game[x][y] = "Goal";
                    goal = new Goal(x * 34, y * 34);
                    Goals.add(goal);
                } else if (strImg == ' ') {
                    Game[x][y] = "null";
                } else if (strImg == '\r' || strImg == '\n') {
                    x--;
                }
                if (x == 11) {
                    y++;
                    x = 0;
                } else {
                    x++;
                }
            }

        } catch (Exception ex) {
        }

        repaint();
        moves = 0;
        Levels();

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < Walls.size(); i++) {
            wall = Walls.get(i);
            g2d.drawImage(wall.getImage(), wall.getX(), wall.getY(), null);
        }
        for (int i = 0; i < Goals.size(); i++) {
            goal = Goals.get(i);
            g2d.drawImage(goal.getImage(), goal.getX(), goal.getY(), null);
        }
        for (int i = 0; i < Boxes.size(); i++) {
            box = Boxes.get(i);
            g2d.drawImage(box.getImage(), box.getX(), box.getY(), null);
        }
        try {
            g2d.drawImage(mario.getImage(), mario.getX(), mario.getY(), null);
        } catch (Exception ex) {
        }
        if (Done == false) {
            g.setColor(Color.BLACK);
            g.setFont(levelFont);
            g.drawString("LEVEL : " + Level, 10, 25);
            Font scorFont = new Font("SanSerif", Font.BOLD, 20);
            g.setFont(scorFont);
            g.setColor(Color.blue);
            if (hard) {
                g.drawString("Hard", 180, 25);
            } else {
                g.drawString("Easy", 180, 25);
            }

            g.setColor(Color.black);
            //g.drawString("Time :" + (timing), 200, 15);

            g.drawString("Moves : " + moves, 280, 25);
            g.drawString("Score : " + SCORE, 250, 400);
            g.drawString("Player : " + Player, 10, 400);
        } else {
            g.setFont(new Font("Serif", Font.BOLD, 30));
            g.setColor(Color.red);
            g.drawString("Congrats ! " + Player, 60, 160);
            g.drawString("" + SCORE, 160, 110);
            g.setFont(new Font("Serif", Font.BOLD, 15));
            g.setColor(Color.black);
            g.drawString("if you want to controbute on the game contact me ", 40, 200);
            g.drawString("let me know !! ", 70, 220);
            g.drawString("mounir1badi@gmail.com ", 70, 240);
            g.drawString("new version coming soon stay tuned", 100, 350);
            g.drawString("have a great day !", 100, 370);

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void CheckCollision() {
        Rectangle mariorec;
        mariorec = mario.getBounds();
        for (int i = 0; i < Walls.size(); i++) {
            wall = Walls.get(i);
            Rectangle wallrec = wall.getBounds();
            if (mariorec.intersects(wallrec)) // turn back (don't move) -- > Mario can't over pass the wall
            {
                if (mario.getDir() == "Down") {        // just by setting his position back depending on the direction
                    mario.setY(mario.getY() - 34);
                } else if (mario.getDir() == "Up") {
                    mario.setY(mario.getY() + 34);
                } else if (mario.getDir() == "Left") {
                    mario.setX(mario.getX() + 34);
                } else if (mario.getDir() == "Right") {
                    mario.setX(mario.getX() - 34);
                }
            }
        }
        for (int i = 0; i < Boxes.size(); i++) {
            box = Boxes.get(i);
            Rectangle boxrec = box.getBounds();

        }
        for (int i = 0; i < Boxes.size(); i++) {
            box = Boxes.get(i);
            Rectangle boxrec = box.getBounds();
            if (mariorec.intersects(boxrec)) {   // intersecting with the box == the moving box !
                if (box.getState() == "Normal") { // can pass over done boxes
                    if (mario.getDir() == "Down") {
                        if (Game[boxrec.x / 34][(boxrec.y + 34) / 34] != "Wall" && Game[boxrec.x / 34][(boxrec.y + 34) / 34] != "Box") {
                            box.setY(box.getY() + 34);
                            Game[boxrec.x / 34][boxrec.y / 34] = null;
                            Game[boxrec.x / 34][(boxrec.y + 34) / 34] = "Box";
                            moves--;
                            /// don't push the box when after the rectangle is either a box or a wall
                        } else if (Game[boxrec.x / 34][(boxrec.y + 34) / 34] == "Wall" || Game[boxrec.x / 34][(boxrec.y + 34) / 34] == "Box") {
                            mario.setY(mario.getY() - 34);
                            //moves++;
                        }
                    } else if (mario.getDir() == "Up") {
                        if (Game[boxrec.x / 34][(boxrec.y - 34) / 34] != "Wall" && Game[boxrec.x / 34][(boxrec.y - 34) / 34] != "Box") {
                            box.setY(box.getY() - 34);
                            Game[boxrec.x / 34][boxrec.y / 34] = null;
                            Game[boxrec.x / 34][(boxrec.y - 34) / 34] = "Box";
                            moves--;
                        } else if (Game[boxrec.x / 34][(boxrec.y - 34) / 34] == "Wall" || Game[boxrec.x / 34][(boxrec.y - 34) / 34] == "Box") {
                            mario.setY(mario.getY() + 34);
                            //moves++;
                        }
                    } else if (mario.getDir() == "Left") {
                        if (Game[(boxrec.x - 34) / 34][(boxrec.y / 34)] != "Wall" && Game[(boxrec.x - 34) / 34][(boxrec.y / 34)] != "Box") {
                            box.setX(box.getX() - 34);
                            Game[(boxrec.x / 34)][(boxrec.y / 34)] = null;
                            Game[(boxrec.x - 34) / 34][(boxrec.y / 34)] = "Box";
                            moves--;
                        } else if (Game[(boxrec.x - 34) / 34][(boxrec.y / 34)] == "Wall" || Game[(boxrec.x - 34) / 34][(boxrec.y / 34)] == "Box") {
                            mario.setX(mario.getX() + 34);
                            //moves++;
                        }
                    } else if (mario.getDir() == "Right") {
                        if (Game[(boxrec.x + 34) / 34][(boxrec.y / 34)] != "Wall" && Game[(boxrec.x + 34) / 34][(boxrec.y / 34)] != "Box") {
                            box.setX(box.getX() + 34);
                            Game[boxrec.x / 34][(boxrec.y / 34)] = null;
                            Game[(boxrec.x + 34) / 34][(boxrec.y / 34)] = "Box";
                            moves--;
                        } else if (Game[(boxrec.x + 34) / 34][(boxrec.y / 34)] == "Wall" || Game[(boxrec.x + 34) / 34][(boxrec.y / 34)] == "Box") {
                            mario.setX(mario.getX() - 34);
                            //moves++;
                        }
                    }
                }
            }
        }

        for (int j = 0; j < Boxes.size(); j++) {
            for (int i = 0; i < Goals.size(); i++) {

                if (hard) {
                    box = Boxes.get(i);
                } else {
                    box = Boxes.get(j);
                }
                goal = Goals.get(i);
                Rectangle goalrec = goal.getBounds();
                Rectangle boxrec = box.getBounds();
                if (boxrec.intersects(goalrec)) {
                    box.setState("Goal");

                } else if (!boxrec.intersects(goalrec)) {
                    box.setState("Normal");

                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int touch = e.getKeyCode();
        if (touch == KeyEvent.VK_DOWN) {

            //Sounds.sound1.play();
            mario.SetDir("Down");
            mario.Move();
            CheckCollision();

        } else if (touch == KeyEvent.VK_UP) {

            mario.SetDir("Up");
            mario.Move();
            CheckCollision();

        } else if (touch == KeyEvent.VK_RIGHT) {

            mario.SetDir("Right");
            mario.Move();
            CheckCollision();

        } else if (touch == KeyEvent.VK_LEFT) {

            mario.SetDir("Left");
            mario.Move();
            CheckCollision();

        } else if (touch == KeyEvent.VK_R) {
            fillLevel();
            if (hard) {
                SCORE_END = SCORE_END - 50;
            } else {
                SCORE_END = SCORE_END - 40;
            }

        } else if (touch == KeyEvent.VK_ESCAPE) {
            MainGame.MenuFrame frm = new MainGame.MenuFrame();
            Gframe.dispose();
            Score = 0;
            try {

                MainGame.MenuFrame.addUser(Player + " " + String.valueOf(Level) + " " + String.valueOf(SCORE + SCORE_END));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            SCORE = SCORE_END = 0;
        }

        repaint();
        CheckLastLevel();

    }

    public void CheckLastLevel() {
        nbrofdoneboxes = 0;
        Score = 0;

        if (moves == 0 && nbrofdoneboxes != Boxes.size()) {
            JOptionPane.showMessageDialog(null, "you over Moved try again ! ");
            MainGame.MenuFrame frm = new MainGame.MenuFrame();
            Gframe.dispose();
            try {

                MainGame.MenuFrame.addUser(Player + " " + String.valueOf(Level) + " " + String.valueOf(SCORE + SCORE_END));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            SCORE_END = 0;
            SCORE = 0;
        }
        for (MarioGame.Box Boxe : Boxes) {
            box = Boxe;
            if ("Goal".equals(box.State)) {
                nbrofdoneboxes++;
                Score++;

                if (Score != 0) {
                    if (hard) {
                        SCORE = +Score * 50;
                    } else {
                        SCORE = +Score * 40;
                    }
                }

            }

            if (nbrofdoneboxes == Boxes.size()) {
                Level++;

                if (moves > 0) {
                    if (hard) {
                        SCORE_END += SCORE + moves * 25;
                    } else {
                        SCORE_END += SCORE + moves * 5;
                    }
                    fillLevel();
                    SCORE = +SCORE_END;
                }
            }
        }

        if (Level == 10) {
            Done = true;
            repaint();
        }
    }

}
