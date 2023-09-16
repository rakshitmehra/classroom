import java.util.StringTokenizer;
import javax.swing.JOptionPane;
public class chat extends javax.swing.JFrame {
    String s_email;
    String department;
    public chat(String email, String dept_name) {
        initComponents();
        department = dept_name;
        s_email = email;
        
        viewQuestion();
        setSize(710, 470);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ask Question");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 48);

        tf2.setColumns(20);
        tf2.setRows(5);
        jScrollPane1.setViewportView(tf2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 80, 638, 270);

        jLabel2.setText("Enter question");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 390, 117, 33);
        getContentPane().add(tf1);
        tf1.setBounds(180, 390, 378, 33);

        bt1.setText("Send");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(600, 400, 72, 23);

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
        String question = tf1.getText();
        String ans  = MyClient.question(s_email,question,department);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "Send Successfully");
        } 
        else{
            JOptionPane.showMessageDialog(rootPane, ans);
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
//            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new chat().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextArea tf2;
    // End of variables declaration//GEN-END:variables
}
