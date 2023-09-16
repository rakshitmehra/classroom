import java.util.StringTokenizer;
public class StudentHome extends javax.swing.JFrame {
    String t_email;
    String department;
    public StudentHome(String email) {
        initComponents();
        t_email = email;
        fetchStudentData(email);
        setSize(752, 575);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Home");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 750, 48);

        jLabel2.setText("Department");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(54, 81, 69, 26);
        getContentPane().add(lb1);
        lb1.setBounds(202, 81, 190, 26);

        jLabel3.setText("Course");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(54, 125, 75, 24);
        getContentPane().add(lb2);
        lb2.setBounds(202, 125, 190, 24);

        jLabel4.setText("Semester");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(54, 167, 75, 24);
        getContentPane().add(lb3);
        lb3.setBounds(202, 167, 190, 24);

        jLabel5.setText("Name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(54, 209, 75, 24);
        getContentPane().add(lb4);
        lb4.setBounds(202, 209, 190, 24);

        jLabel6.setText("Father Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(54, 251, 75, 24);
        getContentPane().add(lb5);
        lb5.setBounds(202, 251, 190, 24);

        jLabel7.setText("Phone");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(54, 293, 75, 24);
        getContentPane().add(lb6);
        lb6.setBounds(241, 293, 151, 24);

        jLabel8.setText("Email");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(54, 335, 75, 24);
        getContentPane().add(lb7);
        lb7.setBounds(202, 335, 190, 24);

        jLabel9.setText("Address");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(54, 377, 75, 24);
        getContentPane().add(lb8);
        lb8.setBounds(202, 377, 190, 24);

        jButton1.setText("View Notes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(60, 430, 100, 23);

        bt2.setText("Ask a question");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(190, 430, 110, 23);

        bt3.setText("View Assignment");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(320, 430, 121, 23);

        bt4.setText("View Time Table");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(460, 430, 120, 23);

        bt5.setText("Log out");
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });
        getContentPane().add(bt5);
        bt5.setBounds(600, 430, 90, 23);

        bt6.setText("Check Attendance");
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });
        getContentPane().add(bt6);
        bt6.setBounds(60, 480, 130, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        StudentViewNotes obj = new StudentViewNotes();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        chat obj = new chat(t_email, department);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        studentViewAssignment obj = new studentViewAssignment(t_email);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        // TODO add your handling code here:
        ViewTimeTable obj = new ViewTimeTable(t_email);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
        // TODO add your handling code here:
        String name = "student_email";
        deleteSession obj = new deleteSession();
        obj.func(name);
        setVisible(false);
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed
        // TODO add your handling code here:
        CheckAttendance obj = new CheckAttendance(t_email);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt6ActionPerformed
    void fetchStudentData(String email)
    {
        String ans = MyClient.fetchStudentInfo(email);           
        StringTokenizer st1 = new StringTokenizer(ans, ",");
        department = st1.nextToken();
        lb1.setText(department);
        lb2.setText(st1.nextToken());
        lb3.setText(st1.nextToken());
        lb4.setText(st1.nextToken());
        lb5.setText(st1.nextToken());
        lb6.setText(st1.nextToken());
        lb7.setText(st1.nextToken());  
        lb8.setText(st1.nextToken());  
    }        
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
//            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StudentHome().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    // End of variables declaration//GEN-END:variables
}
