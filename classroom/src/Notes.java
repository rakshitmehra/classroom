public class Notes
{
    String course;
    String semester;
    String notes_id;
    String teacher_id;
    String topic;
    String details;
    String date;
    String type;
    String path;
    Notes( String notes_id, String semester, String course, String teacher_id, String topic, String details, String date, String type, String path) 
    {
        this.course=course;
        this.semester=semester;
        this.notes_id=notes_id;
        this.teacher_id=teacher_id;
        this.topic=topic;
        this.details=details;
        this.date=date;
        this.type=type;
        this.path=path;
    }
}