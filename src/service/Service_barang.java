/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_barang;

/**
 *
 * @author ferdio
 */
public interface Service_barang {
    void tambahData (model_barang mod_bar);
    void perbaruiData (model_barang mod_bar);
    void hapusData (model_barang mod_ar);
    
    model_barang getByid (String id);
    
    List<model_barang> getDataById ();
    List<model_barang> getData ();
    
    List<model_barang> pencarian (String id);
    List<model_barang> pencarian2 (String id);
    
    String nomor ();
    String nomor2 ();
    
}
