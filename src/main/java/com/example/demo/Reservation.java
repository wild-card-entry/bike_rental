package com.example.demo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Reservation {
@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer amount;
    @CreationTimestamp
    private Timestamp pickupTime;

    @UpdateTimestamp
    private Timestamp returnTime;
    @ManyToOne
    @JoinColumn(name = "bike_id")
    private Bike bike;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="pickupLocationId")
    private Location pickupLocation;

    @ManyToOne
    private Location dropLocation;


    @OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Fine fine;

    public Timestamp getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Timestamp pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public Fine getFine() {
        return fine;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Integer getId() {
        return id;
    }

    public Bike getBike() {
        return bike;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }
}
