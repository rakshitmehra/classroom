import java.awt.Image;
import javax.swing.*;
public class Server extends javax.swing.JFrame {
    JLabel lb1;
    My_Server obj;
    public Server() {
        initComponents();
        setSize(664, 450);
        lb1 = new JLabel();
        lb1.setBounds(0,0,664, 450);
        ImageIcon ic = new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\Java using netbeans\\Classroom\\icons\\Image1.jpg");
        Image img = ic.getImage().getScaledInstance(lb1.getWidth(), lb1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        lb1.setIcon(ic1);
        bt2.setEnabled(false);
        getContentPane().add(lb1);
        setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        bt2 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("My Server");
        getContentPane().add(lb);
        lb.setBounds(0, 0, 636, 62);

        bt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-stop-50.png"))); // NOI18N
        bt2.setText("Stop");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(230, 180, 200, 60);

        bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-start-50.png"))); // NOI18N
        bt1.setText("Start");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(230, 80, 200, 60);

        bt3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-launch-50.png"))); // NOI18N
        bt3.setText("Launch");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(230, 290, 200, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
       try{
           obj = new My_Server(9000);
           bt1.setEnabled(false); 
           bt2.setEnabled(true);
       }
       catch(Exception ex)
        {
             ex.printStackTrace();
        }
    }//GEN-LAST:event_bt1ActionPerformed
    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
       obj.shutdown();
       bt1.setEnabled(true);
       bt2.setEnabled(false);
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        launchPage obj = new launchPage();
        obj.setVisible(true);
    }//GEN-LAST:event_bt3ActionPerformed
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
                new Server().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
