/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main;

import config.koneksi;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferdio
 */
public class Form_Karyawan extends javax.swing.JPanel {
    koneksi k = new koneksi();

    /**
     * Creates new form Form_Karyawan
     */
    public Form_Karyawan() {
        initComponents();
        k.connect();
        datatable_Karyawan();
        auto_id();
    }

    
    
    public void datatable_Karyawan(){
        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Id_Karyawan");
        tbl.addColumn("Nama Karyawan");
        tbl.addColumn("Jabatan");
        tbl.addColumn("Gaji");
        tbl.addColumn("No telp");
        table_karyawan.setModel(tbl);
        try {
            Statement statement=(Statement)k.getCon().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM karyawan");
            while(res.next())
            {
                tbl.addRow(new Object[]{
                res.getString("id_karyawan"),
                res.getString("nama_karyawan"),
                res.getString("jabatan"),
                res.getInt("gaji"),
                res.getString("notelp")
            });
            table_karyawan.setModel(tbl);
                
            }
            
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(null, "salah");
        }
        
    }
    
    
    
    private void auto_id(){
        try {
            String sql = "SELECT * FROM karyawan ORDER BY id_karyawan DESC";
            Connection con = (Connection) k.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()){
                String id_karyawan = rs.getString("id_karyawan").substring(2);
                String tr = "" + (Integer.parseInt(id_karyawan)+1);
                String nol = "";
                
                if(tr.length()==1)
                {nol = "00";}
                else if (tr.length()==2)
                {nol = "0";}
                else if (tr.length()==3)
                {nol = "";}
                txt_id_karyawan.setText("KA"+ nol + tr);
            }else{
                txt_id_karyawan.setText("KA001");
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    void cari_karyawan(){
    DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Id_Karyawan");
        tbl.addColumn("Nama Karyawan");
        tbl.addColumn("Jabatan");
        tbl.addColumn("Gaji");
        tbl.addColumn("NO telp");
        table_karyawan.setModel(tbl);
        
        try {
            String sql = " SELECT * FROM karyawan WHERE id_karyawan like '%" + txt_cari.getText() + "%'";
             Connection con = (Connection) k.getCon();
             Statement stat = con.createStatement();
             ResultSet res = stat.executeQuery(sql);
             
             while(res.next())
            {
                tbl.addRow(new Object[]{
                res.getString("id_karyawan"),
                res.getString("nama_karyawan"),
                res.getString("jabatan"),
                res.getInt("gaji"),
                res.getString("notelp")
            });
            table_karyawan.setModel(tbl);
                
            }
        } catch (Exception e) {
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        dataKaryawan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_karyawan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle7 = new rojerusan.RSMaterialButtonRectangle();
        txt_cari = new javax.swing.JTextField();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        tambahKaryawan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        jLabel5 = new javax.swing.JLabel();
        txt_id_karyawan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_jabatan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_gaji = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_notelp = new javax.swing.JTextField();
        rSMaterialButtonRectangle8 = new rojerusan.RSMaterialButtonRectangle();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        dataKaryawan.setBackground(new java.awt.Color(255, 255, 255));

        table_karyawan.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        table_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_karyawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_karyawan);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Data Karyawan");

        rSMaterialButtonRectangle1.setText("Tambah");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle2.setText("Hapus");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle7.setText("edit");
        rSMaterialButtonRectangle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle7ActionPerformed(evt);
            }
        });

