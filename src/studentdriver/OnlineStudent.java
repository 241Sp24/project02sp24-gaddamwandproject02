
package studentdriver;

public class OnlineStudent extends StudentFees {
    private int noOfMonths;
    private double MONTHLY_FEE = 1245.25;
       
    public OnlineStudent (String studentName, int studentID, boolean isEnrolled, int noOfMonths) {
        super(studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
    }
    
    public double getPayableAmount() {
        return (this.MONTHLY_FEE * this.noOfMonths) * 100.00 / 100.00;
    }
    
    public String toString () { 
        return "Student name: " + super.getStudentName() + "\nStudentid: " + super.getStudentID() + "\nEnrolled: " + super.isIsEnrolled() + "\nNo of months: " + this.noOfMonths + "\nPayable amount: " + this.getPayableAmount();
    }
    
}
