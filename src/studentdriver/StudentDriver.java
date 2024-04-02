
package studentdriver;

import java.io.*;
import java.util.*;

public class StudentDriver {

    public static void main(String[] args) throws FileNotFoundException {
        
        File inputFile = new File("input.csv");
        Scanner input = new Scanner(inputFile);
        
        int count = 0;
        StudentFees[] students = new StudentFees[12];
        boolean check;
        
        while (input.hasNext()) {
            String line = input.nextLine();

            String[] person = line.split(","); //ask if we have to iterate and detemine wether lines of data is an instanceof class
            
            if (person[4].equals("true") || person[4].equals("false")) { //either UG or Grad student               
                check = isNum(person[5]);
                
                if (check == true) { //Undergraduate students
                    students[count] = new UGStudent(person[1], ((int) person[0]), person[2], person[4], (double) person[5], (int) person[3]);
                    //leave as error this will be correctly shortly
                }
                else{ //Graduate Students
                    
                }
              
                
            }
            else { //online students
                
            }
            
            count += 1;
        }
        
        
        //StudentFees[] students = new StudentFees[12];
    }
    
    public static boolean isNum (String line) { //checks if a string is a number or not
        
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int check = 0;
        
        for (int n = 0; n < numbers.length; n++) {
            check = line.indexOf(numbers[n]);
            if (check == -1) {
                return true;
            }
        }
        return false;
    }

}
