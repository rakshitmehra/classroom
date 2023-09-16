import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
public class ManageDepartment extends javax.swing.JFrame {
    ArrayList<department> dept;
    JScrollPane jsp;
    JTable jt;
    myTableModel tm;
    public ManageDepartment() {
        initComponents();
        dept = new ArrayList<department>();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(400, 150, 340, 180);
        tm = new myTableModel();
        fetchData();
        jt.setModel(tm);
        add(jsp);
        setSize(765,600);
    }
    void fetchData() {
        String ans = MyClient.fetchdept();
        StringTokenizer st = new StringTokenizer(ans.trim(), ";;");
        while (st.hasMoreTokens()) {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row, "$");
            if (st1.countTokens() >= 2) {
                String name = st1.nextToken();
                String description = st1.nextToken();
                dept.add(new department(name, description));
            } 
            else {
            // Handle unexpected data format
            System.err.println("Unexpected data format: " + row);
            }
        }
        tm.fireTableDataChanged();
    }

    void deleteData()
    {
        int i=jt.getSelectedRow();
        String name = (String)jt.getValueAt(i, 0);
        String ans = MyClient.deleteDepartment(name);
        JOptionPane.showMessageDialog(rootPane, ans);
        dispose();
        ManageDepartment md= new ManageDepartment();
    }        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf2 = new javax.swing.JTextArea();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Departments");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 765, 64);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Departments");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 70, 369, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Manage Departments");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(396, 70, 369, 40);

        jLabel4.setText("Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 116, 106, 25);

        jLabel5.setText("Description");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 168, 106, 26);
        getContentPane().add(tf1);
        tf1.setBounds(112, 117, 257, 22);

        tf2.setColumns(20);
        tf2.setRows(5);
        jScrollPane1.setViewportView(tf2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(112, 168, 257, 171);

        bt1.setText("Add");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(197, 389, 72, 23);

        bt2.setText("Delete");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(534, 389, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        String name = tf1.getText();
        String description = tf2.getText();
        String ans = MyClient.addDepartment(name, description);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "Added Successfully");
        } 
        else{
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_bt1ActionPerformed
    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_bt2ActionPerformed
    class myTableModel extends AbstractTableModel {
        @Override
        public int getRowCount() 
        {
            return dept.size();
        }
        @Override
        public int getColumnCount() 
        {
            return 2;
        }
        @Override
        public String getColumnName(int j) {
            String names[] = { "name", "description" };
            return names[j];
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            department dt = dept.get(rowIndex);
            if (columnIndex == 0)
                return dt.name;
            else
                return dt.description;
        }
    }
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
                new ManageDepartment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextArea tf2;
    // End of variables declaration//GEN-END:variables
}
