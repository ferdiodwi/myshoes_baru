/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.koneksi;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import table.*;

/**
 *
 * @author ferdio
 */
public class Form_Laporan extends javax.swing.JPanel {
    
    private PreparedStatement stat;
    private ResultSet rs;
    private Connection con;
    koneksi k = new koneksi();
    
    private Statement st;
    private String sql="";
    
    private final int noColumindex = 0;
    private final int noColumWidth = 100;
    
    public static Connection connection;
    public static Statement statement;

    /**
     * Creates new form form_Barang
     */
    public Form_Laporan() {
        initComponents();
        k.connect();
        datatable_transaksi();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
    }

    
    /*private void setcolumwidth() {
        TableColumnModel colommodel = table_dataCustomer.getColumnModel();
        colommodel.getColumn(noColumindex).setPreferredWidth(noColumWidth);
        colommodel.getColumn(noColumindex).setMaxWidth(noColumWidth);
        colommodel.getColumn(noColumindex).setMinWidth(noColumWidth);
    }*/
    
    
    void cari_customer(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Customer");
        tbl.addColumn("Nama");
        tbl.addColumn("No Telp");
        table_struk.setModel(tbl);
        
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
            table_struk.setModel(tbl);
                
            }
        } catch (Exception e) {
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
        tbl.addColumn("Harga");
        tbl.addColumn("Total Harga");
        tbl.addColumn("Jumlah Bayar");
        tbl.addColumn("Jumlah Kembalian");
        table_struk.setModel(tbl);
        try {
            Statement statement=(Statement)k.getCon().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM laporan");
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
    
    
    public static void writeHeaderLine(XSSFSheet sheet){
        Row headerRow = sheet.createRow(0);
        
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("id_transaksi");
        
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("tanggal");
        
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("id_customer");
        
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("nama_customer");
        
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("notelp");
        
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("sepatu");
        
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("jenis_paket");
        
        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("tanggal_ambil");
        
        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("harga");
        
        headerCell = headerRow.createCell(9);
        headerCell.setCellValue("total_harga");
        
        headerCell = headerRow.createCell(10);
        headerCell.setCellValue("jumlah_bayar");
        
        headerCell = headerRow.createCell(11);
        headerCell.setCellValue("jumlah_kembalian");
        
        
    }
    
    
    public  static void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
        
        while(result.next()){
            String id_transaksi = result.getString("id_transaksi");
            String tanggal = result.getString("tanggal");
            String id_customer = result.getString("id_customer");
            String nama_customer = result.getString("nama_customer");
            String notelp = result.getString("notelp");
            String sepatu = result.getString("sepatu");
            String jenis_paket = result.getString("jenis_paket");
            String tanggal_ambil = result.getString("tanggal_ambil");
            String harga = result.getString("harga");
            String total_harga = result.getString("total_harga");
            String jumlah_bayar = result.getString("jumlah_bayar");
            String jumlah_kembalian = result.getString("jumlah_kembalian");
            
            Row row = sheet.createRow(rowCount++);
            
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id_transaksi);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(tanggal);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(id_customer);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(nama_customer);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(notelp);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(sepatu);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(jenis_paket);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(tanggal_ambil);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(harga);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(total_harga);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(jumlah_bayar);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(jumlah_kembalian);
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
        dataBarang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_struk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        txt_cari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();

        setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        dataBarang.setBackground(new java.awt.Color(255, 255, 255));

        table_struk.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        table_struk.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
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
        jScrollPane1.setViewportView(table_struk);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Laporan");

        rSMaterialButtonRectangle1.setText("print");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
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

        rSMaterialButtonRectangle2.setText("exel");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataBarangLayout = new javax.swing.GroupLayout(dataBarang);
        dataBarang.setLayout(dataBarangLayout);
        dataBarangLayout.setHorizontalGroup(
            dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataBarangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataBarangLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataBarangLayout.setVerticalGroup(
            dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataBarangLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mainPanel.add(dataBarang, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        // TODO add your handling code here:
        try {
        File namafile = new File("src/laporan/laporan.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, k.getCon());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void table_strukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_strukMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_table_strukMouseClicked

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
        cari_customer();
    }//GEN-LAST:event_txt_cariActionPerformed

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        // TODO add your handling code here:
        cari_customer();
    }//GEN-LAST:event_txt_cariKeyTyped

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        // TODO add your handling code here:
        String csvFilePath = "C:\\Users\\ferdi\\OneDrive\\Desktop\\laporan_exel\\Data.xlsx";
        
        try {
            String url = "jdbc:mysql://localhost/db_myshoess";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,pass);
            statement = connection.createStatement();
            
            String sql = "SELECT * FROM laporan";
            ResultSet resultSet = statement.executeQuery(sql);
            
            try(XSSFWorkbook workbook = new XSSFWorkbook()) {
                XSSFSheet sheet = workbook.createSheet("Report");
                
                writeHeaderLine(sheet);
                
                writeDataLines(resultSet, workbook, sheet);
                
                FileOutputStream outputStream = new FileOutputStream(csvFilePath);
                workbook.write(outputStream);
                
                workbook.close();
                
                statement.close();
                
                JOptionPane.showMessageDialog(null, "laporan berhasil disimpan");
                
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dataBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private javax.swing.JTable table_struk;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
