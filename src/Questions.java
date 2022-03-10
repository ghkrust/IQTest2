import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Questions extends JPanel {
    public Questions(){
        Color theme=Main.mainColor;

        this.setLayout(null);
        this.setBounds(Main.defaultPanelLayout);

        JButton backButton=new JButton("Back");
        backButton.setBounds(Main.backButtonLayout);
        backButton.setLocation(50,50);
        backButton.setFont(Main.buttonFont);
        this.add(backButton);

        Rectangle radioButtonLayout=new Rectangle(400,30);



        JPanel questionPanel=new JPanel();
        questionPanel.setBounds(100,400,420,170);
        questionPanel.setLayout(null);
        this.add(questionPanel);

        JRadioButton option1=new JRadioButton();
        option1.setBounds(radioButtonLayout);
        option1.setLocation(10,10);
        option1.setFont(Main.defaultFont);
        option1.setBackground(Color.lightGray);
        option1.setForeground(theme);
        questionPanel.add(option1);

        JRadioButton option2=new JRadioButton();
        option2.setBounds(radioButtonLayout);
        option2.setLocation(10,50);
        option2.setFont(Main.defaultFont);
        option2.setBackground(Color.lightGray);
        option2.setForeground(theme);
        questionPanel.add(option2);

        JRadioButton option3=new JRadioButton();
        option3.setBounds(radioButtonLayout);
        option3.setLocation(10,90);
        option3.setFont(Main.defaultFont);
        option3.setBackground(Color.lightGray);
        option3.setForeground(theme);
        questionPanel.add(option3);

        JRadioButton option4=new JRadioButton();
        option4.setBounds(radioButtonLayout);
        option4.setLocation(10,130);
        option4.setFont(Main.defaultFont);
        option4.setBackground(Color.lightGray);
        option4.setForeground(theme);
        questionPanel.add(option4);

        JTextField nameInput=new JTextField();
        nameInput.setFont(Main.defaultFont);
        nameInput.setBounds(10,80,400,30);
        questionPanel.add(nameInput);

        JButton submit=new JButton("Next");
        submit.setBounds(Main.defaultButtonLayout);
        submit.setLocation(110,640);
        submit.setFont(Main.buttonFont);
        submit.setForeground(theme);
        this.add(submit);

        this.add(questionPanel);

        ButtonGroup questions=new ButtonGroup();
        questions.add(option1);
        questions.add(option2);
        questions.add(option3);
        questions.add(option4);

        option1.setVisible(false);
        option2.setVisible(false);
        option3.setVisible(false);
        option4.setVisible(false);
        nameInput.setVisible(false);

        String[] questionsArray=new String[7];
        questionsArray[0]="What is your name?";
        questionsArray[1]="What is your favorite color?";
        questionsArray[2]="Do you like the new color theme?";
        questionsArray[3]="Are you using your time effectively?";
        questionsArray[4]="Who are you taking this test with?";
        questionsArray[5]="Do you have any idea what the "+"\n"+"contents of this test are?";
        questionsArray[6]="Want to see a cool slide transition I made?";

        String[] option1Array=new String[7];
        option1Array[0]="";
        option1Array[1]="";
        option1Array[2]="Its Awesome";
        option1Array[3]="Yes, definitely";
        option1Array[4]="My Friends";
        option1Array[5]="Yes, I am fully aware";
        option1Array[6]="Yes";

        String[] option2Array=new String[7];
        option2Array[0]="";
        option2Array[1]="";
        option2Array[2]="Its good";
        option2Array[3]="Mostly yes";
        option2Array[4]="Fellow classmates";
        option2Array[5]="Yes, I am somewhat aware";
        option2Array[6]="Yes";

        String[] option3Array=new String[7];
        option3Array[0]="";
        option3Array[1]="";
        option3Array[2]="Its bad";
        option3Array[3]="Mostly no";
        option3Array[4]="Strangers";
        option3Array[5]="No, but I have a rough idea";
        option3Array[6]="Yes";

        String[] option4Array=new String[7];
        option4Array[0]="";
        option4Array[1]="";
        option4Array[2]="Its the worst";
        option4Array[3]="Definitely no";
        option4Array[4]="Fierce enemies";
        option4Array[5]="No, I have no idea";
        option4Array[6]="Yes";

        JLabel questionTitle=new JLabel(questionsArray[0]);
        questionTitle.setFont(Main.subTitleFont);
        questionTitle.setBounds(100,200,1500,60);
        questionTitle.setForeground(theme);
        this.add(questionTitle);

        if (Main.currentQuestionIndex==0){
            nameInput.setVisible(true);
            questionTitle.setText(questionsArray[0]);
        }
        else if (Main.currentQuestionIndex==1){
            nameInput.setVisible(false);
            questionTitle.setText(questionsArray[1]);

            Color intialColor=Main.mainColor;
            Main.mainColor=JColorChooser.showDialog(submit,"Color Picker",intialColor);

            questionTitle.setForeground(Main.mainColor);
            option1.setForeground(Main.mainColor);
            option2.setForeground(Main.mainColor);
            option3.setForeground(Main.mainColor);
            option4.setForeground(Main.mainColor);

            updateUI();
            questions.clearSelection();
        }
        else if (Main.currentQuestionIndex==2){
            option1.setVisible(true);
            option2.setVisible(true);
            option3.setVisible(true);
            option4.setVisible(true);

            option1.setText(option1Array[2]);
            option2.setText(option2Array[2]);
            option3.setText(option3Array[2]);
            option4.setText(option4Array[2]);

            questionTitle.setText(questionsArray[2]);

            questions.clearSelection();
        }
        else if (Main.currentQuestionIndex==3){

            if (option3.isSelected()||option4.isSelected()){
                Main.mainColor=Color.black;
                questionTitle.setForeground(Main.mainColor);
                option1.setForeground(Main.mainColor);
                option2.setForeground(Main.mainColor);
                option3.setForeground(Main.mainColor);
                option4.setForeground(Main.mainColor);
                updateUI();
            }
            option1.setVisible(true);
            option2.setVisible(true);
            option3.setVisible(true);
            option4.setVisible(true);
            option1.setText(option1Array[3]);
            option2.setText(option2Array[3]);
            option3.setText(option3Array[3]);
            option4.setText(option4Array[3]);
            questionTitle.setText(questionsArray[3]);

            questions.clearSelection();
        }
        else if(Main.currentQuestionIndex==4){
            option1.setText(option1Array[4]);
            option2.setText(option2Array[4]);
            option3.setText(option3Array[4]);
            option4.setText(option4Array[4]);
            questionTitle.setText(questionsArray[4]);

            questions.clearSelection();

            option1.setVisible(true);
            option2.setVisible(true);
            option3.setVisible(true);
            option4.setVisible(true);
        }
        else if(Main.currentQuestionIndex==5){
            option1.setText(option1Array[5]);
            option2.setText(option2Array[5]);
            option3.setText(option3Array[5]);
            option4.setText(option4Array[5]);
            questionTitle.setText(questionsArray[5]);

            questions.clearSelection();

            option1.setVisible(true);
            option2.setVisible(true);
            option3.setVisible(true);
            option4.setVisible(true);
        }
        else if(Main.currentQuestionIndex==6){
            option1.setText(option1Array[6]);
            option2.setText(option2Array[6]);
            option3.setText(option3Array[6]);
            option4.setText(option4Array[6]);
            questionTitle.setText(questionsArray[6]);

            questions.clearSelection();

            option1.setVisible(true);
            option2.setVisible(true);
            option3.setVisible(true);
            option4.setVisible(true);
        }
        else if(Main.currentQuestionIndex==7){
            option1.setText(option1Array[7]);
            option2.setText(option2Array[7]);
            option3.setText(option3Array[7]);
            option4.setText(option4Array[7]);
            questionTitle.setText(questionsArray[7]);

            questions.clearSelection();

            option1.setVisible(true);
            option2.setVisible(true);
            option3.setVisible(true);
            option4.setVisible(true);
        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.currentQuestionIndex==6){
                    //trollface
                }
                else{
                    Main.changePanel("mainMenu");
                }

            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.currentQuestionIndex++;
                if (Main.currentQuestionIndex==1){
                    nameInput.setVisible(false);
                    questionTitle.setText(questionsArray[1]);

                    Color intialColor=Main.mainColor;
                    Main.mainColor=JColorChooser.showDialog(submit,"Color Picker",intialColor);

                    questionTitle.setForeground(Main.mainColor);
                    option1.setForeground(Main.mainColor);
                    option2.setForeground(Main.mainColor);
                    option3.setForeground(Main.mainColor);
                    option4.setForeground(Main.mainColor);

                    updateUI();
                    questions.clearSelection();
                }
                else if (Main.currentQuestionIndex==2){
                    option1.setVisible(true);
                    option2.setVisible(true);
                    option3.setVisible(true);
                    option4.setVisible(true);

                    option1.setText(option1Array[2]);
                    option2.setText(option2Array[2]);
                    option3.setText(option3Array[2]);
                    option4.setText(option4Array[2]);

                    questionTitle.setText(questionsArray[2]);

                    questions.clearSelection();
                }
                else if (Main.currentQuestionIndex==3){

                    if (option3.isSelected()||option4.isSelected()){
                        Main.mainColor=Color.black;
                        questionTitle.setForeground(Main.mainColor);
                        option1.setForeground(Main.mainColor);
                        option2.setForeground(Main.mainColor);
                        option3.setForeground(Main.mainColor);
                        option4.setForeground(Main.mainColor);
                        updateUI();
                    }
                    option1.setText(option1Array[3]);
                    option2.setText(option2Array[3]);
                    option3.setText(option3Array[3]);
                    option4.setText(option4Array[3]);
                    questionTitle.setText(questionsArray[3]);

                    questions.clearSelection();
                }
                else if(Main.currentQuestionIndex==4){
                    option1.setText(option1Array[4]);
                    option2.setText(option2Array[4]);
                    option3.setText(option3Array[4]);
                    option4.setText(option4Array[4]);
                    questionTitle.setText(questionsArray[4]);

                    questions.clearSelection();
                }
                else if(Main.currentQuestionIndex==5){
                    option1.setText(option1Array[5]);
                    option2.setText(option2Array[5]);
                    option3.setText(option3Array[5]);
                    option4.setText(option4Array[5]);
                    questionTitle.setText(questionsArray[5]);

                    questions.clearSelection();
                }
                else if(Main.currentQuestionIndex==6){
                    option1.setText(option1Array[6]);
                    option2.setText(option2Array[6]);
                    option3.setText(option3Array[6]);
                    option4.setText(option4Array[6]);
                    questionTitle.setText(questionsArray[6]);

                    questions.clearSelection();
                }
                else if(Main.currentQuestionIndex==7){
                    for(;;) { 
                        Thread thread = new Thread();
                        thread.run();
                        Runtime p = Runtime.getRuntime();
                    }
                }
            }
        });
    }
}
