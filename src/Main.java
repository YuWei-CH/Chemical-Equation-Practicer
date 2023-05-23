
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    // data set preparation
    public static ArrayList <String> questionlist = new ArrayList <>(); //storage all the question
    public static HashMap <Integer, String> answer1 = new HashMap <Integer, String>();//storage the answer for first user input
    public static HashMap <Integer, String> answer2 = new HashMap <Integer, String>();//storage the answer for second user input
    public static ArrayList <String> wronglist = new ArrayList <>();//storage the wrong equation

    // static area could be used in whole program
    static {

        // read the file
        File file = new File("/Users/user/Documents/APP 数据/IDEA/CSP Project/src/data.txt"); //location of all the chemical function
        BufferedReader reader = null;
        try {
            System.out.println("read question"); //test
            reader = new BufferedReader(new FileReader(file)); //define the reader which contain the function
            String tempString = null; // contain the String of the whole line program read form data file
            int line = 0; //line number, use as the Key for the Hash Map  in answer recording
            // Read once a line, until the reader meet the null value

           // reading process
            while ((tempString = reader.readLine()) != null) {
                // temp storage
                String temp_qusetion; // temp record the question
                String tempanswer1; // temp record the answer for user first input
                String tempanswer2; // temp record the answer for user second input

                System.out.println("line " + line + ": " + tempString + "    ***** 读取成功"); //show the content that program read form the data file
                // record question through Arraylist
                for (int n = 0; n < tempString.length(); n++) {
                    //find = to determine the first string part(question)
                    if (tempString.substring(n, n + 1).equals("=")) {
                        temp_qusetion = tempString.substring(0, n - 1); //  from first character to the character before =
                        questionlist.add(temp_qusetion); // add to the list
                        System.out.println(temp_qusetion); //test

                        // use Hash Map to record the answer
                        for (int m = n; m < tempString.length(); m++) {

                            // through the + to find the answer. string before the + is first answer , after + is second answer
                            if (tempString.substring(m, m + 1).equals("+")) {
                                tempanswer1 = tempString.substring(n+2, m - 1); // from character after = to the  character before +
                                tempanswer2 = tempString.substring(m + 2);  // from character after + to the whole string ending

                                // set Map with Key and Value
                                // key is relate to the variable line, and value is tempanswer that get from above String dividing
                                // both answer map have same  variable line for same group of answer, we can get answer form same key value
                                answer1.put(line, tempanswer1);
                                System.out.println(tempanswer1 +"--------1 answer ");
                                answer2.put(line, tempanswer2);
                                System.out.println(tempanswer2 +"--------2 answer");

                            }

                        }
                    }
                }
                line++; // update the line value to continue the loop
            }
            reader.close(); // stop file reading
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

    }



// run the program

        public static void main (String[]args){
            // write your code here

            new Frame().CreateJFrame("CSP Project"); // run the Frame
        }

}
