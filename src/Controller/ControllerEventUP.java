/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAOEvent;
import DAOInterface.IDAOEvent;
import DAOInterface.IDAOPartisipasi;
import Model.Donatur;
import Model.Event;
import Model.Partisipan;
import View.userpage;
import java.util.List;
import Model.TabelModelManageEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author patri
 */
public class ControllerEventUP {
    public ControllerEventUP(userpage frmUserPage){
        this.frmUserPage = frmUserPage;
        iEventUP = new DAOEvent(){};
    }
    public void isiTable()
    {
        lstEvntUP = iEventUP.getAll();
        TabelModelManageEvent tableEventUP = new TabelModelManageEvent(lstEvntUP);
        frmUserPage.getTabelData().setModel(tableEventUP);
    }
    
    public void isiField(int row)
    {
        frmUserPage.gettxteventidU().setEnabled(false);
        frmUserPage.gettxteventidU().setText(lstEvntUP.get(row).geteventID().toString());
        frmUserPage.gettxteventnameU().setText(lstEvntUP.get(row).geteventname());
        frmUserPage.gettxtDateEventU().setDate(lstEvntUP.get(row).geteventdate());
        frmUserPage.gettxtlokasieventU().setText(lstEvntUP.get(row).getlocation());
        frmUserPage.gettxtAreaeventDescU().setText(lstEvntUP.get(row).geteventdesc());
    }
    public void search ()
    {
        lstEvntUP = iEventUP.getAllByEventName(frmUserPage.gettxtCariNamaEventUP().getText());
        TabelModelManageEvent tableEventUP = new TabelModelManageEvent(lstEvntUP);
        frmUserPage.getTabelData().setModel(tableEventUP);
    }
    public void participate()
    {
        Partisipan b = new Partisipan();
        b.setEventid(Integer.valueOf(frmUserPage.gettxteventidU().getText()));
        b.setNamaU(frmUserPage.gettxtUID().getText());
        iEventUP.partisipan(b);
        JOptionPane.showMessageDialog(null, "Berhasil Partisipasi");
    }
    
    public void donation()
    {
        Donatur b = new Donatur();
        b.setEventid(Integer.valueOf(frmUserPage.gettxteventidU().getText()));
        b.setNamaUs(frmUserPage.gettxtUID().getText());
        b.setFee(Integer.valueOf(frmUserPage.gettxtNominal().getText()));
        iEventUP.donatur(b);
        JOptionPane.showMessageDialog(null, "Berhasil Donasi");
    }
    
    userpage frmUserPage;
    IDAOEvent iEventUP;
    List<Event> lstEvntUP;
}
