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
public class model_pemesanan {
    
    private String no_pesan;
    private String tgl_pesan;
    private Long total_pesan;
    private model_distributor iddistributor;
    private model_pengguna idpengguna;

    public String getNo_pesan() {
        return no_pesan;
    }

    public void setNo_pesan(String no_pesan) {
        this.no_pesan = no_pesan;
    }

    public String getTgl_pesan() {
        return tgl_pesan;
    }

    public void setTgl_pesan(String tgl_pesan) {
        this.tgl_pesan = tgl_pesan;
    }

    public Long getTotal_pesan() {
        return total_pesan;
    }

    public void setTotal_pesan(Long total_pesan) {
        this.total_pesan = total_pesan;
    }

    public model_distributor getIddistributor() {
        return iddistributor;
    }

    public void setIddistributor(model_distributor iddistributor) {
        this.iddistributor = iddistributor;
    }

    public model_pengguna getIdpengguna() {
        return idpengguna;
    }

    public void setIdpengguna(model_pengguna idpengguna) {
        this.idpengguna = idpengguna;
    }
}
