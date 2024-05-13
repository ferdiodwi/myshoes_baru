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
public class model_barangmasuk {
    
    private String no_masuk;
    private String tgl_masuk;
    private Long total_masuk;
    private model_distributor mod_distributor;
    private model_pengguna mod_pengguna;

    public String getNo_masuk() {
        return no_masuk;
    }

    public void setNo_masuk(String no_masuk) {
        this.no_masuk = no_masuk;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public Long getTotal_masuk() {
        return total_masuk;
    }

    public void setTotal_masuk(Long total_masuk) {
        this.total_masuk = total_masuk;
    }

    public model_distributor getMod_distributor() {
        return mod_distributor;
    }

    public void setMod_distributor(model_distributor mod_distributor) {
        this.mod_distributor = mod_distributor;
    }

    public model_pengguna getMod_pengguna() {
        return mod_pengguna;
    }

    public void setMod_pengguna(model_pengguna mod_pengguna) {
        this.mod_pengguna = mod_pengguna;
    }

   
}
