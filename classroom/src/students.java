public class students {
    String email;
    String dept_name;
    String course;
    String semester;
    String name;
    String father_name;
    String phone; ;
    String address;
    String photo;
    public students(String email, String dept_name, String course, String semester, String name, String father_name, String phone, String address, String photo)
    {
        this.name = name;
        this.father_name = father_name;
        this.phone = phone;
        this.address = address;
        this.course = course;
        this.dept_name = dept_name;
        this.email = email;
        this.photo = photo;
        this.semester=semester;
    }           
}