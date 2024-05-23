/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.koneksi;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import table.*;

/**
 *
 * @author ferdio
 */
public class Form_Data_Customer extends javax.swing.JPanel {
    
    private PreparedStatement stat;
    private ResultSet rs;
    private Connection con;
    koneksi k = new koneksi();
    
    private Statement st;
    private String sql="";
    
    private final int noColumindex = 0;
    private final int noColumWidth = 100;

    /**
     * Creates new form form_Barang
     */
    public Form_Data_Customer() {
        initComponents();
        k.connect();
        datatable_DataCustomer();
        auto_id();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
    }

    
    /*private void setcolumwidth() {
        TableColumnModel colommodel = table_dataCustomer.getColumnModel();
        colommodel.getColumn(noColumindex).setPreferredWidth(noColumWidth);
        colommodel.getColumn(noColumindex).setMaxWidth(noColumWidth);
        colommodel.getColumn(noColumindex).setMinWidth(noColumWidth);
    }*/
    
  
    public void datatable_DataCustomer(){
        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Customer");
        tbl.addColumn("Nama Customer");
        tbl.addColumn("No Telp");
        table_dataCustomer.setModel(tbl);
        try {
            Statement statement=(Statement)k.getCon().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM customer");
            while(res.next())
            {
                tbl.addRow(new Object[]{
                res.getString("id_customer"),
                res.getString("nama_customer"),
                res.getString("notelp")
            });
            table_dataCustomer.setModel(tbl);
                
            }
            
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(null, "salah");
        }
        
    }
    
    
    void cari_customer(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Customer");
        tbl.addColumn("Nama");
        tbl.addColumn("No Telp");
        table_dataCustomer.setModel(tbl);
        
        try {
            String sql = "SELECT * FROM customer WHERE id_customer like '%" + txt_cari.getText() + "%'" +
                    "or nama_customer like '%" + txt_cari.getText() + "%'";
             Connection con = (Connection) k.getCon();
             Statement stat = con.createStatement();
             ResultSet res = stat.executeQuery(sql);
             
             while(res.next())
            {
                tbl.addRow(new Object[]{
                res.getString("id_customer"),
                res.getString("nama_customer"),
                res.getString("notelp")
            });
            table_dataCustomer.setModel(tbl);
                
            }
        } catch (Exception e) {
        }
    }
    
    
    /*private void otomatis(){
        try {
            DateFormat vbinth = new SimpleDateFormat("ddMMYYYY");
            String binth = vbinth.format(Calendar.getInstance().getTime());
            
            DateFormat hari = new SimpleDateFormat("dd-MM-yyyy");
            String a = hari.format(Calendar.getInstance().getTime());
            
            String sql = "SELECT MAX(right (id_customer,3)) AS id_customer FROM customer";
            java.sql.Connection con = (Connection) k.getCon();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            
            while (res.next()){
                if (res.first() ==false) {
                    txt_idCustomer.setText("UPB001");
                }else{
                    res.last();
                    int auto_id = res.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int nomorjual = no.length();
                    //mengatur jumlah 0
                    for (int j = 0; j < 3 - nomorjual; j++) {
                        no = "0" + no;
                    }
                    txt_idCustomer.setText("UPB/" + no);
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }*/
    
    
   private void auto_id(){
        try {
            String sql = "SELECT * FROM customer ORDER BY id_customer DESC";
            Connection con = (Connection) k.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()){
                String id_customer = rs.getString("id_customer").substring(2);
                String tr = "" + (Integer.parseInt(id_customer)+1);
                String nol = "";
                
                if(tr.length()==1)
                {nol = "00";}
                else if (tr.length()==2)
                {nol = "0";}
                else if (tr.length()==3)
                {nol = "";}
                txt_idCustomer.setText("CS"+ nol + tr);
            }else{
                txt_idCustomer.setText("CS001");
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    /*private void auto_id(){
        String idCus = "CU000";
        int i = 0;
        
        try {
            String sql = "SELECT id_customer as a FROM customer ORDER BY id_customer DESC";
            Connection con = (Connection) k.getCon();
             Statement stat = con.createStatement();
             ResultSet res = stat.executeQuery(sql);
             while (rs.next()) {
                idCus = rs.getString("id_customer");   
            }
             idCus = idCus.substring(2);
             i = Integer.parseInt(idCus)+1;
             idCus = "00" +i;
             idCus = "CU" +idCus.substring(idCus.length()-3);
             txt_idCustomer.setText(idCus);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }*/
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        dataBarang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_dataCustomer = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        txt_cari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tambahBarang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_idCustomer = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_notelp = new javax.swing.JTextField();
        rSMaterialButtonRectangle7 = new rojerusan.RSMaterialButtonRectangle();

        setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        dataBarang.setBackground(new java.awt.Color(255, 255, 255));

        table_dataCustomer.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        table_dataCustomer.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        table_dataCustomer.setModel(new javax.swing.table.DefaultTableModel(
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
        table_dataCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dataCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_dataCustomer);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Data Customer");

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

        rSMaterialButtonRectangle6.setText("edit");
        rSMaterialButtonRectangle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle6ActionPerformed(evt);
            }
        });

