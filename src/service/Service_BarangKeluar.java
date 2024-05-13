/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_barangKeluar;

/**
 *
 * @author ferdio
 */
public interface Service_BarangKeluar {
     void tambahData (model_barangKeluar mod_keluar);
     
     model_barangKeluar getByid (String id);
     List<model_barangKeluar> ambildata();
     List<model_barangKeluar>pencarian(String id);
     String nomor();
     
     
}
