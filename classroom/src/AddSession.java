import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class AddSession 
{
    String email="";
    String name="";
    public AddSession(String email, String name){
        this.email=email;
        this.name=name;
    }
    public void func() {
        Properties props = new Properties();

        try (FileOutputStream out = new FileOutputStream("config.properties")) 
        {
            props.setProperty(name, email);
            props.store(out, null);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
}
