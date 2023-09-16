import com.vmm.JHTTPServer;
import com.vmm.NanoHTTPD;
import static com.vmm.NanoHTTPD.HTTP_OK;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class My_Server extends JHTTPServer
{
    
    My_Server(int port) throws IOException
    {
        super(port);
    }

    @Override
    public NanoHTTPD.Response serve(String uri, String method, Properties header, Properties parms, Properties files) {     
        if(uri.equals("/signup"))
        {
            String username = parms.getProperty("username");
            String email = parms.getProperty("email");
            String password = parms.getProperty("password");
            String phone = parms.getProperty("phone");
            try 
            {
             ResultSet rs  = DBLoader.executeQuery("select * from users where email = '"+email+"'");
             if(rs.next())
             {
                 Response res = new Response(HTTP_OK, "text/plain", "exist");
                 return res;
             }
             else
             {
                 String photoname = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads/");
                 rs.moveToInsertRow();               
                 rs.updateString("username", username);
                  rs.updateString("email", email);
                   rs.updateString("password", password);
                    rs.updateString("phone", phone);
                     rs.updateString("photo", "src/uploads/"+photoname);
                     rs.insertRow();
                      Response res = new Response(HTTP_OK, "text/plain", "success");
                      return res;
             }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else if(uri.equals("/adminlogin")){
            String username = parms.getProperty("username");
            String password = parms.getProperty("password");
            
            try 
            {
                ResultSet rs = DBLoader.executeQuery("select * from adminlogin where username = '" + username + "' and password = '" + password + "'");
                if(rs.next())
                {
                    Response res = new Response(HTTP_OK, "text/plain", "success");
                    return res;
                }
                else{
                   Response res = new Response(HTTP_OK, "text/plain", "invalid");
                   return res;
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else if(uri.equals("/adddepartment"))
        {
            String name = parms.getProperty("name");
            String description = parms.getProperty("description");
            try 
            {
             ResultSet rs  = DBLoader.executeQuery("select * from department1 where name = '"+name+"'");
             if(rs.next())
             {
                 Response res = new Response(HTTP_OK, "text/plain", "exist");
                 return res;
             }
             else
             {
                rs.moveToInsertRow();               
                rs.updateString("name", name);
                rs.updateString("description", description);
                rs.insertRow();
                Response res = new Response(HTTP_OK, "text/plain", "success");
                return res;
             }
            }catch (Exception e) 
            {
            e.printStackTrace();
            }
        }
    else if(uri.equals("/fetchdept"))
    {
        String ans = " ";
        try {
            ResultSet rs  = DBLoader.executeQuery("select * from department1");
            while(rs.next())
            {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String row = name + "$"+ description;
                ans = ans + row + ";;";
            }
            return new Response(HTTP_OK, "text/plain", ans);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    else if(uri.equals("/fetchdepartment"))
    {
        String ans = " ";
        
        try {
            ResultSet rs  = DBLoader.executeQuery("select * from department1");
            while(rs.next())
            {
                String name = rs.getString("name");
                String row = name;
                ans = ans + row + ";;";
            }
            return new Response(HTTP_OK, "text/plain", ans);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    else if(uri.equals("/deletedept"))
    {   
        String name = parms.getProperty("name");
        try 
        {
            ResultSet rs  = DBLoader.executeQuery("select * from department1 where name = '"+name+"'");
            if(rs.next())
            {
                rs.deleteRow();
                Response res = new Response(HTTP_OK, "text/plain", "delete successful");
                return res;
            }
            {
                Response res = new Response(HTTP_OK, "text/plain", "delete unsuccesful");
                return res;
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }    
    else if(uri.equals("/addcourse"))
        {
            
            String name = parms.getProperty("name");
            String dept_name = parms.getProperty("dept_name");
            String semester = parms.getProperty("semester");
            String description = parms.getProperty("description");
            try 
            {
             ResultSet rs=DBLoader.executeQuery("select * from courses where name='"+name+"' and dept_name='"+dept_name+"'");
             if(rs.next())
             {
                 Response res = new Response(HTTP_OK, "text/plain", "exist");
                 return res;
             }
             else
             {
                rs.moveToInsertRow();               
                rs.updateString("name", name);
                rs.updateString("dept_name", dept_name);
                rs.updateString("semester", semester);
                rs.updateString("description", description);
                rs.insertRow();
                Response res = new Response(HTTP_OK, "text/plain", "success");
                return res;
             }
            }catch (Exception e) 
            {
            e.printStackTrace();
            }
        }
    else if(uri.equals("/fetchcourse"))
    {
        String ans = " ";
        try {
            String department = parms.getProperty("department");
        ResultSet rs  = DBLoader.executeQuery("select * from courses where dept_name = '"+department+"'");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept_name = rs.getString("dept_name");
                int semester = rs.getInt("semester");
                String description = rs.getString("description");
                String row = id + "$"+ dept_name + "$"+ name + "$"+ semester + "$"+ description;
                ans = ans + row + ";;";
            }
            return new Response(HTTP_OK, "text/plain", ans);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }  
    else if(uri.equals("/deletecourse"))
    {   
        int id = Integer.parseInt(parms.getProperty("id"));
        try 
        {
            ResultSet rs  = DBLoader.executeQuery("select * from courses where id = '"+id+"'");
            if(rs.next())
            {
                rs.deleteRow();
                Response res = new Response(HTTP_OK, "text/plain", "delete successful");
                return res;
            }
            {
                Response res = new Response(HTTP_OK, "text/plain", "delete unsuccesful");
                return res;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    else if(uri.equals("/addfaculty"))
        {
            String name = parms.getProperty("name");
            String father_name = parms.getProperty("father_name");
            String mobile = parms.getProperty("mobile");
            String address = parms.getProperty("address");
            String qualification = parms.getProperty("qualification");
            String department = parms.getProperty("department");
            String email = parms.getProperty("email");
            try 
            {
             ResultSet rs  = DBLoader.executeQuery("select * from faculty where email = '"+email+"'");
             if(rs.next())
             {
                 Response res = new Response(HTTP_OK, "text/plain", "exist");
                 return res;
             }
             else
             {
                String photoname = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads/");
                rs.moveToInsertRow();               
                rs.updateString("name", name);
                rs.updateString("father_name", father_name);
                rs.updateString("mobile", mobile);
                rs.updateString("address", address);
                rs.updateString("qualification", qualification);
                rs.updateString("department", department);
                rs.updateString("email", email);
                rs.updateString("photo", "src/uploads/"+photoname);
                rs.insertRow();
                Response res = new Response(HTTP_OK, "text/plain", "success");
                return res;
             }
            }catch (Exception e) 
            {
            e.printStackTrace();
            }
        }
        else if(uri.equals("/fetchfaculty"))
        {
            String ans = " ";
            try {
                String department = parms.getProperty("department");
                ResultSet rs  = DBLoader.executeQuery("select * from faculty where department = '"+department+"'");
                while(rs.next())
                {
                    String name = rs.getString("name");
                    String father_name = rs.getString("father_name");
                    String mobile = rs.getString("mobile");
                    String address = rs.getString("address");
                    String qualification = rs.getString("qualification");
                    String dept_name = rs.getString("department");
                    String email = rs.getString("email");
                    String photo = rs.getString("photo");
                    String row = name + "$"+ father_name + "$"+ mobile + "$"+ address + "$"+ qualification + "$" + dept_name + "$" + email + "$" + photo;
                    ans = ans + row + ";;";
                }
                return new Response(HTTP_OK, "text/plain", ans);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }  
        else if(uri.equals("/deletefaculty"))
        {   
            String email = parms.getProperty("email");
            try 
            {
                ResultSet rs  = DBLoader.executeQuery("select * from faculty where email = '"+email+"'");
                if(rs.next())
                {
                    rs.deleteRow();
                    Response res = new Response(HTTP_OK, "text/plain", "delete successful");
                    return res;
                }
                {
                    Response res = new Response(HTTP_OK, "text/plain", "delete unsuccesful");
                    return res;
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }  
        else if (uri.equals("/fetchcourses2"))
        {
            String ans = "";
            try {
                String dept_name = parms.getProperty("department");              
                ResultSet rs = DBLoader.executeQuery("select * from courses where dept_name = '"+dept_name+"'");
                while (rs.next()) 
                {
                    int id = rs.getInt("id");
                    String row = String.format("%d",id);  // Convert the int to String
                    ans = ans + row + ";;";
                }
                return new Response(HTTP_OK, "text/plain", ans);
            } 
            catch (Exception e) 
            {
                e.printStackTrace(); // Print the exception for debugging purposes
            }
        }
        else if(uri.equals("/addStudent"))
        {
            String email = parms.getProperty("email");
            String dept_name = parms.getProperty("dept_name");
            String course = parms.getProperty("course");
            String semester = parms.getProperty("semester");
            String name = parms.getProperty("name");
            String father_name = parms.getProperty("father_name");
            String phone = parms.getProperty("phone");
            String address = parms.getProperty("address");      
            try 
            {
             ResultSet rs  = DBLoader.executeQuery("select * from students where email ='"+email+"'");
             if(rs.next())
             {
                 Response res = new Response(HTTP_OK, "text/plain", "exist");
                 return res;
             }
             else
             {
                String photoname = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads/");
                rs.moveToInsertRow();          
                rs.updateString("email", email);
                rs.updateString("dept_name", dept_name);
                rs.updateString("course", course);
                rs.updateString("semester", semester);
                rs.updateString("name", name);
                rs.updateString("father_name", father_name);
                rs.updateString("phone", phone);
                rs.updateString("address", address);
                rs.updateString("photo", "src/uploads/"+photoname);
                rs.insertRow();
                Response res = new Response(HTTP_OK, "text/plain", "success");
                return res;
             }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else if(uri.equals("/fetchStudents"))
        {
            String ans = " ";
            try {
                String department = parms.getProperty("department");
                ResultSet rs  = DBLoader.executeQuery("select * from students where dept_name = '"+department+"'");
                while(rs.next())
                {
                    String email = rs.getString("email");
                    String dept_name = rs.getString("dept_name");
                    String course = rs.getString("course");
                    String semester = rs.getString("semester");
                    String name = rs.getString("name");
                    String father_name = rs.getString("father_name");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    String photo = rs.getString("photo");
                    String row = email + "$" + dept_name + "$" + course + "$" + semester + "$" + name + "$"+ father_name + "$"+ phone + "$"+ address + "$"+ photo;
                    ans = ans + row + ";;";
                }
                return new Response(HTTP_OK, "text/plain", ans);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(uri.equals("/deleteStudent"))
        {   
            String email = parms.getProperty("email");
            try 
            {
                ResultSet rs  = DBLoader.executeQuery("select * from students where email = '"+email+"'");
                if(rs.next())
                {
                    rs.deleteRow();
                    Response res = new Response(HTTP_OK, "text/plain", "delete successful");
                    return res;
                }
                {
                    Response res = new Response(HTTP_OK, "text/plain", "delete unsuccesful");
                    return res;
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else if(uri.equals("/facultylogin")){
            String email = parms.getProperty("email");
            try 
            {
                ResultSet rs = DBLoader.executeQuery("select * from faculty where email = '"+email+"'");
                if(rs.next())
                {   
                    int randomNum = (int)(1000+(9999-1000)*Math.random());
                    System.out.println(randomNum);
                    sendemail obj = new sendemail(email, "Otp sent", "Otp is "+randomNum+"");
                    Response res = new Response(HTTP_OK, "text/plain", randomNum+"");
                    return res;
                }
                else{
                   Response res = new Response(HTTP_OK, "text/plain", "invalid");
                   return res;
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }  
        else if(uri.equals("/fetchfacultydata"))
        {
            String ans = "";
            try {
                String email1 = parms.getProperty("email");
                ResultSet rs  = DBLoader.executeQuery("select * from faculty where email = '"+email1+"'");
                while(rs.next())
                {
                    String name = rs.getString("name");
                    String father_name = rs.getString("father_name");
                    String mobile = rs.getString("mobile");
                    String address = rs.getString("address");
                    String qualification = rs.getString("qualification");
                    String dept_name = rs.getString("department");
                    String email = rs.getString("email");
                    String row = name + "$"+ dept_name + "$"+ father_name + "$"+ email + "$"+ qualification + "$" + mobile + "$" + address;
                    ans = ans + row ;
                }
                return new Response(HTTP_OK, "text/plain", ans);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        } 
        else if (uri.equals("/fetchcourses3"))
        {
            String ans = "";
            try {             
                ResultSet rs = DBLoader.executeQuery("select * from courses");
                while (rs.next()) 
                {
                    int id = rs.getInt("id");
                    String row = String.format("%d",id);  // Convert the int to String
                    ans = ans + row + ";;";
                }
                return new Response(HTTP_OK, "text/plain", ans);
            } 
            catch (Exception e) 
            {
                e.printStackTrace(); // Print the exception for debugging purposes
            }
        }
        else if (uri.equals("/fetchsemester"))
        {
            String ans = "";
            try {
                String course = parms.getProperty("course");              
                ResultSet rs = DBLoader.executeQuery("select * from courses where id = '"+course+"'");
                while (rs.next()) 
                {
                    String row = rs.getString("semester"); // Convert the int to String
                    ans = ans + row + ";;";
                }
                return new Response(HTTP_OK, "text/plain", ans);
            } 
            catch (Exception e) 
            {
                e.printStackTrace(); // Print the exception for debugging purposes
            }
        }
        else if(uri.equals("/addnotes"))
        {
            String id = parms.getProperty("id");
            String semester = parms.getProperty("semester");
            String course = parms.getProperty("course");
            String email = parms.getProperty("email");
            String title = parms.getProperty("title");
            String detail = parms.getProperty("detail");
            String datetime = parms.getProperty("datetime");
            String type = parms.getProperty("type");
            try 
            {
             ResultSet rs  = DBLoader.executeQuery("select * from notes where id ='"+id+"'");
             if(rs.next())
             {
                 Response res = new Response(HTTP_OK, "text/plain", "exist");
                 return res;
             }
             else
             {
                String file = saveFileOnServerWithRandomName(files, parms, "file", "src/uploads/");
                rs.moveToInsertRow();          
                rs.updateString("semester", semester);
                rs.updateString("course", course);
                rs.updateString("email", email);                              
                rs.updateString("title", title);
                rs.updateString("detail", detail);
                rs.updateString("datetime", datetime);
                rs.updateString("type", type);
                rs.updateString("file", "src/uploads/"+file);
                rs.insertRow();
                Response res = new Response(HTTP_OK, "text/plain", "success");
                return res;
             }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }    
        else if (uri.equals("/fetchnotes")) {
            String course1 = parms.getProperty("Course");
            int course2=Integer.parseInt(course1);
            String semester1=parms.getProperty("Semester");
            try {
                ResultSet rs = DBLoader.executeQuery("select * from notes where semester='"+semester1+"' and course="+course2);
                String ans = ""; // Initialize without space
   
                while (rs.next()) {
                    String id = rs.getInt("id")+"";
                    String semester = rs.getString("semester");
                    String course = rs.getInt("course")+"";
                    String email = rs.getString("email");
                    String title = rs.getString("title");
                    String detail = rs.getString("detail");
                    String datetime = rs.getString("datetime");
                    String type = rs.getString("type");
                    String file = rs.getString("file");
                    
                    String row = id + "$" + semester + "$" + course+"$" + email + "$" + title + "$" + detail + "$" + datetime + "$" + type + "$" + file;
                    ans = ans + row + ";;";
                }
                return new Response(HTTP_OK, "text/plain", ans);
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(uri.equals("/studentlogin")){
            String email = parms.getProperty("email");
            try 
            {
                ResultSet rs = DBLoader.executeQuery("select * from students where email = '"+email+"'");
                if(rs.next())
                {   
                    int randomNum = (int)(1000+(9999-1000)*Math.random());
                    System.out.println(randomNum);
                    sendemail obj = new sendemail(email, "Otp sent", "Otp is "+randomNum+"");
                    Response res = new Response(HTTP_OK, "text/plain", randomNum+"");
                    return res;
                }
                else{
                   Response res = new Response(HTTP_OK, "text/plain", "invalid");
                   return res;
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }  
        else if(uri.equals("/fetchstudentinfo"))
        {
           String email1 = parms.getProperty("email");
            try
            { 
                ResultSet rs=DBLoader.executeQuery("select * from students where email='"+email1+"'");
                String ans="";
                
                 while(rs.next())
                {
                    String dept_name=rs.getString("dept_name");
                    String course=rs.getString("course");
                    String semester=rs.getString("semester");
                    String name=rs.getString("name");
                    String father_name=rs.getString("father_name");
                    String phone=rs.getString("phone");
                    String email=rs.getString("email");
                    String address=rs.getString("address");    
                    ans = ans+dept_name+","+course+","+semester+","+name+","+father_name+","+phone+","+email+","+address;
                    //System.out.println(ans);
                }
                return new Response(HTTP_OK, "text/plain",ans);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(uri.equals("/uploadtimetable"))
        {
            String id = parms.getProperty("id");
            String course = parms.getProperty("course");
            String semester = parms.getProperty("semester");
            String teacher_email = parms.getProperty("teacher_email");
            try 
            {
             ResultSet rs  = DBLoader.executeQuery("select * from timetable where id ='"+id+"'");
             if(rs.next())
             {
                 Response res = new Response(HTTP_OK, "text/plain", "exist");
                 return res;
             }
             else
             {
                String file = saveFileOnServerWithRandomName(files, parms, "file", "src/uploads/");
                rs.moveToInsertRow();          
                rs.updateString("semester", semester);
                rs.updateString("course", course);
                rs.updateString("teacher_email", teacher_email);                              
                rs.updateString("file", "src/uploads/"+file);
                rs.insertRow();
                Response res = new Response(HTTP_OK, "text/plain", "success");
                return res;
             }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else if (uri.equals("/fetchtimetable")) {
            String course1 = parms.getProperty("Course");
            int course2=Integer.parseInt(course1);
            String semester1=parms.getProperty("Semester");
            try {
                ResultSet rs = DBLoader.executeQuery("select * from timetable where semester='"+semester1+"' and course="+course2);
                String ans = ""; // Initialize without space
   
                while (rs.next()) {
                    String id = rs.getInt("id")+"";
                    String course = rs.getInt("course")+"";
                    String semester = rs.getString("semester");
                    String t_email = rs.getString("t_email");
                    String file = rs.getString("file");
                    String row = id + "$"+ course+ "$" + semester + "$" + t_email + "$" + file;
                    ans = ans + row + ";;";
                }
                return new Response(HTTP_OK, "text/plain", ans);
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(uri.equals("/addassignment"))
        {
            String id = parms.getProperty("id");
            String t_email = parms.getProperty("t_email");
            String title = parms.getProperty("title");
            String detail = parms.getProperty("detail");
            String course = parms.getProperty("course");
            String semester = parms.getProperty("semester");
            String datetime = parms.getProperty("datetime");
            String lastdate = parms.getProperty("lastdate");
            try 
            {
             ResultSet rs  = DBLoader.executeQuery("select * from assignment where id ='"+id+"'");
             if(rs.next())
             {
                 Response res = new Response(HTTP_OK, "text/plain", "exist");
                 return res;
             }
             else
             {
                String file = saveFileOnServerWithRandomName(files, parms, "file", "src/uploads/");
                rs.moveToInsertRow();          
                rs.updateString("t_email", t_email);  
                rs.updateString("title", title);
                rs.updateString("detail", detail);
                rs.updateString("datetime", datetime);
                rs.updateString("course", course);          
                rs.updateString("semester", semester);                
                rs.updateString("lastdate", lastdate);
                rs.updateString("file", "src/uploads/"+file);
                rs.insertRow();
                Response res = new Response(HTTP_OK, "text/plain", "success");
                return res;
             }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else if (uri.equals("/fetchassignment")) {
            String course1 = parms.getProperty("Course");
            int course2=Integer.parseInt(course1);
            String semester1=parms.getProperty("Semester");
            try {
                ResultSet rs = DBLoader.executeQuery("select * from assignment where semester='"+semester1+"' and course="+course2);
                String ans = ""; // Initialize without space
   
                while (rs.next()) {
                    String id = rs.getInt("id")+"";
                    String t_email = rs.getString("t_email");
                    String title = rs.getString("title");
                    String detail = rs.getString("detail");
                    String datetime = rs.getString("datetime");
                    String course = rs.getInt("course")+"";
                    String semester = rs.getString("semester");
                    String lastdate = rs.getString("lastdate");
                    String file = rs.getString("file");
                    String row = id + "$" + t_email + "$" + title + "$" + detail + "$" + datetime + "$" + course+ "$" + semester + "$" + lastdate + "$" + file;
                    ans = ans + row + ";;";
                }
                return new Response(HTTP_OK, "text/plain", ans);
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(uri.equals("/question"))
        {
           
            String student_email=parms.getProperty("email");
            String question=parms.getProperty("question");
            String department=parms.getProperty("department");          
            try
            {
                ResultSet rs=DBLoader.executeQuery("select * from chat");
                rs.moveToInsertRow();
                rs.updateString("student_email",student_email);
                rs.updateString("question",question);
                rs.updateString("department", department);
                rs.insertRow();
                return new Response(HTTP_OK, "text/plain", "success");
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else if(uri.equals("/view_question"))
        {
            try {
                ResultSet rs=DBLoader.executeQuery("select * from chat");
                String ans="";
                while(rs.next())
                {
                    
                    String question=rs.getString("question");
                    String answer=rs.getString("answer");
                    ans=ans+question+"$"+answer+";;";
    //                System.out.println(al);
                }
                Response res=new Response(HTTP_OK,"text/plain",ans);
                return res;
                
            } catch (Exception ex) 
            {
               ex.printStackTrace();
            }
        }
        else if(uri.equals("/postAnswer"))
        {
            String teacher_email = parms.getProperty("teacher_email");//workbench wala           
            String department=parms.getProperty("department");
            String answer = parms.getProperty("answer");           
            String chat_id = parms.getProperty("chat_id");//
            try
            {
                ResultSet rs  = DBLoader.executeQuery("select * from chat where chat_id = '"+chat_id+"'");//signup is table name 
                if(rs.next())
                {
                    rs.moveToCurrentRow();
                    rs.updateString("teacher_email", teacher_email);
                    rs.updateString("answer", answer);
                    rs.updateRow();
                    Response res = new Response(HTTP_OK, "text/plain", "success");
                    return res;               
                }           
                else
                {                               
                    Response res = new Response(HTTP_OK, "text/plain", "exist");
                    return res;        
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }        
        }
        else if(uri.equals("/submit_assignment"))
        {
            String ass_id = parms.getProperty("assignment_id"); 
            int assignment_id=Integer.parseInt(ass_id);
            String student_email=parms.getProperty("student_email");
            String dateOfSubmit=parms.getProperty("dateOfSubmit");
            String file=parms.getProperty("file");
            try
            {
                ResultSet rs  = DBLoader.executeQuery("select * from assignment_answer where student_email = '"+student_email+"'and assignment_id='"+assignment_id+"'");//addassignment is table name 
                rs.moveToInsertRow();
                rs.updateInt("assignment_id",assignment_id);
                rs.updateString("student_email",student_email);
                rs.updateString("dateOfSubmit",dateOfSubmit);
                rs.updateString("file",file);
                rs.insertRow();
                return new Response(HTTP_OK, "text/plain", "success");
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }    
        else if(uri.equals("/fetch_ass_answer"))
        {
           String email1 = parms.getProperty("email");
            try
            { 
                ResultSet rs=DBLoader.executeQuery("select * from assignment_answer where student_email='"+email1+"'");
                String ans="";                
                while(rs.next())
                {
                    String id = rs.getInt("id")+"";
                    String assignment_id = rs.getInt("assignment_id")+"";
                    String student_email=rs.getString("student_email");
                    String dateOfSubmit=rs.getString("dateOfSubmit");
                    String file=rs.getString("file");
                    String remarks=rs.getString("remarks");
                    String row = id + "$" + assignment_id + "$" + student_email + "$" + dateOfSubmit + "$" + file + "$" + remarks;
                    ans = ans + row + ";;";
                    //System.out.println(ans);
                }
                return new Response(HTTP_OK, "text/plain",ans);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(uri.equals("/fetch_ass_submitted"))
        {
            try
            { 
                ResultSet rs=DBLoader.executeQuery("select * from assignment_answer");
                String ans="";                
                while(rs.next())
                {
                    String id = rs.getInt("id")+"";
                    String assignment_id = rs.getInt("assignment_id")+"";
                    String student_email=rs.getString("student_email");
                    String dateOfSubmit=rs.getString("dateOfSubmit");
                    String file=rs.getString("file");
                    String remarks=rs.getString("remarks");
                    String row = id + "$" + assignment_id + "$" + student_email + "$" + dateOfSubmit + "$" + file + "$" + remarks;
                    ans = ans + row + ";;";
                    //System.out.println(ans);
                }
                return new Response(HTTP_OK, "text/plain",ans);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }    
        else if(uri.equals("/checkAssignment"))
        {
            String id = parms.getProperty("id");
///            int assignment_id=Integer.parseInt(id);
            String remarks=parms.getProperty("remarks");
            try
            {
                ResultSet rs  = DBLoader.executeQuery("select * from assignment_answer where id = '"+id+"'");//signup is table name 
                if(rs.next())
                {
                    rs.moveToCurrentRow();
                    rs.updateString("remarks",remarks);
                    rs.updateRow();
                    return new Response(HTTP_OK, "text/plain", "success");
                }    
                else{
                    return new Response(HTTP_OK, "text/plain", "error");
                }              
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }    
        else if(uri.equals("/FetchStudent"))
        
         {
             String ans="";
            String course=parms.getProperty("course");
             System.out.println("Server course "+course);
            String semester=parms.getProperty("semester");
            
           try 
            {
             ResultSet rs  = DBLoader.executeQuery("select * from students where course = '"+course+"'and semester='"+semester+"'");//faculty is table name 
             while(rs.next())
             {         
                 String studentname=rs.getString("name");
                 String studentEmail=rs.getString("email");               
                 String row=studentname+"$"+studentEmail;
                 ans=ans+row+";;";
             }

             Response res = new Response(HTTP_OK, "text/plain",ans);
                 return res;
            }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
         }
        else if(uri.equals("/mark_attendance"))
        {
           String student_email = parms.getProperty("student_email");
           String date_of_attendance = parms.getProperty("date_of_attendance");
           String status = parms.getProperty("status");
           String course = parms.getProperty("course");
           String semester = parms.getProperty("semester");
            try
            { 
                ResultSet rs=DBLoader.executeQuery("select * from attendance where student_email='"+student_email+"'");
                rs.moveToInsertRow();
                rs.updateString("student_email",student_email);
                rs.updateString("date_of_attendance",date_of_attendance);
                rs.updateString("status",status);
                rs.updateString("course",course);
                rs.updateString("semester",semester);
                rs.insertRow();
                return new Response(HTTP_OK, "text/plain", "success");
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(uri.equals("/check_attendance"))
        {
           String course1 = parms.getProperty("course");
           String sem = parms.getProperty("semester");
            try
            { 
                ResultSet rs  = DBLoader.executeQuery("select * from attendance where course = '"+course1+"'and semester='"+sem+"'");
                String ans="";                
                while(rs.next())
                {
                    String id = rs.getInt("id")+"";
                    String student_email=rs.getString("student_email");
                    String date_of_attendance=rs.getString("date_of_attendance");
                    String status=rs.getString("status");
                    String course=rs.getString("course");
                    String semester=rs.getString("semester");
                    String row = id + "$" +student_email + "$" + date_of_attendance + "$" + status + "$"+ course + "$" + semester;
                    ans = ans + row + ";;";
                    //System.out.println(ans);
                }
                return new Response(HTTP_OK, "text/plain",ans);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }    
        return null;
    }
}