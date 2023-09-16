import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
public class ManageCourses extends javax.swing.JFrame {
    ArrayList<courses> al;
    JScrollPane jsp;
    JTable jt;
    myTableModel tm;
    public ManageCourses() {
        initComponents();
        al = new ArrayList<courses>();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(480, 165, 280, 180);
        tm = new myTableModel();
        jt.setModel(tm);
        fetchDepartment();
        fetchDepartment2();
        add(jsp);
        setSize(812, 584);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        tf2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf4 = new javax.swing.JTextArea();
        bt1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 66, 299, 31);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("View Course");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 70, 290, 32);

        jLabel4.setText("Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 104, 69, 22);

        jLabel5.setText("Department");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 138, 69, 24);

        jLabel6.setText("Semester");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 174, 69, 24);

        jLabel7.setText("Description");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 210, 69, 24);
        getContentPane().add(tf1);
        tf1.setBounds(87, 104, 239, 22);
        getContentPane().add(tf3);
        tf3.setBounds(90, 180, 239, 22);

        tf2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(tf2);
        tf2.setBounds(90, 140, 239, 22);

        tf4.setColumns(20);
        tf4.setRows(5);
        jScrollPane1.setViewportView(tf4);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 220, 239, 117);

        bt1.setText("Add");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(172, 359, 72, 23);

        jLabel8.setText("Department");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(370, 110, 72, 16);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(cb);
        cb.setBounds(450, 110, 226, 22);

        bt2.setText("View");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(690, 110, 75, 23);

        bt3.setText("Delete");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(540, 380, 72, 23);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Course");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-3, 0, 820, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void fetchDepartment()
    {
        String ans = MyClient.fetchdepartment();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {   
            tf2.addItem(st.nextToken());
        }    
    }        
    void fetchDepartment2()
    {
        String ans = MyClient.fetchdepartment();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {
            cb.addItem(st.nextToken());
        }    
    }        
    void fetchCourse() {
            String department =(String)cb.getSelectedItem();    
            String ans = MyClient.fetchcourse(department); 
            StringTokenizer st = new StringTokenizer(ans.trim(), ";;");
            al.clear();
            while (st.hasMoreTokens()) {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row, "$");
            int id = Integer.parseInt(st1.nextToken());
            String name = st1.nextToken();
            String dept_name = st1.nextToken();        
            int semester = Integer.parseInt(st1.nextToken());
            String description = st1.nextToken();
            al.add(new courses(id, name, dept_name, semester, description));
        }
        tm.fireTableDataChanged(); // Notify the table about the data change
    }
    void deleteCourse()
    {
        int i=jt.getSelectedRow();
        int id=(int)jt.getValueAt(i, 0);
        String ans = MyClient.deleteCourse(id);
        JOptionPane.showMessageDialog(rootPane, ans);
        dispose();
        ManageCourses mc= new ManageCourses();
    }    
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        String name = tf1.getText();
        String dept_name = (String)tf2.getSelectedItem();
        String semester = tf3.getText();
        String description = tf4.getText();
        if (name.isEmpty() || dept_name.isEmpty() || semester.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "All fileds are Mandatory");
        } else {
            String ans = MyClient.addCourse(name, dept_name, semester, description);
            if (ans.trim().equals("exists")) {
                JOptionPane.showMessageDialog(rootPane, "Already Exist");
            } else if (ans.trim().equals("success")) {

                JOptionPane.showMessageDialog(rootPane, "Success");
                dispose();
                ManageCourses mc = new ManageCourses();

            } else {
                JOptionPane.showMessageDialog(rootPane, ans);
            }
            tf1.setText("");
            tf3.setText("");
            tf4.setText("");
            tf1.requestFocus();
    }                                     
    }                                   

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        deleteCourse();
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here: // Get the selected department from the cb
    fetchCourse();
    }//GEN-LAST:event_bt2ActionPerformed
    class myTableModel extends AbstractTableModel
    {
        @Override
        public int getRowCount() {
            return al.size();
        }
        @Override
        public int getColumnCount() {
            return 5;
        }
        @Override
        public String getColumnName(int j){
            String names[] = {"id","name","dept_name","semester","description"};
            return names[j];
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            courses dt = al.get(rowIndex);
            
            if(columnIndex==0)
                return dt.id;
            else if(columnIndex==1)
                return dt.name;
            else if(columnIndex==2)
                return dt.dept_name;
            else if(columnIndex==3)
                return dt.semester;
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
                new ManageCourses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf1;
    private javax.swing.JComboBox<String> tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextArea tf4;
    // End of variables declaration//GEN-END:variables
}
