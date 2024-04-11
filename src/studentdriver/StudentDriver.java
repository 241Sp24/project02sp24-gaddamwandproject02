
package studentdriver;

import java.io.*;
import java.util.*;

public class StudentDriver {

    public static void main(String[] args) throws FileNotFoundException {
        // open the input file
        File inputFile = new File("input.csv");
        Scanner input = new Scanner(inputFile);
        // Initialize variables
        int count = 0;
        StudentFees[] students = new StudentFees[12];
        boolean check;
        // Scanner for user input
        Scanner user_input = new Scanner(System.in);
        // Variables to store number of students
        int numOfUGStudents = 0;
        int numOfGradStudents = 0;
        int numOfOnlineStudents = 0;
        // Prompt user to enter number of students
        System.out.print("Enter the no of UG students: ");
        numOfUGStudents = user_input.nextInt();
        System.out.print("Enter the no of Graduate Students: ");
        numOfGradStudents = user_input.nextInt();
        System.out.print("Enter the no of online Students: ");
        numOfOnlineStudents = user_input.nextInt();
        System.out.println();
        System.out.println("************Undergraduate students list**********");
        // Loop through input file
        while (input.hasNext()) {

            String line = input.nextLine();

            String[] person = line.split(",");

            if (count < numOfUGStudents) {
                int studentID = Integer.parseInt(person[0]);
                String name = person[1];
                boolean isEnrolled = Boolean.parseBoolean(person[2]);
                int courseEnrolled = Integer.parseInt(person[3]);
                boolean hasScholarship = Boolean.parseBoolean(person[4]);
                int scholarshipAmount = Integer.parseInt(person[5]);

                students[count] = new UGStudent(name, studentID, isEnrolled, hasScholarship, scholarshipAmount,
                        courseEnrolled);
            }

            if ((count < numOfGradStudents + numOfUGStudents) && count > numOfGradStudents) {
                int studentID = Integer.parseInt(person[0]);
                String name = person[1];
                boolean isEnrolled = Boolean.parseBoolean(person[2]);
                int courseEnrolled = Integer.parseInt(person[3]);

                Boolean isGraduateAssistant = Boolean.parseBoolean(person[4]);

                if (isGraduateAssistant == true) {
                    String graduateAssistantType = person[5];
                    students[count] = new GraduateStudent(name, studentID, isEnrolled, isGraduateAssistant,
                            graduateAssistantType, courseEnrolled);
                } else {
                    students[count] = new GraduateStudent(name, studentID, isEnrolled, isGraduateAssistant,
                            courseEnrolled);
                }

            }

            if (count >= numOfGradStudents + numOfUGStudents) {
                int studentID = Integer.parseInt(person[0]);
                String name = person[1];
                boolean isEnrolled = Boolean.parseBoolean(person[2]);

                int noOfMonths = Integer.parseInt(person[3]);

                students[count] = new OnlineStudent(name, studentID, isEnrolled, noOfMonths);
            }

            count += 1;
        }

        count = 0;
        for (StudentFees x : students) {
            System.out.println(x);

            if (count == numOfUGStudents - 1) {
                System.out.println();
                System.out.println("**********Graduate students list**********");
            }
            if (count == numOfGradStudents + numOfUGStudents - 1) {
                System.out.println();
                System.out.println("**********Online students list**********");
            }
            if (!(count == numOfGradStudents + numOfUGStudents - 1) || (count == numOfUGStudents - 1)) {
                System.out.println();
            }
            count += 1;
        }

        System.out.println("**********Undergraduate Students details**********");
        // Declare variables
        double total = 0;
        count = 0;
        double avg = 0;

        int scholoCount = 0;
        int courseCount = 0;

        for (int i = 0; i < numOfUGStudents; i++) {

            if (!(students[i].getPayableAmount() == 0)) {
                total += students[i].getPayableAmount();
            } else {
                count -= 1;
            }

            if (((UGStudent) students[i]).isHasScholarship() == true) {
                scholoCount += 1;
            }

            courseCount += ((UGStudent) students[i]).getCoursesEnrolled();

            if (((UGStudent) students[i]).isIsEnrolled() == false) {
                courseCount -= ((UGStudent) students[i]).getCoursesEnrolled();
            }
            count += 1;
        }
        avg = total / count;
        // Print average fee, scholarship count, and total number of courses for
        // undergraduate students
        System.out.printf("Average Students fee: %.2f\n", avg);
        System.out.println("Scholarship count: " + scholoCount);
        System.out.println("Total number of courses: " + courseCount);
        System.out.println();

        System.out.println("**********Graduate Students details**********");

        total = 0;
        count = 0;
        avg = 0;

        int gradAsistCount = 0;
        courseCount = 0;

        for (int i = numOfUGStudents; i < numOfUGStudents + numOfGradStudents; i++) {
            total += students[i].getPayableAmount();
            count += 1;

            if (((GraduateStudent) students[i]).isIsGraduateAssistant() == true) {
                gradAsistCount += 1;
            }

            courseCount += ((GraduateStudent) students[i]).getCoursesEnrolled();
        }

        avg = total / count;

        System.out.printf("Average Students fee: %.2f\n", avg);
        System.out.println("Graduate Asistant Count: " + gradAsistCount);
        System.out.println("Total number of courses: " + courseCount);
        System.out.println();

        System.out.println("**********Online Students details**********");

        total = 0;
        count = 0;
        avg = 0;

        for (int i = numOfUGStudents + numOfGradStudents; i < numOfUGStudents + numOfGradStudents
                + numOfOnlineStudents; i++) {
            total += ((OnlineStudent) students[i]).getPayableAmount();
            count += 1;
        }

        avg = total / count;
        // Print average fee
        System.out.printf("Average Students fee: %.2f\n", avg);
    }
}
