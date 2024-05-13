/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ferdio
 */
public class model_semPesan {
    
    private model_barang kodebarang;
    private String nama_barang;
    private Long harga;
    private Integer jumlah_pesan;
    private Long subtotal_pesan;
    private String status;

    public model_barang getKodebarang() {
        return kodebarang;
    }

    public void setKodebarang(model_barang kodebarang) {
        this.kodebarang = kodebarang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public Integer getJumlah_pesan() {
        return jumlah_pesan;
    }

    public void setJumlah_pesan(Integer jumlah_pesan) {
        this.jumlah_pesan = jumlah_pesan;
    }

    public Long getSubtotal_pesan() {
        return subtotal_pesan;
    }

    public void setSubtotal_pesan(Long subtotal_pesan) {
        this.subtotal_pesan = subtotal_pesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
