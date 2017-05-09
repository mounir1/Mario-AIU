package MarioGame;

import static MainGame.MenuFrame.users;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class GameFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    ImageIcon iMario = new ImageIcon("Images/Mario_aiu.png");
    private static String Player;
    private static int Level = GameBoard.Level;
    private int SCORE_END = GameBoard.SCORE_END;
    private int SCORE = GameBoard.SCORE;

    /**
     *
     */
    public GameFrame() {
        this.setIconImage(iMario.getImage());
        this.setTitle("Mario-Antalya");
        this.setSize(414, 436);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Yes", "No"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Confirmation!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    try {
                        MainGame.MenuFrame.addUser(Player + " " + String.valueOf(Level) + " " + String.valueOf(SCORE + SCORE_END));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    users.clear();
                    System.exit(0);
                }
            }
        });

        this.setLocationRelativeTo(null);
        this.add(new GameBoard(this));
        this.setResizable(false);
        this.setVisible(true);
    }
}
