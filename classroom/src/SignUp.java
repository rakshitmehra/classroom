import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class SignUp extends javax.swing.JFrame {
    File ph;
    JFileChooser jfc;
    public SignUp() {
        initComponents();
        setSize(500, 500);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JPasswordField();
        tf4 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();
        lb7 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        bt2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText(" Sign Up");
        getContentPane().add(lb1);
        lb1.setBounds(0, 0, 540, 45);

        lb2.setText("Username");
        getContentPane().add(lb2);
        lb2.setBounds(17, 88, 65, 25);

        lb3.setText("Email");
        getContentPane().add(lb3);
        lb3.setBounds(17, 139, 65, 25);

        lb4.setText("Password");
        getContentPane().add(lb4);
        lb4.setBounds(17, 190, 65, 25);

        lb5.setText("Phone");
        getContentPane().add(lb5);
        lb5.setBounds(17, 241, 65, 25);
        getContentPane().add(tf1);
        tf1.setBounds(100, 89, 272, 22);
        getContentPane().add(tf2);
        tf2.setBounds(100, 140, 272, 22);
        getContentPane().add(tf3);
        tf3.setBounds(100, 191, 272, 22);
        getContentPane().add(tf4);
        tf4.setBounds(100, 242, 272, 22);

        bt1.setText("Submit");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(90, 410, 128, 23);

        lb7.setText("Photo");
        getContentPane().add(lb7);
        lb7.setBounds(20, 300, 60, 16);
        getContentPane().add(lb8);
        lb8.setBounds(100, 300, 110, 90);

        bt2.setText("Browse");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(320, 350, 120, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
      jfc = new JFileChooser();
      
      int ans = jfc.showOpenDialog(this);
      
      if(ans == JFileChooser.APPROVE_OPTION)
      {
          ph = jfc.getSelectedFile();
          ImageIcon ic = new ImageIcon(ph.getPath());
          Image img = ic.getImage().getScaledInstance(lb8.getWidth(), lb8.getHeight(), Image.SCALE_SMOOTH);
          ImageIcon ic1 = new ImageIcon(img);
          lb8.setIcon(ic1);
      }
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        String username = tf1.getText();
        String email = tf2.getText();
        String password = tf3.getText();
        String phone = tf4.getText();
     
        if(username.isEmpty()||email.isEmpty()||password.equals("")||phone.isEmpty()||ph == null)
        {
         JOptionPane.showMessageDialog(rootPane, "All fileds are Mandatory");
        }
        else
        {
            String  ans = MyClient.signup(username, email, password, phone, ph);
         
            if(ans.trim().equals("exist"))
            {
             JOptionPane.showMessageDialog(rootPane, "Already Exist");
            }
            else if(ans.trim().equals("success"))
            {
              JOptionPane.showMessageDialog(rootPane, "success");
            }
            else
            {
              JOptionPane.showMessageDialog(rootPane, ans);
            }
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
                new SignUp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JPasswordField tf3;
    private javax.swing.JTextField tf4;
    // End of variables declaration//GEN-END:variables
}
