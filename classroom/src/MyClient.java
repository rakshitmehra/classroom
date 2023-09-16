import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.io.File;
public class MyClient 
{
    public static String signup(String username, String email,String password, String phone, File photo)
    {
        try 
        {
            HttpResponse<String> res = Unirest.post("http://localhost:9000/signup")
                .queryString("username", username)
                .queryString("email", email)
                .queryString("password", password)
                .queryString("phone", phone)
                .field("photo", photo)
                .asString();
        
            if(res.getStatus() == 200)
            {
                return res.getBody();
            }
            else
            {
                return "Server Error";
            }
        
        } 
        catch (Exception e) 
        {
        return e.toString();
        }
    }
    public static String login(String username, String password)
    {
        HttpResponse<String> res;
        try {
            res = Unirest.get( "http://localhost:9000/adminlogin")
                    .queryString("username", username)
                    .queryString("password", password)
                    .asString();
            if(res.getStatus() == 200)
            {
                return res.getBody();
            }
            else
            {
                return "Login failed";
            }
        }
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String addDepartment(String name, String description)
    {
        HttpResponse<String> res;
        try{
            res = Unirest.get( "http://localhost:9000/adddepartment")
                    .queryString("name", name)
                    .queryString("description", description)
                    .asString();
            if(res.getStatus() == 200)
            {
                return res.getBody();
            }
            else
            {
                return "Login failed";
            }
        }
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String fetchdept()
    {
        try {
                HttpResponse<String> res =  Unirest.get("http://localhost:9000/fetchdept").asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    }  
    public static String fetchdepartment()
    {
        try {
                HttpResponse<String> res =  Unirest.get("http://localhost:9000/fetchdepartment").asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    }  
    public static String deleteDepartment(String name) 
    {
        HttpResponse<String> res;
        try 
        {
            res = Unirest.get("http://localhost:9000/deletedept")
                .queryString("name", name)
                .asString();
            if (res.getStatus() == 200) 
            {
                return res.getBody();
            } 
            else {
            return "Invalid";
            }
        } 
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String addCourse(String name, String dept_name, String semester, String description) {
    try {
        HttpResponse<String> res = Unirest.get("http://localhost:9000/addcourse")
                .queryString("name", name)
                .queryString("dept_name", dept_name)
                .queryString("semester", semester)
                .queryString("description", description)
                .asString();

        if (res.getStatus() == 200) {
            return res.getBody();
        } else {
            return "Failed";
        }
    } catch (Exception e) {
        return e.toString();
    }
}

    public static String fetchcourse(String department)
    {
        try {
                HttpResponse<String> res =  Unirest.get("http://localhost:9000/fetchcourse")
                        .queryString("department", department)
                        .asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    }  
    public static String deleteCourse(int id) 
    {
        HttpResponse<String> res;
        try 
        {
            res = Unirest.get("http://localhost:9000/deletecourse")
                .queryString("id", id)
                .asString();
            if (res.getStatus() == 200) 
            {
                return res.getBody();
            } 
            else {
            return "Invalid";
            }
        } 
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String addFaculty(String name, String father_name, String mobile, String address, String qualification, String department,String email, File photo)
    {
        try 
        {
            HttpResponse<String> res = Unirest.post("http://localhost:9000/addfaculty")
                .queryString("name", name)
                .queryString("father_name", father_name)
                .queryString("mobile", mobile)
                .queryString("address", address)    
                .queryString("qualification", qualification)
                .queryString("email", email)    
                .queryString("department", department)
                .field("photo", photo)
                .asString();
        
            if(res.getStatus() == 200)
            {
                return res.getBody();
            }
            else
            {
                return "Server Error";
            }
        
        } 
        
        catch (Exception e) 
        {
           return e.toString();
        }
    }
    public static String fetchfaculty(String department)
    {
        try {
                HttpResponse<String> res =  Unirest.get("http://localhost:9000/fetchfaculty")
                        .queryString("department", department)
                        .asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    }  
    public static String deleteFaculty(String email)
    {
        HttpResponse<String> res;
        try 
        {
            res = Unirest.get("http://localhost:9000/deletefaculty")
                .queryString("email", email)
                .asString();
            if (res.getStatus() == 200) 
            {
                return res.getBody();
            } 
            else {
                return "Invalid";
            }
        } 
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String fetchcourses2(String department)
    {
        try {
                HttpResponse<String> res =  Unirest.get("http://localhost:9000/fetchcourses2")
                    .queryString("department", department)    
                    .asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    }  
    public static String addStudent(String email, String dept_name, String course, String semester, String name, String father_name, String phone, String address, File photo)
    {
        try 
        {
            HttpResponse<String> res = Unirest.post("http://localhost:9000/addStudent")
                .queryString("email", email)
                .queryString("dept_name", dept_name)
                .queryString("course",course)
                .queryString("semester", semester)     
                .queryString("name", name)
                .queryString("father_name", father_name)
                .queryString("phone", phone)
                .queryString("address", address)    
                .field("photo", photo)
                .asString();
        
            if(res.getStatus() == 200)
            {
                return res.getBody();
            }
            else
            {
                return "Server Error";
            }
        
        }         
        catch (Exception e) 
        {
           return e.toString();
        }
    }
    public static String fetchStudent(String department)
    {
        try {
                HttpResponse<String> res =  Unirest.get("http://localhost:9000/fetchStudents")
                        .queryString("department", department)
                        .asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    }
    public static String deleteStudent(String email)
    {
        HttpResponse<String> res;
        try 
        {
            res = Unirest.get("http://localhost:9000/deleteStudent")
                .queryString("email", email)
                .asString();
            if (res.getStatus() == 200) 
            {
                return res.getBody();
            } 
            else {
            return "Invalid";
            }
        } 
        catch (Exception e) 
        {
            return e.toString();
        }
    }    
    public static String facultyLogin(String email)
    {
        HttpResponse<String> res;
        try {
            res = Unirest.get( "http://localhost:9000/facultylogin")
                    .queryString("email", email)
                    .asString();
            if(res.getStatus() == 200)
            {
                return res.getBody();
            }
            else
            {
                return "Login failed";
            }
        }
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String fetchfacultydata(String email)
    {
        try {
                HttpResponse<String> res =  Unirest.get("http://localhost:9000/fetchfacultydata")
                        .queryString("email",email)
                        .asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    }  
    public static String fetchcourses3()
    {
        try {
                HttpResponse<String> res =  Unirest.get("http://localhost:9000/fetchcourses3").asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    }  
    public static String fetchSemester(String course)
    {
        try {
                HttpResponse<String> res =  Unirest.get("http://localhost:9000/fetchsemester")
                    .queryString("course", course)    
                    .asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    }  
    public static String addNotes(String semester, String course, String email, String title, String detail, String datetime, String type, File file)
    {
        try {
                HttpResponse<String> res =  Unirest.post("http://localhost:9000/addnotes")
                        .queryString("semester", semester)
                        .queryString("course", course)
                        .queryString("email", email)
                        .queryString("title", title)
                        .queryString("detail", detail)
                        .queryString("datetime", datetime)
                        .queryString("type", type)
                        .field("file", file)
                        .asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    }  
    public static String fetchNotes(String Course, String Semester) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/fetchnotes")
                .queryString("Course", Course)
                .queryString("Semester", Semester)
                .asString();
            System.out.println("Response status: " + res.getStatus());
            System.out.println("Response body: " + res.getBody());
            if (res.getStatus() == 200) {
                return res.getBody();
            } 
            else {
                return "Server Error";
            }
        } 
        catch (Exception e) {
            return e.toString();
        }
    }
    public static String studentLogin(String email)
    {
        HttpResponse<String> res;
        try {
            res = Unirest.get( "http://localhost:9000/studentlogin")
                    .queryString("email", email)
                    .asString();
            if(res.getStatus() == 200)
            {
                return res.getBody();
            }
            else
            {
                return "Login failed";
            }
        }
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String fetchStudentInfo(String email)
    {
        try
        {
            HttpResponse<String> res= Unirest.get("http://localhost:9000/fetchstudentinfo")
                    .queryString("email",email)
                    .asString();
            if(res.getStatus()==200)
            {
                return res.getBody();
            }
            else
            {
                return "server error";
            }
        }
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String uploadTimeTable(String course, String semester, String teacher_email, File file)
    {
        try {
                HttpResponse<String> res =  Unirest.post("http://localhost:9000/uploadtimetable")
                        .queryString("semester", semester)
                        .queryString("course", course)
                        .queryString("teacher_email", teacher_email)
                        .field("file", file)
                        .asString();
                if(res.getStatus() == 200)
                {
                    return res.getBody();
                }
                else
                {
                    return "Server Error";
                }
        } 
        catch (Exception e)
        {
            return e.toString();
        }
    } 
    public static String fetchTimeTable(String Course, String Semester) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/fetchtimetable")
                .queryString("Course", Course)
                .queryString("Semester", Semester)
                .asString();
            if (res.getStatus() == 200) {
                return res.getBody();
            } 
            else {
                return "Server Error";
            }
        } 
        catch (Exception e) {
            return e.toString();
        }
    }

    public static String addAssignment(String t_email, String title, String detail, String datetime, String course, String semester, String lastdate, File file) {
        try {
                HttpResponse<String> res = Unirest.post("http://localhost:9000/addassignment")
                .queryString("t_email", t_email)
                .queryString("title", title)
                .queryString("detail", detail)
                .queryString("datetime", datetime)
                .queryString("course", course)
                .queryString("semester", semester)
                .queryString("lastdate", lastdate)
                .field("file", file)
                .asString();

            if (res.getStatus() == 200) 
            {
                return res.getBody();
            } 
            else {
                return "Server Error";
            }
        }
        catch (Exception e) {
            return e.toString();
        }
    }
    public static String fetchAssignment(String Course, String Semester) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/fetchassignment")
                .queryString("Course", Course)
                .queryString("Semester", Semester)
                .asString();
            if (res.getStatus() == 200) {
                return res.getBody();
            } 
            else {
                return "Server Error";
            }
        } 
        catch (Exception e) {
            return e.toString();
        }
    }
    public static String question(String email,String question, String department)
    {
        try
        {
            HttpResponse<String> res= Unirest.get("http://localhost:9000/question")
                    
                    .queryString("email",email)
                    .queryString("question",question)
                    .queryString("department", department)
                    .asString();
            if(res.getStatus()==200)
            {
                return res.getBody();
            }
            else
            {
                return "server error";
            }
        }
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String viewQuestion()
    {
        try
        {
            HttpResponse<String> res= Unirest.get("http://localhost:9000/view_question")
                    .asString();
            if(res.getStatus()==200)
            {
                return res.getBody();
            }
            else
            {
                return "server error";
            }
        }
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String postAnswer(String teacher_email,String department,String chat_id,String answer)
    {
        try
        {
        HttpResponse<String> res=Unirest.get("http://localhost:9000/postAnswer")
                .queryString("teacher_email",teacher_email)
                .queryString("department",department)
                .queryString("chat_id",chat_id)
                .queryString("answer",answer)
                        .asString();
                    
            
                    if(res.getStatus()==200)
                    {
                        return res.getBody();
                    }
                    else
                    {
                        return "Server Error";
                    }
        } 
        catch (Exception e)       
        {
            return e.toString();
        }       
    }
    public static String submitAssignment(String assignment_id, String student_email, String dateOfSubmit, File file)
    {
        try
        {
            HttpResponse<String> res= Unirest.post("http://localhost:9000/submit_assignment")
                    .queryString("assignment_id",assignment_id)
                    .queryString("student_email",student_email)
                    .queryString("dateOfSubmit",dateOfSubmit)
                    .field("file",file)
                    .asString();
            //System.out.println(res.getStatus());
            if(res.getStatus()==200)
            {
                return res.getBody();
            }
            else
            {
                return "server error";
            }
        }
        catch (Exception e) 
        {
            return e.toString();
        }
    }
    public static String fetchAssignmentAnswer(String email) {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/fetch_ass_answer")
                .queryString("email", email)
                .asString();
//            System.out.println("Response status: " + res.getStatus());
//            System.out.println("Response body: " + res.getBody());
            if (res.getStatus() == 200) {
                return res.getBody();
            } 
            else {
                return "Server Error";
            }
        } 
        catch (Exception e) {
            return e.toString();
        }
    }
    public static String fetchSubmittedAssignment() {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/fetch_ass_submitted")
            .asString();
//            System.out.println("Response status: " + res.getStatus());
//            System.out.println("Response body: " + res.getBody());
            if (res.getStatus() == 200) {
                return res.getBody();
            } 
            else {
                return "Server Error";
            }
        } 
        catch (Exception e) {
            return e.toString();
        }
    }
    public static String checkAssignment(String id, String remarks)
    {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/checkAssignment")
                .queryString("id", id)    
                .queryString("remarks", remarks)
                .asString();
//            System.out.println("Response status: " + res.getStatus());
//            System.out.println("Response body: " + res.getBody());
            if (res.getStatus() == 200) {
                return res.getBody();
            } 
            else {
                return "Server Error";
            }
        } 
        catch (Exception e) {
            return e.toString();
        }
    }
    public static String markAttendance(String student_email,String date_of_attendance,String status,String course, String semester)
    {
        try
        {
        HttpResponse<String> res=Unirest.get("http://localhost:9000/mark_attendance")
                .queryString("student_email",student_email)
                .queryString("date_of_attendance",date_of_attendance)
                .queryString("status",status)
                .queryString("course", course)
                .queryString("semester", semester)
                        .asString();
                    
            
                    if(res.getStatus()==200)
                    {
                        return res.getBody();
                    }
                    else
                    {
                        return "Server Error";
                    }
        } 
        catch (Exception e)       
        {
            return e.toString();
        }       
    }
    public static String FetchStudent(String course,String semester)
    {
        try
        {
        HttpResponse<String> res=Unirest.get("http://localhost:9000/FetchStudent")
                .queryString("course",course)
                .queryString ("semester",semester).asString();           
                    if(res.getStatus()==200)
                    {
                        return res.getBody();
                    }
                    else
                    {
                        return "Server Error";
                    }
        } 
        catch (Exception e)
        
        {
            return e.toString();
        }
        
    }
    public static String checkAttendance(String course, String semester)
    {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/check_attendance")
                .queryString("course", course)
                .queryString("semester", semester)
                .asString();
//            System.out.println("Response status: " + res.getStatus());
//            System.out.println("Response body: " + res.getBody());
            if (res.getStatus() == 200) {
                return res.getBody();
            } 
            else {
                return "Server Error";
            }
        } 
        catch (Exception e) {
            return e.toString();
        }
    }
}
