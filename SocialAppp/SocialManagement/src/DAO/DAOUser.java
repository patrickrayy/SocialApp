/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOInterface.IDAOUser;
import Helper.Koneksi;
import Model.User;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author patri
 */
public abstract class DAOUser implements IDAOUser{    
    public DAOUser()
    {
        con = Koneksi.getConnection();
    }
    @Override
    public List<User> getAll() {
        List<User> lstUsr = null;
        try
        {
            lstUsr = new ArrayList<User>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                User usr = new User();
                usr.setUser_id(rs.getInt("user_id"));
                usr.setNama(rs.getString("nama"));
                usr.setEmail(rs.getString("email"));
                usr.setPassword(rs.getString("pw"));
                usr.setNo_hp(rs.getInt("no_hp"));
                usr.setUsertype(rs.getString("usertype"));
                usr.setKelamin(rs.getString("kelamin"));
                usr.setAlamat(rs.getString("alamat"));
                lstUsr.add(usr);
            }
        }
        catch(SQLException e)
        {
            System.out.println("error"+e);
        }
        return lstUsr;
    }
    @Override
    public void insert(User b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, b.getUser_id());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getEmail());
            statement.setString(4, b.getPassword());
            statement.setInt(5, b.getNo_hp());
            statement.setString(6, b.getUsertype());
            statement.setString(7, b.getKelamin());
            statement.setString(8, b.getAlamat());
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
    public void update(User b) 
    {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getEmail());
            statement.setString(3, b.getPassword());
            statement.setInt(4, b.getNo_hp());
            statement.setString(5, b.getUsertype());
            statement.setString(6, b.getKelamin());
            statement.setString(7, b.getAlamat());
            statement.setInt(8, b.getUser_id());
            statement.execute();
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

    String strRead = "select * from user;";
    String strInsert = "insert into user (user_id,nama,email,pw,no_hp,usertype,kelamin,alamat) values(?,?,?,?,?,?,?,?);";
    String strUpdate = "update user set nama=?, email=?, pw=?, no_hp=?, usertype=?, kelamin=?, alamat=? where user_id=?;";
    String strDelete = "delete from user where user_id=?;";
}