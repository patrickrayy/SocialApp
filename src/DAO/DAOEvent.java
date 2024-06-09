/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOInterface.IDAOEvent;
import Helper.Koneksi;
import Model.Donatur;
import Model.Event;
import Model.Partisipan;
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
public abstract class DAOEvent implements IDAOEvent {
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
    
    @Override
    public List<Event> getAllByEventName(String eventname){
        List<Event> lstEvnt = null;
        try
        {
            lstEvnt = new ArrayList<Event>();
            PreparedStatement st = con.prepareStatement(strSearch);
            st.setString(1, "%"+eventname+"%");
            ResultSet rs = st.executeQuery();
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
    public void partisipan(Partisipan b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strPartisipan);
            statement.setInt(1, b.getEventid());
            statement.setString(2, b.getNamaU());
            statement.execute();
        }catch(SQLException e)
        {
           System.out.println(e+ "gagal input");
        }
        finally
        {
             try {
                statement.close();
            } catch (SQLException e){
                System.out.println(e+ "gagal");
            }
        }
    }
    
    @Override
    public void donatur(Donatur b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strDonatur);
            statement.setInt(1, b.getFee());
            statement.setInt(2, b.getEventid());
            statement.setString(3, b.getNamaUs());
            statement.execute();
        }catch(SQLException e)
        {
           System.out.println(e+ "gagal input");
        }
        finally
        {
             try {
                statement.close();
            } catch (SQLException e){
                System.out.println(e+ "gagal");
            }
        }
    }
    
    Connection con;
    //SQL Query

    String strRead = "select * from event;";
    String strInsert = "insert into event (eventid,eventname,eventdate,location,eventdesc) values (?,?,?,?,?);";
    String strUpdate = "update event set eventname=?, eventdate=?, location=?, eventdesc=? where eventid=?;";
    String strSearch = "select * from event where eventname like ?;";
    String strDelete = "delete from event where eventid=?;";
    String strPartisipan = "Insert into partisipasi (eventid,namaU) values (?,?);";
    String strDonatur = "Insert into donasi (fee, eventid, namaUs) values(?,?,?);";
    
    
}
