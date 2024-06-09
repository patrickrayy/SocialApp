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
public class TabelModelDonatur extends AbstractTableModel {

    public TabelModelDonatur(List<Donatur> lstDnt)
    {
       this.lstDnt = lstDnt; 
    }
    
    @Override
    public int getRowCount() {
        return this.lstDnt.size();
    }
    
    @Override
    public String getColumnName(int column)
    {
        return switch (column) {
            case 0 -> "Donor";
            case 1 -> "Donation Fee";
            default -> null;
        };
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> lstDnt.get(rowIndex).getNamaUs();
            case 1 -> lstDnt.get(rowIndex).getFee();
            default -> null;
        };
    }
    
    List<Donatur> lstDnt;
}
