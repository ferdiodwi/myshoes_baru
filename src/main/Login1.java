/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import config.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import main.menu_utama;

/**
 *
 * @author Lenovo
 */
public class Login1 extends javax.swing.JFrame {

    int xx, xy;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();

    /**
     * Creates new form Login
     */
    public Login1() {
        initComponents();
        k.connect();
        
        lb_hidePassword.setVisible(false);
    }


    
    
    class user {
        int id_user, id_level;
        String username, password, nama_user;
        
        public user() {
            this.id_user = 0;
            this.username = jTextField2.getText();
            this.password = txt_password.getText();
            this.nama_user = "";
        }
    }
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lb_showPassword = new javax.swing.JLabel();
        lb_hidePassword = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg-login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 520));

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_showPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_showPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_eye_20px_3.png"))); // NOI18N
        lb_showPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_showPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_showPasswordMouseClicked(evt);
            }
        });
        jPanel2.add(lb_showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 253, 43, 39));

        lb_hidePassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_hidePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_invisible_20px_1.png"))); // NOI18N
        lb_hidePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_hidePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_hidePasswordMouseClicked(evt);
            }
        });
        jPanel2.add(lb_hidePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 253, 43, 39));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hello! Let's get started");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 79, 362, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 121, 300, 26));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 220, 314, 26));

        jLabel10.setForeground(new java.awt.Color(199, 226, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Forget Password?");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 332, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 118, 211));
        jButton1.setText("LOGIN");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 381, 300, 40));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_user_20px_1.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 154, 43, 39));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Login");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 17, 132, -1));

        jTextField2.setBackground(new java.awt.Color(25, 118, 211));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 154, 252, 39));

        txt_password.setBackground(new java.awt.Color(25, 118, 211));
        txt_password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 253, 252, 39));

        jLabel2.setForeground(new java.awt.Color(199, 226, 255));
        jLabel2.setText("Don't have an account?");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 439, -1, -1));

        jLabel6.setForeground(new java.awt.Color(199, 226, 255));
        jLabel6.setText("Sign Up");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 439, -1, -1));

        jCheckBox2.setBackground(new java.awt.Color(25, 118, 211));
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Remember Password");
        jPanel2.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 328, 189, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_close_window_30px_1.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 0, -1, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        user u = new user();
        try {
            this.stat = k.getCon().prepareStatement("select * from user where "
                    + " username='"+u.username+"' and password='"+u.password+"';");
            this.rs = this.stat.executeQuery();
            while (rs.next()){
                u.id_level = rs.getInt("id_level");
            }
            if (u.id_level==0){
                JOptionPane.showMessageDialog(null, "AKUN TIDAK DITEMUKAN");
            }
            else {
                switch (u.id_level){
                    case 1:
                        menu_utama hom = new menu_utama();
                        hom.setVisible(true);
                        this.setVisible(false);
                        break;
                        
                    case 2:
                        menu_utama1 tran = new menu_utama1();
                        tran.setVisible(true);
                        this.setVisible(false);
                        break;

                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        register reg = new register();
        reg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        user u = new user();
        try {
            this.stat = k.getCon().prepareStatement("select * from user where "
                    + " username='"+u.username+"' and password='"+u.password+"';");
            this.rs = this.stat.executeQuery();
            while (rs.next()){
                u.id_level = rs.getInt("id_level");
            }
            if (u.id_level==0){
                JOptionPane.showMessageDialog(null, "AKUN TIDAK DITEMUKAN");
            }
            else {
                switch (u.id_level){
                    case 1:
                        menu_utama hom = new menu_utama();
                        hom.setVisible(true);
                        this.setVisible(false);
                        break;
                        
                    case 2:
                        menu_utama1 tran = new menu_utama1();
                        tran.setVisible(true);
                        this.setVisible(false);
                        break;

                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        RFID rf = new RFID();
        rf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void lb_showPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_showPasswordMouseClicked
        // TODO add your handling code here:
        lb_showPassword.setVisible(false);
        lb_hidePassword.setVisible(true);
        txt_password.setEchoChar((char)0);
    }//GEN-LAST:event_lb_showPasswordMouseClicked

    private void lb_hidePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_hidePasswordMouseClicked
        // TODO add your handling code here:
        lb_showPassword.setVisible(true);
        lb_hidePassword.setVisible(false);
        txt_password.setEchoChar('*');
    }//GEN-LAST:event_lb_hidePasswordMouseClicked

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
        user u = new user();
        try {
            this.stat = k.getCon().prepareStatement("select * from user where "
                    + " username='"+u.username+"' and password='"+u.password+"';");
            this.rs = this.stat.executeQuery();
            while (rs.next()){
                u.id_level = rs.getInt("id_level");
            }
            if (u.id_level==0){
                JOptionPane.showMessageDialog(null, "AKUN TIDAK DITEMUKAN");
            }
            else {
                switch (u.id_level){
                    case 1:
                        menu_utama hom = new menu_utama();
                        hom.setVisible(true);
                        this.setVisible(false);
                        break;
                        
                    case 2:
                        menu_utama1 tran = new menu_utama1();
                        tran.setVisible(true);
                        this.setVisible(false);
                        break;

                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txt_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lb_hidePassword;
    private javax.swing.JLabel lb_showPassword;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
