package com.example.demo;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bike {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
        private int id;
        private String model;

        @ColumnDefault("true")
        private Boolean available;
        private String color;
    @OneToMany(mappedBy = "bike")
    private Set<Reservation> reservation= new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location currentLocation;

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(Set<Reservation> reservation) {
        this.reservation = reservation;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
