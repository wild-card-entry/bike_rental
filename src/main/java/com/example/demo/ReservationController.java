package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BikeRepository bikeRepository;
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping(path="/location/listOfBikes/{pickupLocation}/{bike}")
    public String addReservation(@PathVariable Bike bike,
                                 @PathVariable Location pickupLocation,
                                 Model model, HttpSession session)
    {
//        if(session.getAttribute("user") == null) {
//            return "redirect:/login";
//        }
        Iterable<Location> allLocation = locationRepository.findAll();
        model.addAttribute("allLocation", allLocation);
        model.addAttribute("bike", bike);
        model.addAttribute("pickupLocation", pickupLocation);

        return "book";
    }

    @RequestMapping(path ="/book")
    public String saveReservation(@RequestParam Bike bike,
                                                @RequestParam Location pickupLocation,
                                                @RequestParam Customer customer,
                                                @RequestParam String dropLocation,
                                                Model model)
    {
        Reservation reservation = new Reservation();
        reservation.setBike(bike);
        reservation.setPickupLocation(pickupLocation);
        reservation.setCustomer(customer);
        reservation.setAmount(100);
        reservation.setDropLocation(locationRepository.findLocationByAddress(dropLocation));
        reservationRepository.save(reservation);

        bike.setAvailable(false);
        bike.setCurrentLocation(reservation.getDropLocation());
        bikeRepository.save(bike);

        return "redirect:/dashboard";
    }

    @RequestMapping("/reservation")
    public String reservation(HttpSession session, Model model){
        Customer u = (Customer) session.getAttribute("user");
        if(u != null){
            model.addAttribute("reservation", reservationRepository.findReservationByCustomer(u));
            return "reservation";
        }
        return "redirect:/login";
    }

    @RequestMapping(path ="/return/{bike}")
    public String saveReservation(@PathVariable Bike bike)
    {
        Reservation reservation = reservationRepository.findReservationByBikeOrderByIdDesc(bike).iterator().next();
        reservation.setReturnTime(null);
        reservationRepository.save(reservation);

        bike.setAvailable(true);
        bikeRepository.save(bike);

        return "redirect:/dashboard";
    }
}
