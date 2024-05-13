/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.model_distributor;

/**
 *
 * @author ferdio
 */
public interface Service_Distributor {
    void tambahData     (model_distributor mod_dis);
    void perbaruiData   (model_distributor mod_dis);
    void hapusData      (model_distributor mod_dis);
    
    model_distributor getByid (String id);
    
    List<model_distributor> getData();
    List<model_distributor> pencarian(String id);
    
    String nomor();
    
}