        txt_cari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_cari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(102, 102, 102));
        rSMaterialButtonRectangle3.setText("cari");
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataKaryawanLayout = new javax.swing.GroupLayout(dataKaryawan);
        dataKaryawan.setLayout(dataKaryawanLayout);
        dataKaryawanLayout.setHorizontalGroup(
            dataKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataKaryawanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(dataKaryawanLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 561, Short.MAX_VALUE))
                    .addGroup(dataKaryawanLayout.createSequentialGroup()
                        .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dataKaryawanLayout.setVerticalGroup(
            dataKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataKaryawanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(dataKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dataKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
        );

        mainPanel.add(dataKaryawan, "card2");

        tambahKaryawan.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Tambah Karyawan");

        rSMaterialButtonRectangle4.setText("SIMPAN");
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle5.setBackground(new java.awt.Color(255, 204, 51));
        rSMaterialButtonRectangle5.setText("Batal");
        rSMaterialButtonRectangle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("ID Karyawan");

        txt_id_karyawan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_id_karyawan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_id_karyawan.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Nama ");

        txt_nama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_nama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Jabatan");

        txt_jabatan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_jabatan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Gaji");

        txt_gaji.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_gaji.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("No Telp");

        txt_notelp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_notelp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        rSMaterialButtonRectangle8.setText("edit");
        rSMaterialButtonRectangle8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tambahKaryawanLayout = new javax.swing.GroupLayout(tambahKaryawan);
        tambahKaryawan.setLayout(tambahKaryawanLayout);
        tambahKaryawanLayout.setHorizontalGroup(
            tambahKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahKaryawanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tambahKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_id_karyawan)
                    .addComponent(txt_nama)
                    .addComponent(txt_notelp)
                    .addComponent(txt_gaji)
                    .addComponent(txt_jabatan)
                    .addGroup(tambahKaryawanLayout.createSequentialGroup()
                        .addGroup(tambahKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addGroup(tambahKaryawanLayout.createSequentialGroup()
                                .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSMaterialButtonRectangle8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSMaterialButtonRectangle5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 373, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tambahKaryawanLayout.setVerticalGroup(
            tambahKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahKaryawanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(tambahKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_gaji, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_notelp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        mainPanel.add(tambahKaryawan, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(tambahKaryawan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void rSMaterialButtonRectangle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle5ActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(dataKaryawan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_rSMaterialButtonRectangle5ActionPerformed

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
        String id_karyawan = txt_id_karyawan.getText();
        String nama_karyawan = txt_nama.getText();
        String jabatan = txt_jabatan.getText();
        int gaji = Integer.parseInt(txt_gaji.getText());
        String notelp = txt_notelp.getText();
                

        try {
            Statement statement = (Statement) k.getCon().createStatement();
            statement.executeUpdate("insert into karyawan (id_karyawan, nama_karyawan, jabatan, gaji, notelp) VALUES ('"+id_karyawan+"','"+nama_karyawan+"','"+jabatan+"','"+gaji+"','"+notelp+"');");
            txt_id_karyawan.setText("");
            txt_nama.setText("");
            txt_jabatan.setText("");
            txt_gaji.setText("");
            txt_notelp.setText("");
            statement.close();
            JOptionPane.showMessageDialog(null, "data berhasil dimpan");
            mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(dataKaryawan);
        mainPanel.repaint();
        mainPanel.revalidate();
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
        }
        datatable_Karyawan();
        auto_id();
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void rSMaterialButtonRectangle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle7ActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(tambahKaryawan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_rSMaterialButtonRectangle7ActionPerformed

    private void rSMaterialButtonRectangle8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle8ActionPerformed
        // TODO add your handling code here:
        String id_karyawan = txt_id_karyawan.getText();
        String nama_karyawan = txt_nama.getText();
        String jabatan = txt_jabatan.getText();
        int gaji = Integer.parseInt(txt_gaji.getText());
        String notelp = txt_notelp.getText();
        
        try {
            Statement statement = (Statement) k.getCon().createStatement();
            statement.executeUpdate("update karyawan set nama_karyawan='"+ txt_nama.getText() +"',jabatan='" + txt_jabatan.getText() +"',gaji='" + txt_gaji.getText()+"',notelp='" + txt_notelp.getText() +"' where id_karyawan='"+ txt_id_karyawan.getText() +"'");
            JOptionPane.showMessageDialog(this, "data berhasil di edit");
            txt_nama.setText("");
            txt_jabatan.setText("");
            txt_gaji.setText("");
            txt_notelp.setText("");
            txt_id_karyawan.setText("");
            mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(dataKaryawan);
        mainPanel.repaint();
        mainPanel.revalidate();
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(this, "data gagal di edit");
        }
        datatable_Karyawan();
        auto_id();
    }//GEN-LAST:event_rSMaterialButtonRectangle8ActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        // TODO add your handling code here:
        String id_karyawan = txt_id_karyawan.getText();

        try {
            Statement statement = (Statement) k.getCon().createStatement();
            statement.executeUpdate(" DELETE from karyawan where id_karyawan=('"+id_karyawan+"');");
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            txt_id_karyawan.setText("");
            txt_nama.setText("");
            txt_jabatan.setText("");
            txt_gaji.setText("");
            txt_notelp.setText("");
            txt_nama.requestFocus();
        } catch (HeadlessException | SQLException t) {
            JOptionPane.showMessageDialog(null, "data gagal dihapus");
        }
        datatable_Karyawan();
        auto_id();
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void table_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_karyawanMouseClicked
        // TODO add your handling code here:
        int baris = table_karyawan.rowAtPoint(evt.getPoint());
        
        String id = table_karyawan.getValueAt(baris, 0).toString();
        txt_id_karyawan.setText(id);
        
        String nama = table_karyawan.getValueAt(baris, 1).toString();
        txt_nama.setText(nama);
        
        String jabatan = table_karyawan.getValueAt(baris, 2).toString();
        txt_jabatan.setText(jabatan);
        
        String gaji = table_karyawan.getValueAt(baris, 3).toString();
        txt_gaji.setText(gaji);
        
        String notelp = table_karyawan.getValueAt(baris, 4).toString();
        txt_notelp.setText(notelp);
    }//GEN-LAST:event_table_karyawanMouseClicked

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        // TODO add your handling code here:
        cari_karyawan();
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dataKaryawan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle8;
    private javax.swing.JTable table_karyawan;
    private javax.swing.JPanel tambahKaryawan;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_gaji;
    private javax.swing.JTextField txt_id_karyawan;
    private javax.swing.JTextField txt_jabatan;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_notelp;
    // End of variables declaration//GEN-END:variables
}