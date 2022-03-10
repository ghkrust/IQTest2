
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static JPanel currentPanel;
    static JFrame bg;
    static int currentQuestionIndex = 0;
    static Color mainColor = Color.BLACK;
    static Rectangle defaultPanelLayout = new Rectangle(0, 0, 1920, 1080);
    static Rectangle largeButtonLayout = new Rectangle(770, 100);
    static Rectangle defaultButtonLayout = new Rectangle(380, 100);
    static Rectangle backButtonLayout = new Rectangle(200, 70);
    static Font titleFont = new Font(null, Font.BOLD, 100);
    static Font subTitleFont = new Font(null, Font.PLAIN, 50);
    static Font defaultFont = new Font(null, Font.PLAIN, 20);
    static Font buttonFont = new Font(null, Font.PLAIN, 25);

    public static void main(String[] args) {

        //region Setting up the frame
        bg = new JFrame("Idiot Test 2022 - vers. 1.3");
        bg.setSize(1920, 1080);
        bg.setVisible(true);
        bg.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        bg.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                for (;;) {
                    Thread thread = new Thread();
                    thread.run();
                }
            }
        });
        bg.setLayout(null);

        MainMenu menu1 = new MainMenu();
        bg.add(menu1);
        currentPanel = menu1;
    }

    public static boolean changePanel(String panelName) {
        //FIXME ADD ERROR CHECK
        try {
            bg.remove(currentPanel);
        } catch (NullPointerException ex) {
            //cry about it
        }
        bg.remove(currentPanel);
        if (panelName.equals("mainMenu")) {
            currentPanel = new MainMenu();
        } else if (panelName.equals("settings")) {
            currentPanel = new Settings();
        } else if (panelName.equals("questions")) {
            currentPanel = new Questions();
        } else {
            System.exit(-1);
        }
        bg.add(currentPanel);
        currentPanel.updateUI();
        return true;
    }
}
