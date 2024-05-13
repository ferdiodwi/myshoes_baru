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
public class model_barangKeluar {
    
    private String no_keluar;
    private String tgl_keluar;
    private Long total_keluar;
    private model_pengguna mod_pengguna;

    public String getNo_keluar() {
        return no_keluar;
    }

    public void setNo_keluar(String no_keluar) {
        this.no_keluar = no_keluar;
    }

    public String getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(String tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    public Long getTotal_keluar() {
        return total_keluar;
    }

    public void setTotal_keluar(Long total_keluar) {
        this.total_keluar = total_keluar;
    }

    public model_pengguna getMod_pengguna() {
        return mod_pengguna;
    }

    public void setMod_pengguna(model_pengguna mod_pengguna) {
        this.mod_pengguna = mod_pengguna;
    }

    
}
