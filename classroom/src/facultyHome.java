import java.util.StringTokenizer;
public class facultyHome extends javax.swing.JFrame {
    String temail;
    String dept;
    public facultyHome(String email) {
        initComponents();
        temail=email;
        fetchFacultyData(email);
        setSize(753, 600);
    }
    void fetchFacultyData(String email)
    {
        String ans = MyClient.fetchfacultydata(email);           
        StringTokenizer st1 = new StringTokenizer(ans, "$");
        lb1.setText(st1.nextToken());
        String dept = st1.nextToken();
        lb2.setText(dept);
        lb3.setText(st1.nextToken());
        lb4.setText(st1.nextToken());
        lb5.setText(st1.nextToken());
        lb6.setText(st1.nextToken());
        lb7.setText(st1.nextToken());       
    } 
    @SuppressWarnings("unchecked")
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Faculty Home");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 753, 48);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Faculty Info");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(186, 54, 110, 27);

        jLabel3.setText("Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 107, 86, 25);

        jLabel4.setText("Department");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 144, 86, 28);

        jLabel5.setText("F.Name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 184, 86, 24);

        jLabel6.setText("Email Id");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(210, 220, 86, 24);

        jLabel7.setText("Qualification");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(210, 256, 86, 24);

        jLabel8.setText("Mobile No.");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(210, 292, 86, 24);

        jLabel9.setText("Address");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(210, 334, 86, 24);
        getContentPane().add(lb1);
        lb1.setBounds(302, 107, 204, 25);
        getContentPane().add(lb2);
        lb2.setBounds(302, 144, 204, 22);
        getContentPane().add(lb3);
        lb3.setBounds(302, 184, 204, 24);
        getContentPane().add(lb4);
        lb4.setBounds(302, 220, 204, 30);
        getContentPane().add(lb5);
        lb5.setBounds(300, 256, 240, 30);
        getContentPane().add(lb6);
        lb6.setBounds(290, 290, 230, 30);
        getContentPane().add(lb7);
        lb7.setBounds(290, 330, 240, 80);

        bt1.setText("Add notes");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(10, 510, 140, 23);

        bt2.setText("View Notes");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(170, 510, 130, 23);

        bt3.setText("Add Assignment");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(315, 510, 140, 23);

        bt4.setText("View Assignment");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(470, 510, 140, 23);

        bt7.setText("Upload Time Table");
        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });
        getContentPane().add(bt7);
        bt7.setBounds(600, 200, 140, 23);

        bt8.setText("Post Answers");
        bt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt8ActionPerformed(evt);
            }
        });
        getContentPane().add(bt8);
        bt8.setBounds(600, 250, 140, 23);

        bt9.setText("Logout");
        bt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt9ActionPerformed(evt);
            }
        });
        getContentPane().add(bt9);
        bt9.setBounds(600, 310, 140, 23);

        bt10.setText("Mark Attendance");
        bt10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt10ActionPerformed(evt);
            }
        });
        getContentPane().add(bt10);
        bt10.setBounds(600, 150, 140, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        AddAssignment obj = new AddAssignment(temail);
        obj.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_bt3ActionPerformed
    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        // TODO add your handling code here:
        facultyViewAssignment obj = new facultyViewAssignment(temail);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        AddNotes obj = new AddNotes();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        ViewNotes obj = new ViewNotes();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt7ActionPerformed
        // TODO add your handling code here:
        UploadTimeTable obj = new UploadTimeTable(temail);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt7ActionPerformed

    private void bt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt8ActionPerformed
        // TODO add your handling code here:
        postAnswer obj = new postAnswer(temail, dept);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt8ActionPerformed

    private void bt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt9ActionPerformed
        // TODO add your handling code here:
        String name = "faculty_email";
        deleteSession obj = new deleteSession();
        obj.func(name);
        setVisible(false);
    }//GEN-LAST:event_bt9ActionPerformed

    private void bt10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt10ActionPerformed
        // TODO add your handling code here:
        markAttendance obj= new markAttendance(temail, dept);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt10ActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(facultyHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(facultyHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(facultyHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(facultyHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new facultyHome().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt10;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
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
    // End of variables declaration//GEN-END:variables
}
