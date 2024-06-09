/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAOEvent;
import DAOInterface.IDAOEvent;
import Model.Event;
import View.manage_event;
import java.util.List;
import Model.TabelModelManageEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author patri
 */
public class ControllerEventAP {   
    public ControllerEventAP(manage_event frmManageEvent){
        this.frmManageEvent = frmManageEvent;
        iEvent = new DAOEvent() {};
    }
    public void isiTable()
    {
        lstEvnt = iEvent.getAll();
        TabelModelManageEvent tabelManageEvent = new TabelModelManageEvent(lstEvnt);
        frmManageEvent.getTabelData().setModel(tabelManageEvent);
    }
    public void insert()
    {
        Event b = new Event();
        b.seteventID(Integer.valueOf(frmManageEvent.gettxtEventID().getText()));
        b.seteventname(frmManageEvent.gettxtEventName().getText());
        b.seteventdate(frmManageEvent.gettxtDateEvent().getDate());
        b.setlocation(frmManageEvent.gettxtlocation().getText());
        b.seteventdesc(frmManageEvent.gettxtEventDesc().getText());
        iEvent.insert(b);
        JOptionPane.showMessageDialog(null,"Input berhasil");
    }
    
    public void reset()
    {
        if(!frmManageEvent.gettxtEventID().isEnabled())
        frmManageEvent.gettxtEventID().setEnabled(true);
        frmManageEvent.gettxtEventID().setText("");
        frmManageEvent.gettxtEventName().setText("");
        frmManageEvent.gettxtDateEvent().setDate(null);
        frmManageEvent.gettxtlocation().setText("");        
        frmManageEvent.gettxtEventDesc().setText("");        
    }
    
    public void isiField(int row)
    {
        frmManageEvent.gettxtEventID().setEnabled(false);
        frmManageEvent.gettxtEventID().setText(lstEvnt.get(row).geteventID().toString());
        frmManageEvent.gettxtEventName().setText(lstEvnt.get(row).geteventname());
        frmManageEvent.gettxtDateEvent().setDate(lstEvnt.get(row).geteventdate());
        frmManageEvent.gettxtlocation().setText(lstEvnt.get(row).getlocation());
        frmManageEvent.gettxtEventDesc().setText(lstEvnt.get(row).geteventdesc());
    }
    
    public void update ()
    {
        Event b = new Event();
        b.seteventID(Integer.parseInt(frmManageEvent.gettxtEventID().getText()));
        b.seteventname(frmManageEvent.gettxtEventName().getText());
        b.seteventdate(frmManageEvent.gettxtDateEvent().getDate());
        b.setlocation(frmManageEvent.gettxtlocation().getText());
        b.seteventdesc(frmManageEvent.gettxtEventDesc().getText());
        
        iEvent.update(b);
        JOptionPane.showMessageDialog(null,"Update Data berhasil");
    }
    
    public void delete()
    {
        iEvent.delete(Integer.parseInt(frmManageEvent.gettxtEventID().getText()));
        JOptionPane.showMessageDialog(null,"Delete Data berhasil");
    }
    
    public void search()
    {
        
        lstEvnt = iEvent.getAllByEventName(frmManageEvent.gettxtCariNamaEvent().getText());
        TabelModelManageEvent tableManageEvent = new TabelModelManageEvent(lstEvnt);
        frmManageEvent.getTabelData().setModel(tableManageEvent);
    }
    manage_event frmManageEvent;
    IDAOEvent iEvent;
    List<Event> lstEvnt;
}
