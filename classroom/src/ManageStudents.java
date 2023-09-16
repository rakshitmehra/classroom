import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
public class ManageStudents extends javax.swing.JFrame {
    ArrayList<students> al2;
    File ph;
    JFileChooser jfc;
    JScrollPane jsp;
    JTable jt;
    myTableModel tm;
    public ManageStudents() {
        initComponents();
        al2 = new ArrayList<students>();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(370, 140, 900, 220);
        tm = new myTableModel();
        jt.setModel(tm);
        fetchDepartment();
        fetchDepartment2();
        jt.setRowHeight(100);
        jt.getColumnModel().getColumn(8).setCellRenderer(new ManageStudents.ImageRenderer());
        getContentPane().add(jsp);
        setSize(1300, 820);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tf2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tf3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf6 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        bt2 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tf7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf8 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Students");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1310, 48);

        jLabel9.setText("Department");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 150, 70, 20);

        tf1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        tf1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tf1ItemStateChanged(evt);
            }
        });
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(90, 150, 230, 30);

        jLabel2.setText("Course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 200, 70, 20);

        tf2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(tf2);
        tf2.setBounds(90, 200, 230, 30);

        jLabel3.setText("Semester");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 250, 70, 20);

        tf3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        getContentPane().add(tf3);
        tf3.setBounds(90, 250, 230, 30);

        jLabel4.setText("Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 300, 60, 20);

        tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf4ActionPerformed(evt);
            }
        });
        getContentPane().add(tf4);
        tf4.setBounds(90, 300, 230, 30);

        jLabel5.setText("Phone");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 410, 60, 16);

        tf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf5ActionPerformed(evt);
            }
        });
        getContentPane().add(tf5);
        tf5.setBounds(90, 400, 230, 30);

        jLabel6.setText("Address");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 460, 70, 20);

        tf6.setColumns(20);
        tf6.setRows(5);
        jScrollPane1.setViewportView(tf6);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 460, 234, 110);

        jLabel7.setText("Photo");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 600, 80, 20);
        getContentPane().add(lb1);
        lb1.setBounds(90, 620, 100, 90);

        bt2.setText("Add");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(100, 730, 72, 23);

        bt1.setText("Browse");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(240, 650, 72, 20);

        jLabel8.setText("Department");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(400, 100, 70, 20);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(cb);
        cb.setBounds(490, 92, 180, 30);

        bt3.setText("View");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(680, 100, 72, 23);

        bt4.setText("Delete");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(540, 400, 72, 23);

        jLabel10.setText("email");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 100, 70, 20);
        getContentPane().add(tf7);
        tf7.setBounds(90, 100, 230, 30);

        jLabel11.setText("father_name");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 360, 70, 16);
        getContentPane().add(tf8);
        tf8.setBounds(90, 352, 230, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void fetchDepartment()
    {
        String ans = MyClient.fetchdepartment();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {   
            tf1.addItem(st.nextToken());
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
    void fetchCourse(String department)
    {
        String ans = MyClient.fetchcourses2(department);
        StringTokenizer st = new StringTokenizer(ans,";;");
        tf2.removeAllItems();
        while(st.hasMoreTokens())
        {   
            tf2.addItem(st.nextToken());
        }     
    } 
    void fetchStudent() {
    String department = (String) cb.getSelectedItem();
    String ans = MyClient.fetchStudent(department);
    StringTokenizer st = new StringTokenizer(ans.trim(), ";;");
    al2.clear();
    while (st.hasMoreTokens()) {
        String row = st.nextToken();
        StringTokenizer st1 = new StringTokenizer(row, "$");
            String email = st1.nextToken();
            String dept_name = st1.nextToken();
            String course = st1.nextToken();
            String semester = st1.nextToken();
            String name = st1.nextToken();
            String father_name = st1.nextToken();
            String phone = st1.nextToken();
            String address = st1.nextToken();
            String photo = st1.nextToken();
            al2.add(new students(email, dept_name, course, semester, name, father_name, phone, address, photo));
         }
        tm.fireTableDataChanged();
    }
    void deleteStudent()
    {
        int i=jt.getSelectedRow();
        String email=(String)jt.getValueAt(i, 0);
        String ans = MyClient.deleteStudent(email);
        JOptionPane.showMessageDialog(rootPane, ans);
        dispose();
        ManageFaculty mc= new ManageFaculty();
        mc.setVisible(true);
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
        String email = tf7.getText();
        String dept_name = (String)tf1.getSelectedItem();
        String course = (String)tf2.getSelectedItem();
        String semester = (String)tf3.getSelectedItem();
        String name = tf4.getText();
        String father_name = tf8.getText();
        String phone = tf5.getText();
        String address = tf6.getText();
        String ans = MyClient.addStudent(email, dept_name, course, semester, name, father_name, phone, address, ph);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "Added Successfully");
        } 
        else{
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_bt2ActionPerformed
    
    private void tf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf5ActionPerformed
    private void tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4ActionPerformed
    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed
    private void tf1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tf1ItemStateChanged
        // TODO add your handling code here:
            String selectedDepartment = (String)tf1.getSelectedItem();
            fetchCourse(selectedDepartment);
    
    }//GEN-LAST:event_tf1ItemStateChanged

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        fetchStudent();
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        // TODO add your handling code here:
        deleteStudent();
    }//GEN-LAST:event_bt4ActionPerformed
    class myTableModel extends AbstractTableModel
    {
        @Override
        public int getRowCount() {
            return al2.size();
        }
        @Override
        public int getColumnCount() {
            return 9;
        }
        @Override
        public String getColumnName(int j){
            String names[] = {"email" , "dept_name", "course", "semester", "name", "father_name", "phone", "address", "photo"};
            return names[j];
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            students dt = al2.get(rowIndex);       
            if(columnIndex==0)
                return dt.email;
            else if(columnIndex==1)
                return dt.dept_name;
            else if(columnIndex==2)
                return dt.course;
            else if(columnIndex==3)
                return dt.semester;
            else if(columnIndex==4)
                return dt.name;
            else if(columnIndex==5)
                return dt.father_name;
            else if(columnIndex==6)
                return dt.phone;
            else if(columnIndex==7)
                return dt.address;
            else
                return dt.photo;
        }    
    }
    class ImageRenderer extends DefaultTableCellRenderer {
        JLabel lbl = new JLabel();
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            try {
                ImageIcon ic = new ImageIcon(al2.get(row).photo);
                Image img = ic.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon ic1 = new ImageIcon(img);
                lb1.setIcon(ic1);   
                
            } 
            catch (Exception ex) {
                ex.printStackTrace();
            }
            return lb1;    
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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JComboBox<String> tf1;
    private javax.swing.JComboBox<String> tf2;
    private javax.swing.JComboBox<String> tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JTextArea tf6;
    private javax.swing.JTextField tf7;
    private javax.swing.JTextField tf8;
    // End of variables declaration//GEN-END:variables
}
