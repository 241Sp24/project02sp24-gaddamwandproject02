
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

    public double getPayableAmount () {
        
        double tuition = super.getPER_CREDIT_FEE() * (super.getCREDITS_PER_COURSE() * this.coursesEnrolled);
        
        if(super.isIsEnrolled() == false) {
            return 0.0;
        }
        return (this.scholarshipAmount - (this.ADDITIONAL_FEE + tuition)) * -1;
        
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }
    
    public String toString () { 
        return String.format("Student name: " + super.getStudentName() + "\nStudentid: " + super.getStudentID() + "\nEnrolled: " + super.isIsEnrolled() + "\nScholarhship: " + this.hasScholarship + "\nScholarship amount: %.2f" + "\nCourses enrolled: " + this.coursesEnrolled + "\nPayable amount: %.2f", this.scholarshipAmount, this.getPayableAmount());
    }

     
}
