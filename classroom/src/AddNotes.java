import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
public class AddNotes extends javax.swing.JFrame {
    String filetype;
    File file;
    ButtonGroup bg;
    public AddNotes() {
        bg = new ButtonGroup();
        initComponents();
        fetchCourse();
        bg.add(rgb1);
        bg.add(rgb2);
        bg.add(rgb3);
        setSize(400, 490);
    }
    void fetchCourse()
    {
        String ans = MyClient.fetchcourses3();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {   
            tf1.addItem(st.nextToken());
        }     
    } 
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tf2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rgb1 = new javax.swing.JRadioButton();
        rgb2 = new javax.swing.JRadioButton();
        rgb3 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        lb1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Notes");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 48);

        jLabel2.setText("Course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(19, 60, 79, 26);

        tf1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        tf1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tf1ItemStateChanged(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(104, 62, 273, 22);

        jLabel3.setText("Semseter");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(19, 104, 79, 24);

        tf2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(tf2);
        tf2.setBounds(104, 105, 273, 22);

        jLabel4.setText("Topic");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(19, 146, 79, 24);
        getContentPane().add(tf3);
        tf3.setBounds(107, 147, 260, 22);

        jLabel5.setText("Type");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 300, 79, 24);

        rgb1.setText("pdf");
        rgb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgb1ActionPerformed(evt);
            }
        });
        getContentPane().add(rgb1);
        rgb1.setBounds(110, 310, 50, 21);

        rgb2.setText("Audio");
        rgb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgb2ActionPerformed(evt);
            }
        });
        getContentPane().add(rgb2);
        rgb2.setBounds(160, 310, 63, 21);

        rgb3.setText("Video");
        rgb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgb3ActionPerformed(evt);
            }
        });
        getContentPane().add(rgb3);
        rgb3.setBounds(230, 310, 60, 21);

        jLabel6.setText("File");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 360, 79, 24);

        bt1.setText("Browse");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(110, 360, 119, 23);

        bt2.setText("Add");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(210, 400, 72, 23);
        getContentPane().add(lb1);
        lb1.setBounds(300, 310, 90, 80);

        jLabel7.setText("Email");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 200, 50, 16);

        tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf4ActionPerformed(evt);
            }
        });
        getContentPane().add(tf4);
        tf4.setBounds(110, 200, 260, 22);

        jLabel8.setText("Detail");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 250, 50, 20);

        tf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf5ActionPerformed(evt);
            }
        });
        getContentPane().add(tf5);
        tf5.setBounds(110, 250, 260, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void fetchSemester(String course)
    {
        String ans = MyClient.fetchSemester(course);
        StringTokenizer st = new StringTokenizer(ans,";;");
        tf2.removeAllItems();
        while(st.hasMoreTokens())
        {   
            tf2.addItem(st.nextToken());
        }     
    }        
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filterpdf = new FileNameExtensionFilter("Pdf Files", "pdf");
        FileNameExtensionFilter filteraudio = new FileNameExtensionFilter("Audio Files", "mp3");
        FileNameExtensionFilter filtervideo = new FileNameExtensionFilter("Video Files", "mp4");
        jfc.setAcceptAllFileFilterUsed(false);
        ImageIcon icon = null;
        if (rgb1.isSelected()) {
            jfc.setFileFilter(filterpdf);
            icon = new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\Java using netbeans\\Classroom\\icons\\icons8-pdf-80.png");
            filetype = "Pdf";
        } else if (rgb2.isSelected()) {
            jfc.setFileFilter(filteraudio);
            icon = new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\Java using netbeans\\Classroom\\icons\\icons8-mp3-80.png");
            filetype = "Audio";
        } else {
            jfc.setFileFilter(filtervideo);
            icon = new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\Java using netbeans\\Classroom\\icons\\icons8-mp3-80.png");
            filetype = "Video";
        }

        int showOpenDialog = jfc.showOpenDialog(this);
        if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            lb1.setIcon(icon);
        }
    }//GEN-LAST:event_bt1ActionPerformed
    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        String semester = (String)tf2.getSelectedItem();
        String course = (String)tf1.getSelectedItem();
        String title = tf3.getText();
        String email = tf4.getText();
        String detail = tf5.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = sdf.format(new Date());
        String ans = MyClient.addNotes(semester, course, email, title, detail, date, filetype, file);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "Added Successfully");
        } 
        else{
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_bt2ActionPerformed

    private void tf1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tf1ItemStateChanged
        // TODO add your handling code here:
        String selectedSemester = (String)tf1.getSelectedItem();
        fetchSemester(selectedSemester);
    }//GEN-LAST:event_tf1ItemStateChanged
    private void rgb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rgb1ActionPerformed
    private void rgb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rgb2ActionPerformed

    private void tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4ActionPerformed

    private void tf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf5ActionPerformed

    private void rgb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rgb3ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AddNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNotes().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lb1;
    private javax.swing.JRadioButton rgb1;
    private javax.swing.JRadioButton rgb2;
    private javax.swing.JRadioButton rgb3;
    private javax.swing.JComboBox<String> tf1;
    private javax.swing.JComboBox<String> tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    // End of variables declaration//GEN-END:variables
}
