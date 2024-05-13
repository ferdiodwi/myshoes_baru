/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_detail_barangkeluar;


/**
 *
 * @author ferdio
 */
public interface Service_DetBatangKeluar {
    void tambahData (model_detail_barangkeluar mod_detKeluar);
    void sumTotal (model_detail_barangkeluar mod_detKeluar);
    void hapusSementara (model_detail_barangkeluar mod_detKeluar);
    
    model_detail_barangkeluar getByid (String id);
    List<model_detail_barangkeluar> ambiData(String id);
    List<model_detail_barangkeluar> pencarian(String id);
    boolean validasiStok (model_detail_barangkeluar mod_detKeluar);
    
}
