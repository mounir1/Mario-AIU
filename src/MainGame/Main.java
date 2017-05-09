/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGame;
import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
public class Main {

    /**
     * @param args
     * @ Mounir Abderrahmani
     */
    public static void main(String[] args) {
          MenuFrame frm = new MenuFrame();
          //GameEditor.FrameEditor frm1 = new GameEditor.FrameEditor();
         // HowPlay.HowFrame frm2 = new HowPlay.HowFrame();
         // MarioGame.GameFrame frm3 = new  MarioGame.GameFrame();
        
        
        try {
        	//MenuFrame.fillusers();
            File file = new File("Sounds/Mario.mp3");
            FileInputStream fit = new FileInputStream (file);
            BufferedInputStream bis = new BufferedInputStream(fit);
            try {
                Player player = new Player(bis);
                player.play();

            }catch(JavaLayerException ex){}


        }catch(IOException e){}
    }
}