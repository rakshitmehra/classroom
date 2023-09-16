import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Welcome extends javax.swing.JFrame {
    JLabel lb1;
    public Welcome() {
        initComponents();
        loopPbar();
        setSize(500, 500);
        lb1 = new JLabel();
        lb1.setBounds(0,0,500, 500);
        ImageIcon ic = new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\Java using netbeans\\Classroom\\icons\\Image1.jpg");
        Image img = ic.getImage().getScaledInstance(lb1.getWidth(), lb1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        lb1.setIcon(ic1);
        getContentPane().add(lb1);
        setResizable(false);
    }
    void loopPbar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    pb1.setValue(i);
                    lb5.setText(i+"%");
                    try {
                        Thread.sleep(100);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                Server obj = new Server();
                obj.setVisible(true);
                dispose();
            }
        }).start();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pb1 = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to Classroom");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 43);

        jLabel2.setText("Devoloped under:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(66, 61, 100, 26);

        jLabel3.setText("Submitted by :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(66, 105, 100, 26);

        jLabel4.setText("VMM");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(196, 61, 170, 26);

        jLabel5.setText("Rakshit Mehra");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(196, 105, 170, 26);
        getContentPane().add(pb1);
        pb1.setBounds(66, 192, 374, 19);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(279, 321, 177, 25);
        getContentPane().add(lb5);
        lb5.setBounds(440, 190, 37, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lb5;
    private javax.swing.JProgressBar pb1;
    // End of variables declaration//GEN-END:variables
}
