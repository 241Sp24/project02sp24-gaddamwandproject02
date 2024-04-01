
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
    
    public double getPayableAmount () { //finish later at end
        return 0.0;
    }
    
    public String toString () { //finish later at end
        return "";
    }
    
    
}