        txt_cari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_cari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_30px.png"))); // NOI18N

        javax.swing.GroupLayout dataBarangLayout = new javax.swing.GroupLayout(dataBarang);
        dataBarang.setLayout(dataBarangLayout);
        dataBarangLayout.setHorizontalGroup(
            dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                    .addGroup(dataBarangLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(dataBarangLayout.createSequentialGroup()
                        .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSMaterialButtonRectangle6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        dataBarangLayout.setVerticalGroup(
            dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSMaterialButtonRectangle6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
        );

        mainPanel.add(dataBarang, "card2");

        tambahBarang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Tambah Data Barang");

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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("ID Customer");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Nama ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("No Telp");

        txt_idCustomer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_idCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_idCustomer.setEnabled(false);

        txt_nama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_nama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txt_notelp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_notelp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        rSMaterialButtonRectangle7.setText("edit");
        rSMaterialButtonRectangle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tambahBarangLayout = new javax.swing.GroupLayout(tambahBarang);
        tambahBarang.setLayout(tambahBarangLayout);
        tambahBarangLayout.setHorizontalGroup(
            tambahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tambahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_idCustomer)
                    .addComponent(txt_nama)
                    .addComponent(txt_notelp)
                    .addGroup(tambahBarangLayout.createSequentialGroup()
                        .addGroup(tambahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(tambahBarangLayout.createSequentialGroup()
                                .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSMaterialButtonRectangle5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addGap(0, 410, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tambahBarangLayout.setVerticalGroup(
            tambahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(tambahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_idCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_notelp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        mainPanel.add(tambahBarang, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(tambahBarang);
        mainPanel.repaint();
        mainPanel.revalidate();
        auto_id();
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        // TODO add your handling code here:
        String id_customer = txt_idCustomer.getText();

        try {
            Statement statement = (Statement) k.getCon().createStatement();
            statement.executeUpdate(" DELETE from customer where id_customer = ('"+id_customer+"');");
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            txt_idCustomer.setText("");
            txt_nama.setText("");
            txt_notelp.setText("");
            txt_idCustomer.requestFocus();
        } catch (HeadlessException | SQLException t) {
            JOptionPane.showMessageDialog(null, "data gagal dihapus");
        }
        datatable_DataCustomer();
        auto_id();
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void table_dataCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dataCustomerMouseClicked
        // TODO add your handling code here:
        int baris = table_dataCustomer.rowAtPoint(evt.getPoint());
        
        String id = table_dataCustomer.getValueAt(baris, 0).toString();
        txt_idCustomer.setText(id);
        
        String nama = table_dataCustomer.getValueAt(baris, 1).toString();
        txt_nama.setText(nama);
        
        String notelp = table_dataCustomer.getValueAt(baris, 2).toString();
        txt_notelp.setText(notelp);
    }//GEN-LAST:event_table_dataCustomerMouseClicked

    private void rSMaterialButtonRectangle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle6ActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(tambahBarang);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_rSMaterialButtonRectangle6ActionPerformed

    private void rSMaterialButtonRectangle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle7ActionPerformed
        // TODO add your handling code here:
        String id_customer = txt_idCustomer.getText();
        String nama = txt_nama.getText();
        String notelp = txt_notelp.getText();

        try {
            Statement statement = (Statement) k.getCon().createStatement();
            statement.executeUpdate("update customer set nama_customer='"+ txt_nama.getText() +"',notelp='" + txt_notelp.getText() +"'where id_customer='" + txt_idCustomer.getText() + "'");
            txt_idCustomer.setText("");
            txt_nama.setText("");
            txt_notelp.setText("");
            statement.close();
            JOptionPane.showMessageDialog(null, "data berhasil diedit");
            mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(dataBarang);
        mainPanel.repaint();
        mainPanel.revalidate();
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(null, "data gagal diedit");
        }
        datatable_DataCustomer();
        auto_id();
    }//GEN-LAST:event_rSMaterialButtonRectangle7ActionPerformed

    private void rSMaterialButtonRectangle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle5ActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(dataBarang);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_rSMaterialButtonRectangle5ActionPerformed

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
        String id_customer = txt_idCustomer.getText();
        String nama = txt_nama.getText();
        String notelp = txt_notelp.getText();

        try {
            Statement statement = (Statement) k.getCon().createStatement();
            statement.executeUpdate("insert into customer (id_customer, nama_customer, notelp) VALUES ('"+id_customer+"','"+nama+"','"+notelp+"');");
            txt_idCustomer.setText("");
            txt_nama.setText("");
            txt_notelp.setText("");
            statement.close();
            JOptionPane.showMessageDialog(null, "data berhasil dimpan");
            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();

            mainPanel.add(dataBarang);
            mainPanel.repaint();
            mainPanel.revalidate();
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
        }
        datatable_DataCustomer();
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(dataBarang);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
        cari_customer();
    }//GEN-LAST:event_txt_cariActionPerformed

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        // TODO add your handling code here:
         cari_customer();
    }//GEN-LAST:event_txt_cariKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dataBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private javax.swing.JTable table_dataCustomer;
    private javax.swing.JPanel tambahBarang;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_idCustomer;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_notelp;
    // End of variables declaration//GEN-END:variables
}
