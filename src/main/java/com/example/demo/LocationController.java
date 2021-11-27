package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
@RequestMapping(path="/location")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;
    //display all locations
 @GetMapping(path="")
    public
    String getAllLocation(Model model, HttpSession session)
    {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        Iterable<Location> allLocation = locationRepository.findAll();
        model.addAttribute("allLocation", allLocation);
        return "location";
    }


    @GetMapping(path="/listOfBikes/{location_variable}")
    public
    String getBikesOfLocation(@PathVariable("location_variable") Location location_variable,Model model)
    {

      Set<Bike> bikes = location_variable.getBike();
      model.addAttribute("bikes", bikes);
      model.addAttribute("location", location_variable.getAddress());
        return "bikeList";
    }

}
