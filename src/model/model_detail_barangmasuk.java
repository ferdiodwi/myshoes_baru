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
public class model_detail_barangmasuk {
    
    private model_barangmasuk nomasuk;
    private model_barang kodebarnag;
    private Integer jumlah_masuk;
    private Long subtotal_masuk;

    public model_barangmasuk getNomasuk() {
        return nomasuk;
    }

    public void setNomasuk(model_barangmasuk nomasuk) {
        this.nomasuk = nomasuk;
    }

    public model_barang getKodebarnag() {
        return kodebarnag;
    }

    public void setKodebarnag(model_barang kodebarnag) {
        this.kodebarnag = kodebarnag;
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
