import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
public class facultyViewAssignment extends javax.swing.JFrame {
    ArrayList<assignment> al2;
    JScrollPane jsp;
    JTable jt;
    MyTableModel tm;
    String t_email;
    public facultyViewAssignment(String email) {
        t_email = email;
        initComponents();
        al2 = new ArrayList<assignment>();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(54, 200, 645, 314);
        tm = new MyTableModel();
        jt.setModel(tm); // Set the table model for the JTable
        fetchCourse();
        add(jsp);
        setSize(751, 800);
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
        cb1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cb2 = new javax.swing.JComboBox<>();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Assignment");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 751, 48);

        jLabel2.setText("Course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(105, 66, 83, 26);

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(cb1);
        cb1.setBounds(206, 66, 283, 26);

        jLabel3.setText("Semester");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(105, 110, 83, 26);

        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        getContentPane().add(cb2);
        cb2.setBounds(206, 110, 283, 26);

        bt1.setText("View");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(539, 68, 100, 23);

        bt2.setText("Open file");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(539, 112, 100, 23);

        bt3.setText("Check Assignment");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(540, 160, 140, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        String Course = (String)cb1.getSelectedItem();
        String Semester = (String)cb2.getSelectedItem();
        String ans = MyClient.fetchAssignment(Course, Semester);
        StringTokenizer st = new StringTokenizer(ans.trim(), ";;");
//        System.out.println(ans);
        al2.clear();
        while (st.hasMoreTokens()) {
            String row = st.nextToken();
            System.out.println();
            StringTokenizer st1 = new StringTokenizer(row, "$");
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
            String id = st1.nextToken();
            String temail = st1.nextToken();        
            String title = st1.nextToken();
            String detail = st1.nextToken();
            String datetime = st1.nextToken();
            String course = st1.nextToken();
            String semester = st1.nextToken();
            String lastdate = st1.nextToken();
            String file = st1.nextToken();
            al2.add(new assignment(id, temail, title, detail, datetime, course, semester, lastdate, file));
        }
        tm.fireTableDataChanged(); // Notify the table about the data change
    }//GEN-LAST:event_bt1ActionPerformed
    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
         try
        {
            int i=jt.getSelectedRow();
            String path=(String)jt.getValueAt(i, 8);
            Desktop d=Desktop.getDesktop();
            File f=new File(path);
            d.open(f);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        checkAssignment obj4 = new checkAssignment(t_email);
        obj4.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt3ActionPerformed
    public class MyTableModel extends AbstractTableModel {
        @Override
        public int getRowCount() {
            return al2.size();
        }
        @Override
        public int getColumnCount() {
            return 9;
        }

        @Override
        public String getColumnName(int i) {
            String col[] = {"id","T_Email", "Title", "Detail", "DateTime"," Course", "Semester", "Lastdate","File"};
            return col[i];
        }
        @Override
        public Object getValueAt(int i, int j) {
           assignment nd=al2.get(i);
           if(j==0)
            {
                return nd.id;
            }
            else if(j==1) 
            {
                return nd.t_email;
            }
           else if(j==2)
           {
                return nd.title;
           }
           else if(j==3)
            {
                return nd.detail;
            }
            else if(j==4)
            {
                return nd.datetime;
            }
            else if(j==5)
            {
                return nd.course;
            }
            else if(j==6)
            {
                return nd.semester;
            }
            else if(j==7)
            {
                return nd.lastdate;
            }
            else
            {
                return nd.file;
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
//            java.util.logging.Logger.getLogger(facultyViewAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(facultyViewAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(facultyViewAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(facultyViewAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new facultyViewAssignment().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
