import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class MainMenu extends JPanel {
    public MainMenu(){

        this.setBounds(Main.defaultPanelLayout);
        this.setLayout(null);
        Color theme=Main.mainColor;

        JLabel title=new JLabel("The Stupid Test");
        title.setBounds(550,300,1000,100);
        title.setFont(Main.titleFont);
        title.setForeground(theme);
        this.add(title);

        JLabel versionLabel=new JLabel("Version 1.3");
        versionLabel.setBounds(1000,400,600,70);
        versionLabel.setFont(Main.subTitleFont);
        versionLabel.setForeground(Color.gray);
        this.add(versionLabel);

        JButton start=new JButton("Start the Test");
        start.setBounds(Main.largeButtonLayout);
        start.setLocation(550,500);
        start.setFont(Main.buttonFont);
        start.setForeground(theme);
        this.add(start);

        JButton settings=new JButton("Settings");
        settings.setBounds(Main.largeButtonLayout);
        settings.setLocation(550,610);
        settings.setFont(Main.buttonFont);
        settings.setForeground(theme);
        this.add(settings);


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changePanel("questions");
            }
        });
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changePanel("settings");
            }
        });
    }
}
