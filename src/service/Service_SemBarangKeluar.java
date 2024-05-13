/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_semBarangkeluar;

/**
 *
 * @author ferdio
 */
public interface Service_SemBarangKeluar {
    void tambahData     (model_semBarangkeluar mod_keluar);
    void perbaruiData     (model_semBarangkeluar mod_keluar);
    void hapusData     (model_semBarangkeluar mod_keluar);
    
    model_semBarangkeluar getByid (String id);
    List<model_semBarangkeluar> ambilData();
}
