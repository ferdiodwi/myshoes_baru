/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_barangmasuk;

/**
 *
 * @author ferdio
 */
public interface Service_barangMasuk {
    void tambahData (model_barangmasuk mod_masuk);
    void perbaruiStatus (String kode_barang);
     
     model_barangmasuk getByid (String id);
     List<model_barangmasuk> ambildata();
     List<model_barangmasuk>pencarian(String id);
     String nomor();
}
