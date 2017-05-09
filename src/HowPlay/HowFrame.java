/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HowPlay;

import static MainGame.MenuFrame.users;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mounir
 */
public class HowFrame extends javax.swing.JFrame {

    ImageIcon iMario = new ImageIcon("Images/Mario_aiu.png");

    /**
     * Creates new form How
     */
    public HowFrame() {

        this.setIconImage(iMario.getImage());
        setTitle("How to play !!");
        setSize(414, 436);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

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
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        add(new HowPanel(this));

    }

}
