import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
public class AddAssignment extends javax.swing.JFrame {
    String t_email;
    private File file;
    public AddAssignment(String email) {
        initComponents();
        fetchCourse();
        t_email = email;
        setSize(734, 600);
    }
    void fetchCourse()
    {
        String ans = MyClient.fetchcourses3();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {   
            tf1.addItem(st.nextToken());
        }     
    }      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tf2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf4 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        tf5 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Assignment");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 734, 48);

        jLabel2.setText("Course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(139, 66, 88, 24);

        tf1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(tf1);
        tf1.setBounds(245, 67, 228, 22);

        jLabel3.setText("Semester");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(139, 108, 88, 24);

        tf2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8"}));
        getContentPane().add(tf2);
        tf2.setBounds(245, 109, 228, 22);

        jLabel4.setText("Title");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(139, 150, 88, 24);
        getContentPane().add(tf3);
        tf3.setBounds(245, 151, 228, 22);

        jLabel5.setText("Detail");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(139, 192, 88, 24);

        tf4.setColumns(20);
        tf4.setRows(5);
        jScrollPane1.setViewportView(tf4);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(245, 192, 228, 127);

        jLabel6.setText("Number of days");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(139, 337, 88, 24);

        tf5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        getContentPane().add(tf5);
        tf5.setBounds(245, 338, 228, 22);

        jLabel7.setText("File");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(139, 379, 88, 24);

        bt1.setText("Browse");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(298, 380, 123, 23);

        bt2.setText("Add");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(298, 421, 123, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        String title = tf3.getText();
        String detail = tf4.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = sdf.format(new Date());
        String course = (String)tf1.getSelectedItem();
        String semester = (String)tf2.getSelectedItem();
        String days = (String)tf5.getSelectedItem();
        int n_days = Integer.parseInt(days);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, n_days);
        String lastDate = sdf1.format(c.getTime());
        String ans = MyClient.addAssignment(t_email, title, detail, dateTime, course, semester, lastDate, file);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "Submitted Successfully");
        } 
        else{
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_bt2ActionPerformed
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(); 
        FileNameExtensionFilter filterpdf = new FileNameExtensionFilter("Pdf Files", "pdf");
        jfc.setFileFilter(filterpdf);
        int ans = jfc.showOpenDialog(this);      
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            file = jfc.getSelectedFile();      
        }
    }//GEN-LAST:event_bt1ActionPerformed
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
//            java.util.logging.Logger.getLogger(AddAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddAssignment().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> tf1;
    private javax.swing.JComboBox<String> tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextArea tf4;
    private javax.swing.JComboBox<String> tf5;
    // End of variables declaration//GEN-END:variables
}
