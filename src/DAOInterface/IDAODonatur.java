/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;
import java.util.List;
import Model.Donatur;

/**
 *
 * @author patri
 */
public interface IDAODonatur {
    //read data
    public List<Donatur> getAll();
}
