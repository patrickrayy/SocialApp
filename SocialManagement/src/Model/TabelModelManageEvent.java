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
public class TabelModelManageEvent extends AbstractTableModel {
    public TabelModelManageEvent(List <Event> lstEvnt)
    {
       this.lstEvnt = lstEvnt; 
    }
    @Override
    public int getRowCount() {
        return this.lstEvnt.size();
    }
    @Override
    public String getColumnName(int column)
    {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Nama";
            case 2 -> "Tanggal";
            case 3 -> "Lokasi";
            case 4 -> "Deskripsi";
            default -> null;
        };
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return switch (columnIndex) {
            case 0 -> lstEvnt.get(rowIndex).geteventID();
            case 1 -> lstEvnt.get(rowIndex).geteventname();
            case 2 -> lstEvnt.get(rowIndex).geteventdate();
            case 3 -> lstEvnt.get(rowIndex).getlocation();  
            case 4 -> lstEvnt.get(rowIndex).geteventdesc();
            default -> null;
            
        };
    }

    
    List<Event> lstEvnt;
    
}
