/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAOUser;
import Model.User;
import DAOInterface.IDAOUser;
import Model.TabelModelManageUser;
import java.util.List;
import View.manage_user;
import javax.swing.JOptionPane;

/**
 *
 * @author patri
 */
public class ControllerUser {
    
    public ControllerUser(manage_user frmManageUser){
        this.frmManageUser = frmManageUser;
        iUser = new DAOUser() {};
    }
    public void isiTable()
    {
        lstUsr = iUser.getAll();
        TabelModelManageUser tabelManageUser = new TabelModelManageUser(lstUsr);
        frmManageUser.getTabelData().setModel(tabelManageUser);
    }
    
    public void insert()
    {
        User b = new User();
        b.setUser_id(Integer.valueOf(frmManageUser.gettxtID().getText()));
        b.setNama(frmManageUser.gettxtNama().getText());
        b.setEmail(frmManageUser.gettxtEmail().getText());
        b.setPassword(frmManageUser.gettxtPassword().getText());
        b.setNo_hp(Integer.valueOf(frmManageUser.gettxtTelepon().getText()));
        b.setUsertype(frmManageUser.getUserType().getSelectedItem().toString());
        b.setKelamin(frmManageUser.getKelamin().getSelectedItem().toString());
        b.setAlamat(frmManageUser.gettxtAlamat().getText());
        iUser.insert(b);
        JOptionPane.showMessageDialog(null,"Input berhasil");
    }
    
    public void reset()
    {
        if(!frmManageUser.gettxtID().isEnabled())
        frmManageUser.gettxtID().setEnabled(true);
        frmManageUser.gettxtID().setText("");
        frmManageUser.gettxtNama().setText("");
        frmManageUser.gettxtEmail().setText("");
        frmManageUser.gettxtPassword().setText("");
        frmManageUser.gettxtTelepon().setText("");
        frmManageUser.getUserType().setSelectedItem("");
        frmManageUser.getKelamin().setSelectedItem("");
        frmManageUser.gettxtAlamat().setText("");
    }
    
    public void isiField(int row)
    {
        frmManageUser.gettxtID().setEnabled(false);
        frmManageUser.gettxtID().setText(lstUsr.get(row).getUser_id().toString());
        frmManageUser.gettxtNama().setText(lstUsr.get(row).getNama());
        frmManageUser.gettxtEmail().setText(lstUsr.get(row).getEmail());
        frmManageUser.gettxtPassword().setText(lstUsr.get(row).getPassword());
        frmManageUser.gettxtTelepon().setText(lstUsr.get(row).getNo_hp().toString());
        frmManageUser.getUserType().setSelectedItem(lstUsr.get(row).getUsertype());
        frmManageUser.getKelamin().setSelectedItem(lstUsr.get(row).getKelamin());
        frmManageUser.gettxtAlamat().setText(lstUsr.get(row).getAlamat());
    }
    
    public void update()
    {
        User b = new User();
        b.setUser_id(Integer.parseInt(frmManageUser.gettxtID().getText()));
        b.setNama(frmManageUser.gettxtNama().getText());
        b.setEmail(frmManageUser.gettxtEmail().getText());
        b.setPassword(frmManageUser.gettxtPassword().getText());
        b.setNo_hp(Integer.parseInt(frmManageUser.gettxtTelepon().getText()));
        b.setUsertype(frmManageUser.getUserType().getSelectedItem().toString());
        b.setKelamin(frmManageUser.getKelamin().getSelectedItem().toString());
        b.setAlamat(frmManageUser.gettxtAlamat().getText());
        
        iUser.update(b);
        JOptionPane.showMessageDialog(null,"Update Data berhasil");
    }
    
    public void delete()
    {
        User b = new User();
        iUser.delete(Integer.parseInt(frmManageUser.gettxtID().getText()));
        JOptionPane.showMessageDialog(null,"Delete Data berhasil");
    }
    manage_user frmManageUser;
    IDAOUser iUser;
    List<User> lstUsr;
    
}
