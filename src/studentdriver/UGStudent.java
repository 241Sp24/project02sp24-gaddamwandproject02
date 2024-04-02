
package studentdriver;

public class UGStudent extends StudentFees {
    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    private double ADDITIONAL_FEE = 820.70;
    
    public UGStudent (String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, double scholarshipAmount, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        
        this.hasScholarship = hasScholarship;
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
        
    }
    
    
    
    public double getPayableAmount () { //check with teacher
        
        //ask teacher if this is how to getCredits per course
        double tuition = super.getPER_CREDIT_FEE() * (super.getCREDITS_PER_COURSE() * this.coursesEnrolled);
        return this.scholarshipAmount - (this.ADDITIONAL_FEE + tuition);
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public boolean isHasScholarhsip() {
        return hasScholarship;
    }
    
    public String toString () { //do at the end
        return " ";
    }
    
}
