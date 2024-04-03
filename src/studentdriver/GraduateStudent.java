
package studentdriver;

public class GraduateStudent extends StudentFees {
    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private double ADDITIONAL_FEES = 654.45;
    
    public GraduateStudent (String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, String graduateAssistantType, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
        this.coursesEnrolled = coursesEnrolled;       
    }

    public GraduateStudent (String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        
        this.isGraduateAssistant = isGraduateAssistant;
        this.coursesEnrolled = coursesEnrolled; 
    }
    
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public boolean isIsGraduateAssistant() {
        return isGraduateAssistant;
    }
    
    public double getPayableAmount () { //fiqure how to make the tuition fee and additional fee here
        double tuition = super.getPER_CREDIT_FEE() * (super.getCREDITS_PER_COURSE() * this.coursesEnrolled);
        
        if (this.isGraduateAssistant == true) {
            if (this.graduateAssistantType.equals("full")) {
                return this.ADDITIONAL_FEES * 100.00 / 100.00;
            }
            else if (this.graduateAssistantType.equals("half")) {
                return (this.ADDITIONAL_FEES + (tuition / 2)) * 100.00 / 100.00;
            }
        }
               
        return (this.ADDITIONAL_FEES + tuition) * 100.00 / 100.00;
    }
    
    public String toString () { 
        return "Student name: " + super.getStudentName() + "\nStudentid: " + super.getStudentID() + "\nEnrolled: " + super.isIsEnrolled() + "\nGraduate assistant: " + this.isGraduateAssistant + "\nGraduate assistant type: " + this.graduateAssistantType + "\nCourses enrolled: " + this.coursesEnrolled + "\nPayable amount: " + this.getPayableAmount();
    }
    
    
}
