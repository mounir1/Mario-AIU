package GameEditor;

import static MainGame.MenuFrame.users;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameEditor extends JFrame{
   
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	ImageIcon iMario = new ImageIcon("Images/Mario_aiu.png");
	public FrameEditor(){
	this.setIconImage(iMario.getImage());
        this.setTitle("Map Editor");
        this.setSize(414,436);
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
        this.setLocationRelativeTo(null);
        this.add(new BoardEditor(this));
        this.setVisible(true);
        this.setResizable(false);
    }
}
