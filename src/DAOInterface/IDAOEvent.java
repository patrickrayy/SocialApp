/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;
import Model.Donatur;
import java.util.List;
import Model.Event;
import Model.Partisipan;

/**
 *
 * @author patri
 */
public interface IDAOEvent {
    //read data
    public List<Event> getAll();
    //insert data
    public void insert(Event b);
    //update data
    public void update(Event b);
    //delete data
    public void delete(int id);
    //search data
    public List<Event> getAllByEventName(String eventname);
    //insert partisipan
    public void partisipan(Partisipan b);
    //insert donatur
    public void donatur(Donatur b);
}
