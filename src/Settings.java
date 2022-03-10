import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JPanel {
    public Settings(){

        this.setBounds(Main.defaultPanelLayout);
        this.setLayout(null);

        JLabel settingsTitle=new JLabel("Settings");
        settingsTitle.setFont(Main.subTitleFont);
        settingsTitle.setBounds(300,50,500,70);
        this.add(settingsTitle);


        JButton back=new JButton("Back");
        back.setBounds(Main.backButtonLayout);
        back.setLocation(50,50);
        back.setFont(Main.buttonFont);
        this.add(back);

        JLabel favoriteColorTitle=new JLabel("Favorite Color");
        favoriteColorTitle.setBounds(100,300,200,50);
        favoriteColorTitle.setFont(Main.buttonFont);
        this.add(favoriteColorTitle);

        JButton colorButton=new JButton();
        colorButton.setBounds(300,300,75,75);
        colorButton.setBackground(Main.mainColor);
        this.add(colorButton);

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color intialColor=Main.mainColor;
                Main.mainColor=JColorChooser.showDialog(colorButton,"Color Picker",intialColor);
                colorButton.setBackground(Main.mainColor);
                updateUI();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changePanel("mainMenu");
            }
        });
    }
}
