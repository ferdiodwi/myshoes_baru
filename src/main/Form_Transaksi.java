/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.barcodelib.barcode.Linear;
import config.koneksi;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRDesignViewer;
import net.sf.jasperreports.view.JasperViewer;
import table.*;

/**
 *
 * @author ferdio
 */
public class Form_Transaksi extends javax.swing.JPanel {
    koneksi k = new koneksi();

    /**
     * Creates new form Form_Transaksi
     */
    public Form_Transaksi() {
        initComponents();
        k.connect();
        auto_id();
        tanggal();
        datatable_transaksi();
        datatable_DataCustomer();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane3, TableCustom.TableType.DEFAULT);
    }    
    private boolean isValidEmail (String email) {
        return email.endsWith("@gmail.com") ||
        email.endsWith("@yahoo.com") ||
        email.endsWith("@outlook.com") ||
        email.endsWith("@aol.com") ||
        email.endsWith("@icloud.com") ||
        email.endsWith("@polije.ac.id");
    }
    
    
    
    public void tanggal(){
        DateFormat tgl = new SimpleDateFormat("dd/MM/yyyy");
        String htgl = tgl.format(Calendar.getInstance().getTime());
        txt_tanggalTran.setText(htgl);
    }
    
    
    private void total_harga() {
        lb_total.setText(TOOL_TIP_TEXT_KEY);
    }
    
    
    private void auto_id(){
        try {
            String sql = "SELECT * FROM laporan ORDER BY id_transaksi DESC";
            Connection con = (Connection) k.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()){
                String id_transaksi = rs.getString("id_transaksi").substring(6);
                String tr = "" + (Integer.parseInt(id_transaksi)+1);
                String nol = "";
                
                if(tr.length()==1)
                {nol = "00";}
                else if (tr.length()==2)
                {nol = "0";}
                else if (tr.length()==3)
                {nol = "";}
                txt_idTran.setText("TRNSKS"+ nol + tr);
            }else{
                txt_idTran.setText("TRNSKS001");
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    void cari_customer(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Customer");
        tbl.addColumn("Nama");
        tbl.addColumn("No Telp");
        tabel_dataCus.setModel(tbl);
        
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
            tabel_dataCus.setModel(tbl);
                
            }
        } catch (Exception e) {
        }
    }
    
    
    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) tabel1.getModel();
        model.addRow(new Object[]{
            txt_idTran.getText(),
            txt_idCUS.getText(),
            txt_namaCUS.getText(),
            txt_notelpCUS.getText(),
            txt_sepatu.getText(),
            combo_jenispaket.getSelectedItem(),
            txt_tanggalTran.getText(),
            txt_harga.getText()
        });
    }
    
    
    
    
    public void datatable_DataCustomer(){
        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Customer");
        tbl.addColumn("Nama Customer");
        tbl.addColumn("No Telp");
        tabel_dataCus.setModel(tbl);
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
            tabel_dataCus.setModel(tbl);
                
            }
            
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(null, "salah");
        }
        
    }
    
    
    public void datatable_transaksi(){
        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID transaksi");
        tbl.addColumn("Tanggal");
        tbl.addColumn("ID Customer");
        tbl.addColumn("Nama Customer");
        tbl.addColumn("NO Telp");
        tbl.addColumn("Sepatu");
        tbl.addColumn("Jenis Paket");
        tbl.addColumn("Tanggal Ambil");
        tbl.addColumn("Harga");
        tbl.addColumn("Total Harga");
        table_struk.setModel(tbl);
        try {
            Statement statement=(Statement)k.getCon().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM detail_transaksi");
            while(res.next())
            {
                tbl.addRow(new Object[]{
                res.getString("id_transaksi"),    
                res.getString("tanggal"),    
                res.getString("id_customer"),
                res.getString("nama_customer"),
                res.getString("notelp"),
                res.getString("sepatu"),
                res.getString("jenis_paket"),
                res.getString("tanggal_ambil"),
                res.getString("harga"),
                res.getString("total_harga"),
                res.getString("jumlah_bayar"),
                res.getString("jumlah_kembalian"),
            });
            table_struk.setModel(tbl);
                
            }
            
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(null, "salah");
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_idTran = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_tanggalTran = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_idCUS = new javax.swing.JTextField();
        txt_namaCUS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_notelpCUS = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_sepatu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        combo_jenispaket = new javax.swing.JComboBox<>();
        txt_harga = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_struk = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        txt_totalHarga_transaksi = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_jumlah_bayar_transaksi = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_jumlah_kembalian_transaksi = new javax.swing.JTextField();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lb_total1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_dataCus = new javax.swing.JTable();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        btn_pint = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle7 = new rojerusan.RSMaterialButtonRectangle();
        txt_cari = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Transaksi");

        jPanel1.setBackground(new java.awt.Color(0, 112, 192));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID Transaksi");

        txt_idTran.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_idTran.setEnabled(false);
        txt_idTran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idTranActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tanggal");

        txt_tanggalTran.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_tanggalTran.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_idTran, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tanggalTran, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tanggalTran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idTran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(0, 112, 192));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Customer");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("ID Customer");

        txt_idCUS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_idCUS.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_idCUS.setEnabled(false);

        txt_namaCUS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_namaCUS.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_namaCUS.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Nama Customer");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("No Telp");

        txt_notelpCUS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_notelpCUS.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_notelpCUS.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_namaCUS)
                            .addComponent(txt_notelpCUS)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_idCUS))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_idCUS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_namaCUS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_notelpCUS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(0, 112, 192));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Barang");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Sepatu");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Jenis Paket");

        txt_sepatu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_sepatu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Tanggal Ambil");

        rSMaterialButtonRectangle3.setText("Tambah");
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });

        combo_jenispaket.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        combo_jenispaket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "....", "fast cleaning", "whitening", "deep cleaning" }));
        combo_jenispaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_jenispaketActionPerformed(evt);
            }
        });

        txt_harga.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_harga.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Harga");

        jDateChooser.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sepatu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combo_jenispaket, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_harga)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_sepatu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_jenispaket, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaksi", "Tanggal", "ID Customer", "Nama Customer", "No Telp", "Sepatu", "Jenis Paket", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tabel1);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Total Harga");

        lb_total.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lb_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_total.setText("-");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(lb_total, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_total, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        table_struk.setModel(new javax.swing.table.DefaultTableModel(
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
        table_struk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_strukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_struk);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Total Harga");

        txt_totalHarga_transaksi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_totalHarga_transaksi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_totalHarga_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalHarga_transaksiActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Tunai");

        txt_jumlah_bayar_transaksi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_jumlah_bayar_transaksi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_jumlah_bayar_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlah_bayar_transaksiActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("jumlah kembalian");

        txt_jumlah_kembalian_transaksi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_jumlah_kembalian_transaksi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_jumlah_kembalian_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlah_kembalian_transaksiActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle4.setText("simpan");
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Kembalian");

        lb_total1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lb_total1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_total1.setText("-");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(lb_total1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_total1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        tabel_dataCus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tabel_dataCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_dataCusMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel_dataCus);

        rSMaterialButtonRectangle5.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle5.setText("hapus");
        rSMaterialButtonRectangle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle5ActionPerformed(evt);
            }
        });

        btn_pint.setBackground(new java.awt.Color(102, 102, 102));
        btn_pint.setText("print");
        btn_pint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pintActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle7.setText("bayar");
        rSMaterialButtonRectangle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle7ActionPerformed(evt);
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

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_30px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(376, 376, 376))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSMaterialButtonRectangle5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(503, 503, 503)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_jumlah_kembalian_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_jumlah_bayar_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_totalHarga_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cari)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_jumlah_bayar_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_jumlah_kembalian_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_totalHarga_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21))
                                    .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rSMaterialButtonRectangle5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btn_pint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String id_tran = txt_idTran.getText();
        String tanggal = txt_tanggalTran.getText();
        String id_cus = txt_idCUS.getText();
        String nama = txt_namaCUS.getText();
        String notelp = txt_notelpCUS.getText();
        String sepatu = txt_sepatu.getText();
        String jenis = (String) combo_jenispaket.getSelectedItem();
        int harga = Integer.parseInt(txt_harga.getText());
        
        DefaultTableModel tbl = (DefaultTableModel) tabel1.getModel();
        
        tbl.addRow(new Object[]{
            id_tran,
            tanggal,
            id_cus,
            nama,
            notelp,
            sepatu,
            jenis,
            harga
        });
        
        int TotalHarga =0;
        for(int i=0; i<tabel1.getRowCount();i++){
            TotalHarga += Integer.parseInt(tabel1.getValueAt(i, 7).toString());
            lb_total.setText(""+TotalHarga);
            
        }
        txt_totalHarga_transaksi.setText(""+TotalHarga);
        txt_idTran.setText("");
        txt_tanggalTran.setText("");
        txt_idCUS.setText("");
        txt_namaCUS.setText("");
        txt_notelpCUS.setText("");
        txt_sepatu.setText("");
        combo_jenispaket.setSelectedItem("");
        txt_harga.setText("");
        //loadData();
        auto_id();
        tanggal();
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void combo_jenispaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_jenispaketActionPerformed
        // TODO add your handling code here:
        String jenis_paket=(String)this.combo_jenispaket.getSelectedItem();
        switch (jenis_paket) {
            case "fast cleaning":
                txt_harga.setText("25000");
                break;
            case "whitening":
                txt_harga.setText("70000");
                break;
            case "deep cleaning":
                txt_harga.setText("45000");
                break;
        }
    }//GEN-LAST:event_combo_jenispaketActionPerformed

    private void txt_totalHarga_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalHarga_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalHarga_transaksiActionPerformed

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
        Connection con = (Connection) k.getCon();
        Statement stat;

        DefaultTableModel model = (DefaultTableModel) tabel1.getModel();
        

        int total_harga = Integer.parseInt(txt_totalHarga_transaksi.getText());
        int jumlah_bayar = Integer.parseInt(txt_jumlah_bayar_transaksi.getText());
        int jumlah_kembalian = Integer.parseInt(txt_jumlah_kembalian_transaksi.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        String tanggal_ambil = sdf.format(jDateChooser.getDate());

        try {
            stat = con.createStatement();

            for(int i = 0; i < model.getRowCount(); i++){

                String id_transaksi = model.getValueAt(i, 0).toString();
                String tanggal = model.getValueAt(i, 1).toString();
                String id_customer = model.getValueAt(i, 2).toString();
                String nama_customer = model.getValueAt(i, 3).toString();
                String notelp = model.getValueAt(i, 4).toString();
                String sepatu = model.getValueAt(i, 5).toString();
                String jenis_paket = model.getValueAt(i, 6).toString();
                
                int harga = Integer.valueOf(model.getValueAt(i, 7).toString());


                String sqlQuery = "INSERT INTO detail_transaksi (id_transaksi, tanggal, id_customer, nama_customer, notelp, sepatu, jenis_paket, tanggal_ambil, harga, total_harga, jumlah_bayar, jumlah_kembalian) VALUES ('"+id_transaksi+"','"+tanggal+"','"+id_customer+"','"+nama_customer+"','"+notelp+"','"+sepatu+"','"+jenis_paket+"', '"+tanggal_ambil+"','"+harga+"', '"+total_harga+"','"+jumlah_bayar+"','"+jumlah_kembalian+"')";

                stat.addBatch(sqlQuery);
                
                txt_totalHarga_transaksi.setText("");
                txt_jumlah_bayar_transaksi.setText("");
                txt_jumlah_kembalian_transaksi.setText("");
                lb_total.setText("");
                lb_total1.setText("");
            }

            int[] rowInserted = stat.executeBatch();
            System.out.println("Data Inserted");
            System.out.println("rowInserted Count = " + rowInserted.length);

            JOptionPane.showMessageDialog(null, "success");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        datatable_transaksi();
        auto_id();

        DefaultTableModel tableModel = (DefaultTableModel) tabel1.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void txt_jumlah_bayar_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlah_bayar_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlah_bayar_transaksiActionPerformed

    private void txt_jumlah_kembalian_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlah_kembalian_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlah_kembalian_transaksiActionPerformed

    private void txt_idTranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idTranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idTranActionPerformed

    private void table_strukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_strukMouseClicked
        // TODO add your handling code here:
        int baris = table_struk.rowAtPoint(evt.getPoint());
        
        String id = table_struk.getValueAt(baris, 0).toString();
        txt_idTran.setText(id);
        
        String tanggal = table_struk.getValueAt(baris, 1).toString();
        txt_tanggalTran.setText(tanggal);
        
        String id_cus = table_struk.getValueAt(baris, 2).toString();
        txt_idCUS.setText(id_cus);
        
        String nama = table_struk.getValueAt(baris, 3).toString();
        txt_namaCUS.setText(nama);
        
        String notelp = table_struk.getValueAt(baris, 4).toString();
        txt_notelpCUS.setText(notelp);
        
        String sepatu = table_struk.getValueAt(baris, 5).toString();
        txt_sepatu.setText(sepatu);
        
        String jenis = table_struk.getValueAt(baris, 6).toString();
        combo_jenispaket.setSelectedItem(jenis);
        
        String tanggal_ambil = table_struk.getValueAt(baris, 7).toString();
        jDateChooser.setDateFormatString(tanggal_ambil);
        
        String harga = table_struk.getValueAt(baris, 8).toString();
        txt_harga.setText(harga);
    }//GEN-LAST:event_table_strukMouseClicked

    private void tabel_dataCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_dataCusMouseClicked
        // TODO add your handling code here:
        int baris = tabel_dataCus.rowAtPoint(evt.getPoint());
        
        String id = tabel_dataCus.getValueAt(baris, 0).toString();
        txt_idCUS.setText(id);
        
        String nama = tabel_dataCus.getValueAt(baris, 1).toString();
        txt_namaCUS.setText(nama);
        
        String notelp = tabel_dataCus.getValueAt(baris, 2).toString();
        txt_notelpCUS.setText(notelp);
    }//GEN-LAST:event_tabel_dataCusMouseClicked

    private void rSMaterialButtonRectangle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle5ActionPerformed
        // TODO add your handling code here:
        String id_transaksi = txt_idTran.getText();

        try {
            Statement statement = (Statement) k.getCon().createStatement();
            statement.executeUpdate(" DELETE from detail_transaksi where id_transaksi = ('"+id_transaksi+"');");
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            txt_idCUS.setText("");
            txt_namaCUS.setText("");
            txt_notelpCUS.setText("");
            txt_sepatu.setText("");
            combo_jenispaket.setSelectedItem("");
            txt_harga.setText("");
            txt_totalHarga_transaksi.setText("");
            txt_jumlah_bayar_transaksi.setText("");
            txt_jumlah_kembalian_transaksi.setText("");
            lb_total.setText("");
            lb_total1.setText("");
            txt_idTran.requestFocus();
        } catch (HeadlessException | SQLException t) {
            JOptionPane.showMessageDialog(null, "data gagal dihapus");
        }
        datatable_transaksi();
        auto_id();
    }//GEN-LAST:event_rSMaterialButtonRectangle5ActionPerformed

    private void btn_pintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pintActionPerformed
        // TODO add your handling code here:
        try {
        File namafile = new File("src/laporan/struk_penjualan_1.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, k.getCon());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        try {
            Linear barcode = new Linear();
            barcode.setType(Linear.CODE128);
            barcode.setData(txt_idTran.getText());
            barcode.setI(11.0f);
            
            String Filename = txt_idTran.getText();
            
            barcode.renderBarcode(("C:\\Users\\ferdi\\OneDrive\\Documents\\NetBeansProjects\\renz_billiard\\src\\laporan\\" + Filename + ".png"));
            ImageIcon imgThisImg = new ImageIcon("src"+"/"+"image"+txt_idTran.getText()+".jpg");
            jLabel2.setIcon(imgThisImg);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_pintActionPerformed

    private void rSMaterialButtonRectangle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle7ActionPerformed
        // TODO add your handling code here:
        int totalharga = Integer.parseInt(txt_totalHarga_transaksi.getText());
        int JumlahBayar = Integer.parseInt(txt_jumlah_bayar_transaksi.getText());
        int kembalian = JumlahBayar - totalharga;
        txt_jumlah_kembalian_transaksi.setText(""+kembalian);     
        lb_total1.setText(""+kembalian);
    }//GEN-LAST:event_rSMaterialButtonRectangle7ActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
        cari_customer();
    }//GEN-LAST:event_txt_cariActionPerformed

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        // TODO add your handling code here:
        cari_customer();
    }//GEN-LAST:event_txt_cariKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btn_pint;
    private javax.swing.JComboBox<String> combo_jenispaket;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_total;
    private javax.swing.JLabel lb_total1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private javax.swing.JTable tabel1;
    private javax.swing.JTable tabel_dataCus;
    private javax.swing.JTable table_struk;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_harga;
    public javax.swing.JTextField txt_idCUS;
    private javax.swing.JTextField txt_idTran;
    private javax.swing.JTextField txt_jumlah_bayar_transaksi;
    private javax.swing.JTextField txt_jumlah_kembalian_transaksi;
    public javax.swing.JTextField txt_namaCUS;
    public javax.swing.JTextField txt_notelpCUS;
    private javax.swing.JTextField txt_sepatu;
    private javax.swing.JTextField txt_tanggalTran;
    private javax.swing.JTextField txt_totalHarga_transaksi;
    // End of variables declaration//GEN-END:variables
}
