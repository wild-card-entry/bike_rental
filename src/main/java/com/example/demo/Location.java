package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "pickupLocation")
    private Set<Reservation> pickup=new HashSet<>();
    @OneToMany(mappedBy = "dropLocation")
    private Set<Reservation> drop=new HashSet<>();

    @OneToMany(mappedBy = "currentLocation")
    private Set<Bike> bike=new HashSet<>();

  /*  public Set<Reservation> getPickup() {
        return pickup;
    }

    public void setPickup(Set<Reservation> pickup) {
        this.pickup = pickup;
    }

    public Set<Reservation> getDrop() {
        return drop;
    }

    public void setDrop(Set<Reservation> drop) {
        this.drop = drop;
    }

   */

    public Set<Bike> getBike() {
        return bike;
    }

    public void setBike(Set<Bike> bike) {
        this.bike = bike;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
