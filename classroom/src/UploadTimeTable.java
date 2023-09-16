import java.awt.Image;
import java.io.File;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UploadTimeTable extends javax.swing.JFrame {
    File ph;
    String temail;
    JFileChooser jfc;
    public UploadTimeTable(String email) {
        initComponents();
        temail = email;
        fetchCourse();
        setSize(634, 500);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cb2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Upload Time Table");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 628, 47);

        jLabel2.setText("Course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(161, 83, 86, 24);

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(cb1);
        cb1.setBounds(253, 83, 233, 24);

        jLabel3.setText("Semester");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(161, 125, 67, 24);

        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        getContentPane().add(cb2);
        cb2.setBounds(253, 125, 233, 24);

        jLabel4.setText("Photo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(161, 167, 67, 24);
        getContentPane().add(lb1);
        lb1.setBounds(253, 167, 133, 122);

        bt1.setText("Browse");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(404, 199, 72, 23);

        bt2.setText("Add");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(314, 307, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void fetchCourse()
    {
        String ans = MyClient.fetchcourses3();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {   
            cb1.addItem(st.nextToken());
        }     
    } 
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
      jfc = new JFileChooser();     
      int ans = jfc.showOpenDialog(this);      
      if(ans == JFileChooser.APPROVE_OPTION)
      {
          ph = jfc.getSelectedFile();
          ImageIcon ic = new ImageIcon(ph.getPath());
          Image img = ic.getImage().getScaledInstance(lb1.getWidth(), lb1.getHeight(), Image.SCALE_SMOOTH);
          ImageIcon ic1 = new ImageIcon(img);
          lb1.setIcon(ic1);
      }
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        String course = (String)cb1.getSelectedItem();
        String semester = (String)cb2.getSelectedItem();
        String ans = MyClient.uploadTimeTable(course, semester, temail, ph);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "Added Successfully");
        } 
        else{
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_bt2ActionPerformed
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UploadTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UploadTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UploadTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UploadTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UploadTimeTable().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lb1;
    // End of variables declaration//GEN-END:variables
}
