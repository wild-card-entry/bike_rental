package com.example.demo;

import javax.persistence.*;

@Entity
public class Fine {
@Id
@GeneratedValue(strategy =GenerationType.AUTO)
private Integer id;

@OneToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="reservation_id")
 private Reservation reservation;

private Integer amount;

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
