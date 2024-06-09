/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author patri
 */
public class User {

    public User() {
    }
    private Integer user_id;
    private String pw;
    private String email;
    private String nama;
    private String usertype;
    private Integer no_hp;
    private String kelamin;
    private String alamat;

    /**
     * @return the user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return pw;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String pw) {
        this.pw = pw;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the usertype
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * @param usertype the usertype to set
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * @return the no_hp
     */
    public Integer getNo_hp() {
        return no_hp;
    }

    /**
     * @param no_hp the no_hp to set
     */
    public void setNo_hp(Integer no_hp) {
        this.no_hp = no_hp;
    }

    /**
     * @return the kelamin
     */
    public String getKelamin() {
        return kelamin;
    }

    /**
     * @param kelamin the kelamin to set
     */
    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
}
