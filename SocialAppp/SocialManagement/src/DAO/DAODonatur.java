/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAODonatur;
import Helper.Koneksi;
import Model.Donatur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAODonatur implements IDAODonatur {
    private String idEvent;
    
    public DAODonatur(String idEvent) {
        this.idEvent = idEvent;
        con = Koneksi.getConnection();
    }

    @Override
    public List<Donatur> getAll() {
        List<Donatur> lstDonatur= null;
        try {
            lstDonatur = new ArrayList<Donatur>();
            String query = "select * from donasi where eventid = '" + idEvent + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Donatur donatur = new Donatur();
                donatur.setDonationid(rs.getInt("donasiid"));
                donatur.setNamaUs(rs.getString("namaUs"));
                donatur.setEventid(rs.getInt("eventid"));
                donatur.setFee(rs.getInt("fee"));
                lstDonatur.add(donatur);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return lstDonatur;
    }
    
    Connection con;
}