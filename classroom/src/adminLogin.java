import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class adminLogin extends javax.swing.JFrame {
    JLabel lb;
    public adminLogin() {
        initComponents();
        setSize(483, 339);
        lb = new JLabel();
        lb.setBounds(0,0,483, 339);
        ImageIcon ic = new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\Java using netbeans\\Classroom\\icons\\Image-2.jpg");
        Image img = ic.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        lb.setIcon(ic1);
        getContentPane().add(lb);
        setVisible(true);
        setResizable(false);
        String name="username";
        Properties prop = new Properties();
        try (FileInputStream in = new FileInputStream("config.properties")) 
        {
            prop.load(in);
            String fac=prop.getProperty(name);
            if(fac!=null)
            {
                adminHome obj=new adminHome(fac);
                obj.setVisible(true);
                setVisible(false);
            }
            else{
                setVisible(true);
            }
        } 
        catch (IOException e) 
        {
        e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        tf2 = new javax.swing.JPasswordField();
        tf1 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("Login");
        getContentPane().add(lb1);
        lb1.setBounds(0, 0, 483, 38);

        lb2.setText("Username");
        getContentPane().add(lb2);
        lb2.setBounds(30, 80, 90, 20);

        lb3.setText("Password");
        getContentPane().add(lb3);
        lb3.setBounds(30, 160, 70, 16);
        getContentPane().add(tf2);
        tf2.setBounds(130, 160, 240, 22);
        getContentPane().add(tf1);
        tf1.setBounds(130, 80, 240, 22);

        bt1.setText("Login");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(200, 240, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        String username = tf1.getText();
        String password = tf2.getText();        
        String ans = MyClient.login(username, password);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "Login Success");
            String name="username";
            AddSession obj2=new AddSession(username,name);
            obj2.func();
            adminHome obj = new adminHome(username);
            obj.setVisible(true);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_bt1ActionPerformed
    public static void main(String args[]) {
         /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminLogin();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JTextField tf1;
    private javax.swing.JPasswordField tf2;
    // End of variables declaration//GEN-END:variables
}
