
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
            
            int studentID = Integer.parseInt(person[0]);
            String name = person[1];
            boolean isEnrolled = Boolean.parseBoolean(person[2]);
            
           
            if (person[4].equals("true") || person[4].equals("false")) { //either UG or Grad student               
                
                check = isNum(person[5]);
                int courseEnrolled = Integer.parseInt(person[3]);
                
                if (check == true) { //Undergraduate students
                    Boolean hasScholarship = Boolean.parseBoolean(person[4]);
                    int scholarshipAmount = Integer.parseInt(person[5]);

                    students[count] = new UGStudent(name, studentID, isEnrolled, hasScholarship, scholarshipAmount, courseEnrolled);                
                }
                else{ //Graduate Students
                    Boolean isGraduateAssistant = Boolean.parseBoolean(person[4]);
                    String graduateAssistantType = person[5];
                    
                    
                    if (isGraduateAssistant == true) {
                        students[count] = new GraduateStudent(name, studentID, isEnrolled, isGraduateAssistant, graduateAssistantType, courseEnrolled);
                    }
                    else {
                        students[count] = new GraduateStudent(name, studentID, isEnrolled, isGraduateAssistant, courseEnrolled);
                    }
      
                }

            }
            else { //online students
                int noOfMonths = Integer.parseInt(person[3]);
                
                students[count] = new OnlineStudent(name, studentID, isEnrolled, noOfMonths);
            }
            
            count += 1;
        }
        
        
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
