

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.*;
public class Frame extends JFrame {

    // temp variable for under loop
    int counter = 0;
    int totalscore = 0;


    public String submiting(String a0, String a1){
        // compare the all the input with right answer
        // right
        
        while(Main.answer1.get(counter).equals(a0) || Main.answer2.get(counter).equals(a1)) {
           return "right";
        }
        // false
            return "false";


        // determine whether the test should stop
    }
    public void CreateJFrame(String title) {

        // create the Frame
        Main m = new Main();


//************   Frame page     **************//
        // page began

        // background
        JFrame frame = new JFrame(title);
        frame.setSize(1000, 900);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // set way of close

        //top label
        JPanel container = new JPanel(); //get a container for label
        container.setLayout(null);
        // color and size
        container.setBackground(Color.ORANGE);

        // top title
        JLabel label = new JLabel("Chemical Equation Balance Training"); // Add a title
        label.setFont(new Font("Title", Font.BOLD | Font.ITALIC, 38)); // set font
        label.setBounds(130, 10, 730, 110);
        container.add(label); // add label into container

        // show right or false and total-score
        Font f = new Font("normal", Font.ITALIC, 25);
        JTextField status = new JTextField("Right/False");
        status.setFont(f); // set font
        status.setBounds(75, 130, 170, 60);
        status.setBackground(Color.YELLOW); //set background color
        status.setEditable(false);//text uneditable
        container.add(status);
        JTextField score = new JTextField("0 points");
        score.setBounds(775, 130, 170, 60);
        score.setBackground(Color.YELLOW); //set background color
        score.setEditable(false);//text uneditable
        score.setFont(f); // set font
        container.add(score);
        JTextField inform = new JTextField("right + 20 " + " && " + " false + 0 ");
        inform.setBounds(775, 200, 170, 60);
        inform.setBackground(Color.YELLOW); //set background color
        inform.setEditable(false);//text uneditable
        container.add(inform);

// text

        // question_area

        Font string = new Font("text", Font.BOLD, 30);
        JTextField question_area = new JTextField();
        question_area.setBounds(80, 320, 270, 90);
        question_area.setBackground(Color.LIGHT_GRAY); //set background color
        question_area.setFont(string);
        question_area.setEditable(false);//text uneditable
        question_area.setText(Main.questionlist.get(counter)); // traverse the questionlist and change at everytime submit button click
        container.add(question_area);


        // == area
        Font sign = new Font("sign", Font.BOLD, 50);
        JLabel equal_symbol = new JLabel(" = ");
        equal_symbol.setBounds(380, 320, 90, 90);
        equal_symbol.setFont(sign);
        container.add(equal_symbol);
        JLabel add_symbol2 = new JLabel(" + ");
        add_symbol2.setBounds(670, 320, 90, 90);
        add_symbol2.setFont(sign);
        container.add(add_symbol2);

        // user first-input area
        JTextField first_input = new JTextField("input1");
        first_input.setBounds(500, 320, 160, 90);
        first_input.setFont(string);
        container.add(first_input);

        // user second_input area
        JTextField second_input = new JTextField("input2");
        second_input.setBounds(770, 320, 160, 90);
        second_input.setFont(string);
        container.add(second_input);



        //button
        Font button = new Font("button", Font.BOLD | Font.ITALIC, 30);
        JButton submit = new JButton("submit");// submit the answer
        JButton WrongList = new JButton("WrongList"); // lead the user go to Wrong page
        JButton clean = new JButton("clean"); // clean all the user input
        submit.setFont(button);
        WrongList.setFont(button);
        clean.setFont(button);
        submit.setBounds(50, 600, 160, 90);
        WrongList.setBounds(750, 600, 190, 90);
        clean.setBounds(410, 600, 160, 90);
        container.add(submit);
        container.add(WrongList);
        container.add(clean);

        // page ending

        frame.add(container);
        frame.setVisible(true); // make the frame visible


// *********** logic binding ************  //
        // submit button

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String a0 = first_input.getText().trim(); // get first input
                String a1 = second_input.getText().trim(); //get second input
            if (submiting(a0, a1).equals("right")){
                status.setText("Right!"); // show F/R status
                totalscore += 20;
                score.setText(totalscore + " " + "points");
                System.out.println(totalscore); // test
            }
            else{
                status.setText("False!"); //show F/R status
                Main.wronglist.add(Main.questionlist.get(counter) + " = " + Main.answer1.get(counter) + " + " + Main.answer2.get(counter)); //add whole function to wrong list
                System.out.println("Wrong");//test
            }
                if (counter > Main.questionlist.size()) {
                    submit.setVisible(false);// submit disappear
                } else {
                    counter++; //increase counter to traver all the list above
                    question_area.setText(Main.questionlist.get(counter)); // refresh the question
                }

            }
        });

        // wrongList
        WrongList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();// clean the original frame
                new Wrong().Gowrong("Wrong Equation");// go to new Wrong frame

            }
        });

        //clean
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                first_input.setText(""); //empty text
                first_input.requestFocus();//  back mouse in first input
                second_input.setText("");//empty text
            }
        });

        }

    }

