/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class TabelModelPartisipasi extends AbstractTableModel {

    public TabelModelPartisipasi(List<Partisipan> lstPrt)
    {
       this.lstPrt = lstPrt; 
    }
    
    @Override
    public int getRowCount() {
        return this.lstPrt.size();
    }
    
    @Override
    public String getColumnName(int column)
    {
        return switch (column) {
            case 0 -> "Volunteer";
            default -> null;
        };
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> lstPrt.get(rowIndex).getNamaU();
            default -> null;
        };
    }
    
    List<Partisipan> lstPrt;
}
