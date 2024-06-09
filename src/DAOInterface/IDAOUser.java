/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import java.util.List;
import Model.User;
/**
 *
 * @author patri
 */
public interface IDAOUser {
    //read data
    public List<User> getAll();
    //insert data
    public void insert(User b);
    //update data
    public void update(User b);
    //delete data
    public void delete(int id);
    //search data
    public List<User> getAllByName(String nama);
}