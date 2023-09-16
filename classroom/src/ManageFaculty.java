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
public class ManageFaculty extends javax.swing.JFrame {
    ArrayList<faculty> al1;
    File ph;
    JFileChooser jfc;
    JScrollPane jsp;
    JTable jt;
    myTableModel tm;
    public ManageFaculty() {
        initComponents();
        al1 = new ArrayList<faculty>();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(401, 139, 800, 240);
        tm = new myTableModel();
        jt.setModel(tm); // Set the table model for the JTable
        fetchDepartment();
        fetchDepartment2();
        jt.setRowHeight(100);
        jt.getColumnModel().getColumn(7).setCellRenderer(new ManageFaculty.ImageRenderer());
        getContentPane().add(jsp);
        setSize(1300, 665);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf4 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        tf6 = new javax.swing.JComboBox<>();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Faculty");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 48);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Faculty");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 54, 400, 39);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("View Faculty");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(400, 54, 500, 39);

        jLabel4.setText("Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 102, 68, 16);
        getContentPane().add(tf1);
        tf1.setBounds(74, 99, 255, 22);

        jLabel5.setText("F.Name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 142, 68, 16);
        getContentPane().add(tf2);
        tf2.setBounds(74, 139, 255, 22);

        jLabel6.setText("Mobile No.");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 182, 68, 16);
        getContentPane().add(tf3);
        tf3.setBounds(74, 179, 255, 22);

        jLabel7.setText("Address");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 219, 68, 16);

        tf4.setColumns(20);
        tf4.setRows(5);
        jScrollPane1.setViewportView(tf4);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(74, 219, 255, 117);

        jLabel8.setText("Qualification");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 352, 68, 16);
        getContentPane().add(tf5);
        tf5.setBounds(74, 349, 255, 22);

        jLabel9.setText("Department");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 403, 68, 16);

        jLabel10.setText("email");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 443, 68, 16);
        getContentPane().add(tf7);
        tf7.setBounds(74, 440, 255, 22);

        jLabel11.setText("Photo");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 480, 68, 16);
        getContentPane().add(lb1);
        lb1.setBounds(74, 480, 114, 107);

        tf6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(tf6);
        tf6.setBounds(74, 400, 255, 22);

        bt1.setText("Add");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(146, 599, 87, 23);

        bt2.setText("Browse");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(257, 507, 72, 23);

        jLabel12.setText("Department");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(401, 102, 76, 16);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(cb);
        cb.setBounds(500, 99, 276, 22);

        bt3.setText("View");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(810, 100, 72, 23);

        bt4.setText("Delete");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(590, 420, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void fetchDepartment()
    {
        String ans = MyClient.fetchdepartment();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {   
            tf6.addItem(st.nextToken());
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
    void fetchFaculty() {
    String department = (String)cb.getSelectedItem();
    String ans = MyClient.fetchfaculty(department);
    //System.out.println(ans);
    StringTokenizer st = new StringTokenizer(ans.trim(), ";;");
    al1.clear();
    while (st.hasMoreTokens()) {
        String row = st.nextToken();
        //System.out.println(row);
        StringTokenizer st1 = new StringTokenizer(row, "$");
            String name = st1.nextToken();
            String father_name = st1.nextToken();
            String mobile = st1.nextToken();
            String address = st1.nextToken();
            String qualification = st1.nextToken();
            String dept_name = st1.nextToken();
            String email = st1.nextToken();
            String photo = st1.nextToken();
            al1.add(new faculty(name, father_name, mobile, address, qualification, dept_name, email, photo));
        
    }
    tm.fireTableDataChanged(); // Notify the table about the data change
}

    void deleteFaculty()
    {
        int i=jt.getSelectedRow();
        String email=(String)jt.getValueAt(i, 6);
        String ans = MyClient.deleteFaculty(email);
        JOptionPane.showMessageDialog(rootPane, ans);
        dispose();
        ManageFaculty mc= new ManageFaculty();
    }    
    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        fetchFaculty();
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
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

    }//GEN-LAST:event_bt2ActionPerformed
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        String name = tf1.getText();
        String father_name = tf2.getText();
        String mobile = tf3.getText();
        String address = tf4.getText();
        String qualification = tf5.getText();
        String department = (String)tf6.getSelectedItem();
        String email = tf7.getText();
        String ans = MyClient.addFaculty(name, father_name, mobile, address, qualification, department, email, ph);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "Added Successfully");
        } 
        else{
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        // TODO add your handling code here:
        deleteFaculty();
    }//GEN-LAST:event_bt4ActionPerformed
    class myTableModel extends AbstractTableModel
    {
        @Override
        public int getRowCount() {
            return al1.size();
        }
        @Override
        public int getColumnCount() {
            return 8;
        }
        @Override
        public String getColumnName(int j){
            String names[] = {"name","father_name","mobile","address","qualification","department","email","photo"};
            return names[j];
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            faculty dt = al1.get(rowIndex);
            
            if(columnIndex==0)
                return dt.name;
            else if(columnIndex==1)
                return dt.father_name;
            else if(columnIndex==2)
                return dt.mobile;
            else if(columnIndex==3)
                return dt.address;
            else if(columnIndex==4)
                return dt.qualification;
            else if(columnIndex==5)
                return dt.dept_name;
            else if(columnIndex==6)
                return dt.email;
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
                ImageIcon ic = new ImageIcon(al1.get(row).photo);
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
            java.util.logging.Logger.getLogger(ManageFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageFaculty().setVisible(true);
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
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextArea tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JComboBox<String> tf6;
    private javax.swing.JTextField tf7;
    // End of variables declaration//GEN-END:variables
}
