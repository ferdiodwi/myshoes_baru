/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_detailpemesanan;

/**
 *
 * @author ferdio
 */
public interface Service_DetPemesanan {
    void tambahData (model_detailpemesanan mod_detpesan);
    void sumTotal (model_detailpemesanan mod_detpesan);
    void hapusSementara (model_detailpemesanan mod_detpesan);
    
    model_detailpemesanan getByid (String id);
    List<model_detailpemesanan> ambilData(String id);
    List<model_detailpemesanan> pencarian(String id);
    
}

    

