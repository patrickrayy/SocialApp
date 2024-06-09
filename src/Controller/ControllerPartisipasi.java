/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOPartisipasi;
import DAOInterface.IDAOPartisipasi;
import Model.Partisipan;
import Model.TabelModelPartisipasi;
import View.detailevent;
import View.userpage;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ControllerPartisipasi {
    
    public ControllerPartisipasi(detailevent frmPartisipasi){
        this.frmPartisipasi = frmPartisipasi;
        this.iPartisipasi = new DAOPartisipasi(frmPartisipasi.getEventId());
    }
        
    public void isiTablePartisipasi(){
        lstPartisipasi = iPartisipasi.getAll();
        TabelModelPartisipasi tabelPartisipasi = new TabelModelPartisipasi(lstPartisipasi);
        frmPartisipasi.getTabelData().setModel(tabelPartisipasi);
    }
    
    detailevent frmPartisipasi;
    IDAOPartisipasi iPartisipasi;
    List<Partisipan> lstPartisipasi;
}