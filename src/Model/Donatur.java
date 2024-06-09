/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Donatur {

    /**
     * @return the donationid
     */
    public Integer getDonationid() {
        return donationid;
    }

    /**
     * @param donationid the donationid to set
     */
    public void setDonationid(Integer donationid) {
        this.donationid = donationid;
    }

    /**
     * @return the namaUs
     */
    public String getNamaUs() {
        return namaUs;
    }

    /**
     * @param namaUs the namaUs to set
     */
    public void setNamaUs(String namaUs) {
        this.namaUs = namaUs;
    }

    /**
     * @return the eventid
     */
    public Integer getEventid() {
        return eventid;
    }

    /**
     * @param eventid the eventid to set
     */
    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    /**
     * @return the fee
     */
    public Integer getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(Integer fee) {
        this.fee = fee;
    }
    private Integer donationid;
    private String namaUs;
    private Integer eventid;
    private Integer fee;
}
