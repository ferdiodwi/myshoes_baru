/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_detail_barangmasuk;

/**
 *
 * @author ferdio
 */
public interface Service_DetBarangMasuk {
    void tambahData (model_detail_barangmasuk mod_detmasuk);
    void sumTotal (model_detail_barangmasuk mod_detmasuk);
    void hapusSementara (model_detail_barangmasuk mod_detmasuk);
    
    model_detail_barangmasuk getByid (String id);
    List<model_detail_barangmasuk> ambilData(String id);
}
