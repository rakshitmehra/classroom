import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
public class markAttendance extends javax.swing.JFrame {
    String s_email;
    String status;
    ArrayList<student_info> al2;
    JScrollPane jsp;
    JTable jt;
    MyTableModel tm;
    String dept;
    public markAttendance(String email, String department) {
        initComponents();
        s_email=email;
        dept=department;
        al2 = new ArrayList<student_info>();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(50, 160, 670, 310);
        tm = new MyTableModel();
        jt.setModel(tm); // Set 
        fetchCourse();
        add(jsp);
        setSize(768, 600);
    }
    void FetchStudent(String Course,String sem) 
    {
        al2.clear();
        System.out.println("GUI Course "+Course);
        String ans=MyClient.FetchStudent(Course,sem);
        StringTokenizer st = new StringTokenizer(ans,";;");        
        while(st.hasMoreTokens())
        {
            String row = st.nextToken();
            System.out.println("Answer=="+row);
            StringTokenizer st1 = new StringTokenizer(row,"$");
            String student_name=st1.nextToken();
            String stud_email = st1.nextToken();
          
           
           al2.add(new student_info(student_name,stud_email));
        }
       
    }
    void fetchCourse()
    {
        String ans = MyClient.fetchcourses3();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {   
            cb1.addItem(st.nextToken());
        }     
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        cb2 = new javax.swing.JComboBox<>();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mark Attendance");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 767, 49);

        jLabel2.setText("Course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(147, 67, 82, 24);

        jLabel3.setText("Semester");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(147, 109, 82, 24);

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(cb1);
        cb1.setBounds(259, 69, 273, 22);

        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        getContentPane().add(cb2);
        cb2.setBounds(259, 110, 273, 22);

        bt1.setText("Mark Attendance");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(310, 500, 130, 23);

        bt2.setText("View");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(580, 90, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:        
            int i=jt.getSelectedRow();
            String s_email=(String)jt.getValueAt(i, 1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String date_of_attendance = sdf.format(new Date());
            String course = (String)cb1.getSelectedItem();
            String semester =(String)cb2.getSelectedItem();
            String Status=JOptionPane.showInputDialog(rootPane, "Enter accordingly /n Present : P   /n Absent A ");            
            String status="";
            if(Status.equalsIgnoreCase("P"))
            {
                status="Present";
            }
            else if(Status.equalsIgnoreCase("A"))
            {
                status="Absent";
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter P or A");
            }              
            String ans="";
            if(status.equals("Present")|| status.equals("Absent"))
            {
                ans=MyClient.markAttendance(s_email, date_of_attendance, status, course, semester); 
            }               
            else{
                JOptionPane.showMessageDialog(this, "Enter P or A");   
            }                     
            if(ans.equals("success"))
            {
                JOptionPane.showMessageDialog(this, "Attendance Marked");
            }
            else if(ans.equals("error"))
               {
                JOptionPane.showMessageDialog(this, "error");
            } 
            else
                {
                JOptionPane.showMessageDialog(this, ans);
            }        
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        String course=(String)cb1.getSelectedItem();
        //System.out.println("Course iss"+course);
        String sem=(String)cb2.getSelectedItem();
        FetchStudent(course,sem);
        System.out.println("Button working");
        tm.fireTableDataChanged();
    }//GEN-LAST:event_bt2ActionPerformed
    public class MyTableModel extends AbstractTableModel {
        @Override
        public int getRowCount() {
            return al2.size();
        }
        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int i) {
            String col[] = {"Name", "Student Email"};
            return col[i];
        }
        @Override
        public Object getValueAt(int i, int j) {
           student_info nd=al2.get(i);
           if(j==0)
            {
                return nd.name;
            }
            else 
            {
                return nd.email;
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
//            java.util.logging.Logger.getLogger(markAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(markAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(markAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(markAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new markAttendance().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
