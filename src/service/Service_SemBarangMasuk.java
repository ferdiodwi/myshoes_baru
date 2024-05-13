/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_semBarangmasuk;

/**
 *
 * @author ferdio
 */
public interface Service_SemBarangMasuk {
    void tambahData     (model_semBarangmasuk mod_masuk);
    void perbaruiData     (model_semBarangmasuk mod_masuk);
    void hapusData     (model_semBarangmasuk mod_masuk);
    
    model_semBarangmasuk getByid (String id);
    List<model_semBarangmasuk> ambilData();
}
