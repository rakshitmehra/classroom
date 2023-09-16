import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
public class StudentViewNotes extends javax.swing.JFrame {
    ArrayList<Notes> al2;
    JScrollPane jsp;
    JTable jt;
    MyTableModel tm;
    public StudentViewNotes() {
        initComponents();
        al2 = new ArrayList<Notes>();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(41, 187, 567, 243);
        tm = new MyTableModel();
        jt.setModel(tm); // Set the table model for the JTable
        fetchCourse();
        add(jsp);
        setSize(650, 500);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Notes");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 645, 43);

        jLabel2.setText("Course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(156, 61, 93, 25);

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(cb1);
        cb1.setBounds(255, 62, 209, 22);

        jLabel3.setText("Semester");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(156, 104, 93, 25);

        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        getContentPane().add(cb2);
        cb2.setBounds(255, 105, 209, 22);

        bt1.setText("View");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(490, 60, 72, 23);

        bt2.setText("Open File");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(490, 100, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void fetchNotes()
    {
        String Course = (String)cb1.getSelectedItem();
        String Semester = (String)cb2.getSelectedItem();
        String ans = MyClient.fetchNotes(Course, Semester);
        StringTokenizer st = new StringTokenizer(ans.trim(), ";;");
        System.out.println(ans);
        al2.clear();
        while (st.hasMoreTokens()) {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row, "$");
            String id = st1.nextToken();
            String semester = st1.nextToken();
            String course = st1.nextToken();
            String email = st1.nextToken();        
            String title = st1.nextToken();
            String detail = st1.nextToken();
            String datetime = st1.nextToken();
            String type = st1.nextToken();
            String file = st1.nextToken();
            al2.add(new Notes(id, semester, course, email, title, detail, datetime, type, file));
        }
        tm.fireTableDataChanged(); // Notify the table about the data change
    }  
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        fetchNotes();
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
            String col[] = {"Notes_id", "Course", "Semester" ,"Teacher_Id", "Topic", "Detail", "DateTime","Type","File"};
            return col[i];
        }
        @Override
        public Object getValueAt(int i, int j) {
           Notes nd=al2.get(i);
           if(j==0)
            {
                return nd.notes_id;
            }
            else if(j==1) 
            {
                return nd.course;
            }
           else if(j==2)
           {
                return nd.semester;
           }
           else if(j==3)
            {
                return nd.teacher_id;
            }
            else if(j==4)
            {
                return nd.topic;
            }
            else if(j==5)
            {
                return nd.details;
            }
            else if(j==6)
            {
                return nd.date;
            }
            else if(j==7)
            {
                return nd.type;
            }
            else
            {
                return nd.path;
            }                       
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
            java.util.logging.Logger.getLogger(StudentViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentViewNotes().setVisible(true);
            }
        });
    }

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
