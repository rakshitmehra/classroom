import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class deleteSession 
{
    public void func(String name) 
    {
        // When the user logs out
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("config.properties")) {
            props.load(in);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
         // Remove the "username" property
        props.remove(name);
        try (FileOutputStream out = new FileOutputStream("config.properties")) {
            props.store(out, null);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }   
}