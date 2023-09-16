import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
public class StudentLogin extends javax.swing.JFrame {
    public StudentLogin() {
        initComponents();
        String name="student_email";
        Properties prop = new Properties();
        try (FileInputStream in = new FileInputStream("config.properties")) 
        {
            prop.load(in);
            String fac=prop.getProperty(name);
            if(fac!=null)
            {
                StudentHome obj=new StudentHome(fac);
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
        setSize(460, 274);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 460, 48);

        jLabel2.setText("Email");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(45, 66, 74, 24);
        getContentPane().add(tf1);
        tf1.setBounds(125, 68, 232, 22);

        bt1.setText("Send Otp");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(195, 140, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        String email = tf1.getText();
        String ans = MyClient.facultyLogin(email);
        String value=JOptionPane.showInputDialog("Enter OTP");
        if(ans.equals(value))
        {
            JOptionPane.showMessageDialog(rootPane, "Login Success");
            String name="student_email";
            AddSession obj2 = new AddSession(email,name);
            obj2.func();
            StudentHome obj = new StudentHome(email);
            obj.setVisible(true);
            dispose();
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
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLogin();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
