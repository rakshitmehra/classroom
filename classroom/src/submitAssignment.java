import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
public class submitAssignment extends javax.swing.JFrame {
    ArrayList<ass_Answer> al2;
    JScrollPane jsp;
    JTable jt;
    MyTableModel tm;
    private File file;
    String s_email;
    public submitAssignment(String email) {
        initComponents();
        al2 = new ArrayList<ass_Answer>();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(64, 200, 644, 252);
        tm = new MyTableModel();
        jt.setModel(tm); // Set the table model for the JTable
        add(jsp);
        setSize(764, 537);
        s_email=email;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Assignment Submission");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 764, 56);

        jLabel2.setText("File");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(189, 74, 56, 24);

        bt1.setText("Browse");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(260, 80, 93, 23);

        bt2.setText("Submit");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(390, 80, 93, 23);

        bt3.setText("View");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(285, 456, 72, 23);

        jLabel3.setText("Assignment Id");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 120, 80, 30);
        getContentPane().add(tf1);
        tf1.setBounds(290, 120, 200, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateOfSubmit = sdf.format(new Date());
        String id = tf1.getText();
        String ans = MyClient.submitAssignment(id, s_email, dateOfSubmit, file);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "Submitted Successfully");
        } 
        else{
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        String ans = MyClient.fetchAssignmentAnswer(s_email);
        StringTokenizer st = new StringTokenizer(ans.trim(), ";;");
        System.out.println(ans);
        al2.clear();
        while (st.hasMoreTokens()) {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row, "$");
            String id = st1.nextToken();
            String ass_id = st1.nextToken();
            String s_email = st1.nextToken();        
            String dateOfSubmit = st1.nextToken();
            String file = st1.nextToken();
            String remarks = st1.nextToken();
            al2.add(new ass_Answer(id, ass_id, s_email, dateOfSubmit, file, remarks));
        }
        tm.fireTableDataChanged(); // Notify the table about the data change
    }//GEN-LAST:event_bt3ActionPerformed
public class MyTableModel extends AbstractTableModel {
        @Override
        public int getRowCount() {
            return al2.size();
        }
        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public String getColumnName(int i) {
            String col[] = {"Id","Ass_Id", "S_email", "DateOfSubmission", "File", "Remarks"};
            return col[i];
        }
        @Override
        public Object getValueAt(int i, int j) {
           ass_Answer nd=al2.get(i);
           if(j==0)
            {
                return nd.id;
            }
            else if(j==1) 
            {
                return nd.ass_id;
            }
           else if(j==2)
           {
                return nd.s_email;
           }
           else if(j==3)
            {
                return nd.dateOfSubmit;
            }
            else if(j==4)
            {
                return nd.file;
            }
            else
            {
                return nd.remarks;
            }                       
        }

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
//            java.util.logging.Logger.getLogger(submitAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(submitAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(submitAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(submitAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new submitAssignment().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
