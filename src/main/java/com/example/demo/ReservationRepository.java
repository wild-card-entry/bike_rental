package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Integer> {

    Iterable<Reservation> findReservationByBikeOrderByIdDesc(Bike bike);
    Iterable<Reservation> findReservationByCustomer(Customer customer);

}
