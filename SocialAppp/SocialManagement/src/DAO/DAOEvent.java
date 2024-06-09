/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOInterface.IDAOEvent;
import Helper.Koneksi;
import Model.Event;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author patri
 */
public class DAOEvent implements IDAOEvent {
    public DAOEvent()
    {
        con = Koneksi.getConnection();
    }
    @Override
    public List<Event> getAll() {
        List<Event> lstEvnt = null;
        try
        {
            lstEvnt = new ArrayList<Event>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Event evnt = new Event();
                evnt.seteventID(rs.getInt("eventid"));
                evnt.seteventname(rs.getString("eventname"));
                evnt.seteventdate(rs.getDate("eventdate"));
                evnt.setlocation(rs.getString("location"));
                evnt.seteventdesc(rs.getString("eventdesc"));
                lstEvnt.add(evnt);
            }
        }
        catch(SQLException e)
        {
            System.out.println("error"+e);
        }
        return lstEvnt;
    }
    @Override
    public void insert(Event b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, b.geteventID());
            statement.setString(2, b.geteventname());
            statement.setDate(3, new java.sql.Date(b.geteventdate().getTime()));
            statement.setString(4, b.getlocation());
            statement.setString(5, b.geteventdesc());
            statement.execute();
        }catch(SQLException e)
        {
           System.out.println("gagal input");
        }
        finally
        {
             try {
                statement.close();
            } catch (SQLException e){
                System.out.println("gagal input");
            }
        }
    }
    @Override
    public void update(Event b) 
    {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, b.geteventname());
            statement.setDate(2, new java.sql.Date(b.geteventdate().getTime()));
            statement.setString(3, b.getlocation());
            statement.setString(4, b.geteventdesc());
            statement.setInt(5, b.geteventID());
            statement.executeUpdate();
        }catch(SQLException e)
        {
           System.out.println("gagal update"+e);
        }
        finally
        {
             try {
                statement.close();
            } catch (SQLException e){
                System.out.println("gagal update"+e);
            }
        }
    }
    @Override
    public void delete(int id) 
    {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strDelete);
            statement.setInt(1, id);
            statement.execute();
        }catch(SQLException e)
        {
           System.out.println("gagal delete");
        }
        finally
        {
             try {
                statement.close();
            } catch (SQLException e){
                System.out.println("gagal delete");
            }
        }
    }
 
    Connection con;
    //SQL Query

    String strRead = "select * from event;";
    String strInsert = "insert into event (eventid,eventname,eventdate,location,eventdesc) values (?,?,?,?,?);";
    String strUpdate = "update event set eventname=?, eventdate=?, location=?, eventdesc=? where eventid=?;";
    String strDelete = "delete from event where eventid=?;";
    
    
}
