/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author patri
 */
public class TabelModelManageUser extends AbstractTableModel {
    public TabelModelManageUser(List <User> lstUsr)
    {
       this.lstUsr = lstUsr; 
    }
    @Override
    public int getRowCount() {
        return this.lstUsr.size();
    }
    @Override
    public String getColumnName(int column)
    {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Nama";
            case 2 -> "Email";
            case 3 -> "Password";    
            case 4 -> "Telepon";
            case 5 -> "User Type";
            case 6 -> "Jenis Kelamin";
            case 7 -> "Alamat";
            default -> null;
        };
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    {
        return switch (columnIndex) {
            case 0 -> lstUsr.get(rowIndex).getUser_id();
            case 1 -> lstUsr.get(rowIndex).getNama();
            case 2 -> lstUsr.get(rowIndex).getEmail();
            case 3 -> lstUsr.get(rowIndex).getPassword();    
            case 4 -> lstUsr.get(rowIndex).getNo_hp();  
            case 5 -> lstUsr.get(rowIndex).getUsertype();
            case 6 -> lstUsr.get(rowIndex).getKelamin();    
            case 7 -> lstUsr.get(rowIndex).getAlamat();
            default -> null;
        };
    }
}
    
    List<User> lstUsr;
    
}
