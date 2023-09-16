import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
public class checkAssignment extends javax.swing.JFrame {
    ArrayList<ass_Answer> al2;
    JScrollPane jsp;
    JTable jt;
    MyTableModel tm;
    private File file;
    public checkAssignment(String email) {
        initComponents();
        al2 = new ArrayList<ass_Answer>();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(30, 80, 720, 230);
        tm = new MyTableModel();
        jt.setModel(tm); // Set the table model for the JTable
        add(jsp);
        setSize(795, 540);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bt = new javax.swing.JButton();
        tf1 = new javax.swing.JTextField();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Check Assignment");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 48);

        bt.setText("View");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(220, 340, 72, 23);
        getContentPane().add(tf1);
        tf1.setBounds(120, 380, 302, 30);

        bt2.setText("Send remarks");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(439, 392, 123, 23);

        bt3.setText("Open file");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(440, 340, 80, 23);

        jLabel2.setText("Remarks");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 390, 70, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        // TODO add your handling code here:
        String ans = MyClient.fetchSubmittedAssignment();
        StringTokenizer st = new StringTokenizer(ans.trim(), ";;");
        System.out.println(ans);
        al2.clear();
        while (st.hasMoreTokens()) {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row, "$");
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
            String id = st1.nextToken();
            String assignment_id = st1.nextToken();
            String s_email = st1.nextToken();        
            String dateOfSubmit = st1.nextToken();
            String file1 = st1.nextToken();
            String remarks = st1.nextToken();
            al2.add(new ass_Answer(id, assignment_id, s_email, dateOfSubmit, file1, remarks));
        }
        tm.fireTableDataChanged(); // Notify the table about the data change
    }//GEN-LAST:event_btActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        try
        {
            int i=jt.getSelectedRow();
            String path=(String)jt.getValueAt(i, 4);
            Desktop d=Desktop.getDesktop();
            File f=new File(path);
            d.open(f);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        String remarks = tf1.getText();
        int i=jt.getSelectedRow();
        String ass_id=(String)jt.getValueAt(i, 0);
        String ans = MyClient.checkAssignment(ass_id, remarks);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "Added Successfully");
        } 
        else{
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_bt2ActionPerformed
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
//            java.util.logging.Logger.getLogger(checkAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(checkAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(checkAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(checkAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new checkAssignment().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
