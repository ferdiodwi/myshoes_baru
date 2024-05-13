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
public class model_semBarangmasuk {
    
    private model_barang kodebarang;
    private String nama_barang;
    private Long harga;
    private Integer jumlah_masuk;
    private Long subtotal_masuk;

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

    public Integer getJumlah_masuk() {
        return jumlah_masuk;
    }

    public void setJumlah_masuk(Integer jumlah_masuk) {
        this.jumlah_masuk = jumlah_masuk;
    }

    public Long getSubtotal_masuk() {
        return subtotal_masuk;
    }

    public void setSubtotal_masuk(Long subtotal_masuk) {
        this.subtotal_masuk = subtotal_masuk;
    }
}
