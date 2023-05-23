import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Wrong extends JFrame {

    public void Gowrong(String title){

        // total

        JFrame frame = new JFrame(title);
        frame.setSize(1100,880);
        frame.setBounds(0,0,1100,880); //set bound
        frame.setLocationRelativeTo(null);

        //top label
        JPanel container2 = new JPanel(); //get a container for label
        container2.setLayout(null);
        JLabel label = new JLabel("Wrong Equation"); // Add a title
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);  // make the title into top position

        //title
        JLabel label2 = new JLabel("Wrong Function list"); // Add a title
        label.setFont(new Font("Title",Font.BOLD|Font.ITALIC,50)); // set font
        label.setBounds(150,20,730,110);
        container2.add(label2); // add label into container

        // color and size
        container2.add(label); // add label into container
        container2.setBackground(Color.ORANGE);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // set way of close

// Wrong background

        JTextArea wrong = new JTextArea();
        wrong.setBounds(210,140,630,400);
        wrong.setBackground(Color.PINK);
        wrong.setEditable(false);
        container2.add(wrong);
        String text = "";




        // take the wrong function from the wronglist
        // combine them together and use \n to independent them
        for(int i = 0; i<Main.wronglist.size();i++){
            text += Main.wronglist.get(i)+"\n";
         }
         wrong.setText(text); //show all wrong function




        //button
        JButton test_again = new JButton("Test Again!"); // retake the test
        test_again.setBounds(390,660,260,90);
        test_again.setFont(new Font("button",Font.BOLD,30));
        container2.add(test_again);

        JLabel a = new JLabel("suggestion");
        a.setForeground(Color.CYAN);
        a.setFont(new Font("suggestion",Font.BOLD|Font.ITALIC,50));
        a.setBounds(410,570,200,80);

        // add suggestion through the wrong number
        switch(Main.wronglist.size()){
            case 0 :
                a.setText("Great!!!");
                wrong.setText("Congrats! You got full mark");
                wrong.setFont(new Font("Con",Font.BOLD,25));
                break; //可选
            case 4 :
                a.setText("do more!");
                break;
            case 5:
                a.setText("again!");
                break;
            default :
                a.setText("Good!");
        }
        container2.add(a);
        frame.add(container2);
        frame.setVisible(true); // make the frame visible

        test_again.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               Main.wronglist.clear(); //Clean the wronglist
                frame.dispose();// clean the Wrong frame
                new Frame().CreateJFrame("CSP Project"); // New a Frame
            }
        });




    }
}
