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
public class model_detail_barangkeluar {
    
    private model_barangKeluar nokeluar;
    private model_barang kodebarang;
    private Integer jumlah_keluar;
    private Long subtotal_keluar;

    public model_barangKeluar getNokeluar() {
        return nokeluar;
    }

    public void setNokeluar(model_barangKeluar nokeluar) {
        this.nokeluar = nokeluar;
    }

    public model_barang getKodebarang() {
        return kodebarang;
    }

    public void setKodebarang(model_barang kodebarang) {
        this.kodebarang = kodebarang;
    }

    public Integer getJumlah_keluar() {
        return jumlah_keluar;
    }

    public void setJumlah_keluar(Integer jumlah_keluar) {
        this.jumlah_keluar = jumlah_keluar;
    }

    public Long getSubtotal_keluar() {
        return subtotal_keluar;
    }

    public void setSubtotal_keluar(Long subtotal_keluar) {
        this.subtotal_keluar = subtotal_keluar;
    }
}
