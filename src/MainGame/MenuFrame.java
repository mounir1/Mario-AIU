package MainGame;

import GameEditor.FrameEditor;
import HowPlay.HowFrame;
import MarioGame.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class MenuFrame extends JFrame implements ActionListener {

    /**
     *
     *
     */
    private static final long serialVersionUID = 1L;

    JPanel pan = new JPanel();
    //JPanel RadioB = new JPanel();
    JLabel lbl;
    JLabel lbl1;
    JLabel lbl2;
    JLabel lblb;
    JButton Scores = new JButton("Best Scores");
    JButton cmdGame = new JButton("Play ");
    JButton cmdEditor = new JButton("Editor");
    JButton cmdhow = new JButton("About");
    ImageIcon iMario = new ImageIcon("Images/Mario_aiu.png");
    ImageIcon Menu = new ImageIcon("Images/menu2.png");
    ImageIcon ioff = new ImageIcon("Images/Soundoff.png");
    ImageIcon ionn = new ImageIcon("Images/soundon.png");
    ImageIcon sound;
    public static Path pathToFile = Paths.get("Players/Users.tex");
    JButton S = new JButton();

    static boolean Mut = false;
    JRadioButton b1, b2;
    ButtonGroup bg;
    //static String file = "Players/Users.log";
    //static File file = new File(path);

    FileWriter fw;

    public static ArrayList<String> users = new ArrayList<String>();

    String level;

    public MenuFrame() {

        this.setIconImage(iMario.getImage());
        setLayout(new FlowLayout());
        this.setTitle("Main Menu");
        this.setSize(414, 436);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        b1 = new JRadioButton("Easy");
        b2 = new JRadioButton("Hard");
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Yes", "No"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Confirmation!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    users.clear();
                    System.exit(0);
                }
            }
        });
        bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        lbl = new JLabel(Menu);

        pan.setBackground(Color.white);
        pan.add(cmdGame);
        pan.add(cmdEditor);
        pan.add(cmdhow);
        b1.doClick();
        pan.add(b1);
        pan.add(b2);
        if (Mut) {
            sound = ioff;
            JButton S = new JButton(sound);
        } else {
            sound = ionn;
            JButton S = new JButton(sound);

        }

        S.setBackground(Color.white);
        // pan.add(S);
        pan.add(lbl);

        S.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        cmdGame.addActionListener(this);
        cmdEditor.addActionListener(this);
        cmdhow.addActionListener(this);
        //bestscore.addActionListener(this);
        Scores.addActionListener(this);

        this.setContentPane(pan);
        this.setVisible(true);

    }

   
    public static void addUser(String USER) throws IOException {
        boolean exist = false;
        users.clear();
        users = (ArrayList<String>) Files.readAllLines(pathToFile);
        for (int i = 0; i < users.size(); i++) {

            if (USER.split(" ")[0] == null ? users.get(i).split(" ")[0] == null : USER.split(" ")[0].equals(users.get(i).split(" ")[0])) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            users.add(USER);
        } else {
            String[] PL = USER.split(" ");
            String Name = PL[0];
            int lvl = Integer.parseInt(PL[1]);
            int scor = Integer.parseInt(PL[2]);
            for (int i = 0; i < users.size(); i++) {
                String[] st = (users.get(i)).split(" ");
                if (Name.trim().equals(st[0].trim())) {
                    if (lvl > Integer.parseInt(st[1]) || scor > Integer.parseInt(st[2])) {
                        users.set(i, USER);
                        exist = false;
                        break;
                    } else {
                        break;//redundant ...
                    }
                }
            }
        }
        if (users.size() <= 1 ) {
            Files.write(pathToFile, users);
        } else {
            Update();
            Files.write(pathToFile, users);
        }

        users.clear();
    }

    public static void Update() {
        int n = users.size();
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < (n - 1); i++) {
                k = i + 1;
                if (Integer.parseInt(users.get(i).split(" ")[2]) < Integer.parseInt(users.get(k).split(" ")[2])) {
                    String temp;
                    temp = users.get(i);
                    users.set(i, users.get(k));
                    users.set(k, temp);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cmdGame) {

            while (GameBoard.Player.equalsIgnoreCase("") || GameBoard.Player.contains(" ")) {

                GameBoard.Player = JOptionPane.showInputDialog(null, "write your name here ");

            }

            if ("Mounir".equals(GameBoard.Player)) {
                level = JOptionPane.showInputDialog(null, "Hi Smart ass input lvl");
                GameBoard.Level = Integer.parseInt(level);
            } /* } else if (users.contains(Name)) {/// not using this currently ...
             lvl = getlevel(Name);
             } */ else if (GameBoard.Player == null) {
                e.setSource(cmdGame);
            } else {
                GameBoard.Level = 1;
            }
            GameFrame frm = new GameFrame();
            dispose();
        } else if (e.getSource() == cmdEditor) {
            FrameEditor frm = new FrameEditor();
            JOptionPane.showMessageDialog(null, "you can create/edit levels\n "
                    + "if you want to contobute contact me Mounir1badi@gmail.com\n"
                    + "!press ESC to go back");
            dispose();
        } else if (e.getSource() == cmdhow) {
            HowFrame frm = new HowFrame();
            dispose();
        }
        if (e.getSource() == b1) {
            MarioGame.GameBoard.hard = false;
        }
        if (e.getSource() == b2) {
            MarioGame.GameBoard.hard = true;
        } else if (e.getSource() == S) {
            Mut = Mut == false; /// mut the sound ...
            repaint();
        }
    }
}
