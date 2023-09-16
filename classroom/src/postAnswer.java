import java.util.StringTokenizer;
import javax.swing.JOptionPane;
public class postAnswer extends javax.swing.JFrame {
    String teacher_email;
    String dept;
    public postAnswer(String email, String Department) {
        initComponents();
        teacher_email = email;
        dept=Department;
        viewQuestion();
        setSize(699, 700);        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Post Answer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 699, 45);

        tf2.setColumns(20);
        tf2.setRows(5);
        jScrollPane1.setViewportView(tf2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(37, 83, 617, 245);

        jLabel2.setText("Question Id:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(37, 359, 75, 25);
        getContentPane().add(tf1);
        tf1.setBounds(118, 359, 482, 25);

        jLabel3.setText("Answer:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(37, 402, 75, 24);
        getContentPane().add(tf3);
        tf3.setBounds(118, 403, 482, 30);

        bt1.setText("Post");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(300, 440, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void viewQuestion()
    {
        String updateText="";
        String ans = MyClient.viewQuestion();
        StringTokenizer st = new StringTokenizer(ans, ";;");       
        while(st.hasMoreTokens())
        {
            String row=st.nextToken();
            StringTokenizer st1=new StringTokenizer(row,"$");
            String ques = st1.nextToken();
            String ans1 = st1.nextToken();
            updateText =updateText+"\n"+ ques + "\n" + ans1+"\n";       
    }    
        tf2.setText(updateText);
    }
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        String Ans=tf3.getText();
        String chat_id=tf1.getText();
        if(Ans.isEmpty()||chat_id.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "All fileds are Mandatory");
        }
        else
        {
            String ans=MyClient.postAnswer(teacher_email,dept,chat_id,Ans);
            if(ans.trim().equals("success"))
            {
             JOptionPane.showMessageDialog(rootPane, "Added Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, ans);
            }
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
//            java.util.logging.Logger.getLogger(postAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(postAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(postAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(postAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new postAnswer().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextArea tf2;
    private javax.swing.JTextField tf3;
    // End of variables declaration//GEN-END:variables
}
