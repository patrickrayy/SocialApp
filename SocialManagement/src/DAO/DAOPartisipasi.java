/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOPartisipasi;
import Helper.Koneksi;
import Model.Partisipan;
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
public class DAOPartisipasi implements IDAOPartisipasi {
    private String idEvent;
    
    public DAOPartisipasi(String idEvent) {
        this.idEvent = idEvent;
        con = Koneksi.getConnection();
    }

    @Override
    public List<Partisipan> getAll() {
        List<Partisipan> lstPartisipasi= null;
        try {
            lstPartisipasi = new ArrayList<Partisipan>();
            String query = "select * from partisipasi where eventid = '" + idEvent + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Partisipan partisipasi = new Partisipan();
                partisipasi.setPartisipasiid(rs.getInt("partisipasiid"));
                partisipasi.setNamaU(rs.getString("namaU"));
                partisipasi.setEventid(rs.getInt("eventid"));
                lstPartisipasi.add(partisipasi);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return lstPartisipasi;
    }
    
    Connection con;
}