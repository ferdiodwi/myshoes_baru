/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_pengguna;

/**
 *
 * @author ferdio
 */
public interface Service_Pengguna {
    void tambahData     (model_pengguna mod_pengguna);
    void perbaruiData   (model_pengguna mod_pengguna);
    void hapusData      (model_pengguna mod_pengguna);
    
    model_pengguna getByid (String id);
    
    List<model_pengguna> ambilData();
    List<model_pengguna> pencarian(String id);
    
    String nomor();
}
