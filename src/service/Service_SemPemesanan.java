/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_semPesan;

/**
 *
 * @author ferdio
 */
public interface Service_SemPemesanan {
     void tambahData     (model_semPesan mod_pesan);
    void perbaruiData     (model_semPesan mod_pesan);
    void hapusData     (model_semPesan mod_pesan);
    
    model_semPesan getByid (String id);
    List<model_semPesan> ambilData();
}
