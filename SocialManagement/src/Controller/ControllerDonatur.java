/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAODonatur;
import DAOInterface.IDAODonatur;
import Model.Donatur;
import Model.TabelModelDonatur;
import View.detailevent;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ControllerDonatur {
    public ControllerDonatur(detailevent frmDonatur){
        this.frmDonatur = frmDonatur;
        this.iDonatur = new DAODonatur(frmDonatur.getEventId());
    }
        
    public void isiTableDonatur(){
        lstDonatur = iDonatur.getAll();
        TabelModelDonatur tabelDonatur = new TabelModelDonatur(lstDonatur);
        frmDonatur.getTabelsData().setModel(tabelDonatur);
    }
    
    detailevent frmDonatur;
    IDAODonatur iDonatur;
    List<Donatur> lstDonatur;
}