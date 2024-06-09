/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author patri
 */
public class Event {
    private Date eventdate;
    private String eventdesc;
    private Integer eventid;
    private String eventname;
    private String location;

    /**
     * @return the eventdate
     */
    public Date geteventdate() {
        return eventdate;
    }

    /**
     * @param eventdate the eventdate to set
     */
    public void seteventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    /**
     * @return the eventdesc
     */
    public String geteventdesc() {
        return eventdesc;
    }

    /**
     * @param eventdesc the eventdesc to set
     */
    public void seteventdesc(String eventdesc) {
        this.eventdesc = eventdesc;
    }

    /**
     * @return the eventID
     */
    public Integer geteventID() {
        return eventid;
    }

    /**
     * @param eventID the eventID to set
     */
    public void seteventID(Integer eventid) {
        this.eventid = eventid;
    }

    /**
     * @return the eventName
     */
    public String geteventname() {
        return eventname;
    }

    /**
     * @param eventName the eventName to set
     */
    public void seteventname(String eventname) {
        this.eventname = eventname;
    }

    /**
     * @return the location
     */
    public String getlocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setlocation(String location) {
        this.location = location;
    }
}
