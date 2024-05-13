/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_jenis_barang;

/**
 *
 * @author ferdio
 */
public interface Service_JenisBarang {
     void tambahData     (model_jenis_barang mod_Jenbar);
    void perbaruiData   (model_jenis_barang mod_Jenbar);
    void hapusData      (model_jenis_barang mod_Jenbar);
    
    model_jenis_barang getByid (String id);
    
    List<model_jenis_barang> ambilData();
    List<model_jenis_barang> pencarian(String id);
    
    String nomor();
    
    boolean validasiNamaJenisBarang(model_jenis_barang mod_Jenbar);
    
    
}
