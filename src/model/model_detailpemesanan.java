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
public class model_detailpemesanan {
    
    private model_pemesanan nopesan;
    private model_barang kodebarang;
    private Integer jumlah_pesan;
    private Long subtotatl_pesan;
    private String status;

    public model_pemesanan getNopesan() {
        return nopesan;
    }

    public void setNopesan(model_pemesanan nopesan) {
        this.nopesan = nopesan;
    }

    public model_barang getKodebarang() {
        return kodebarang;
    }

    public void setKodebarang(model_barang kodebarang) {
        this.kodebarang = kodebarang;
    }

    public Integer getJumlah_pesan() {
        return jumlah_pesan;
    }

    public void setJumlah_pesan(Integer jumlah_pesan) {
        this.jumlah_pesan = jumlah_pesan;
    }

    public Long getSubtotatl_pesan() {
        return subtotatl_pesan;
    }

    public void setSubtotatl_pesan(Long subtotatl_pesan) {
        this.subtotatl_pesan = subtotatl_pesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
