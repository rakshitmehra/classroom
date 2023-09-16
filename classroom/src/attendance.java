public class attendance {
    String id;
    String student_email;
    String date_of_attendance;
    String status;
    String course;
    String semester;
    attendance(String id, String student_email,String date_of_attendance,String status,String course, String semester)
    {
        this.id=id;
        this.student_email=student_email;
        this.date_of_attendance=date_of_attendance;
        this.status=status;
        this.course=course;
        this.semester=semester;
    }        
}
