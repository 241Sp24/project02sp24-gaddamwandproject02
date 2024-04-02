
package studentdriver;

public class OnlineStudent extends StudentFees {
    private int noOfMonths;
    private double MONTHLY_FEE = 1245.25;
       
    public OnlineStudent (String studentName, int studentID, boolean isEnrolled, int noOfMonths) {
        super(studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
    }
    
    public double getPayableAmount() {
        return this.MONTHLY_FEE * this.noOfMonths;
    }
    
    public String toString () { //work on last
        return "";
    }
    
}
