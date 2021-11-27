package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(HttpSession session, @RequestParam String emailId, @RequestParam String password,
                             Model model) {
        Customer u = customerRepository.findByEmailIdAndPassword(emailId, password);
        if (u != null) {
            session.setAttribute("user", u);
            model.addAttribute("user", u);
            return "dashboard";
        }
        return "login";
    }

    @RequestMapping("/dashboard")
            public String dashboard(HttpSession session, Model model){
        Customer u = (Customer) session.getAttribute("user");
        if(u != null){
            model.addAttribute("user", u);
            return "dashboard";
        }
        return "redirect:/login";
    }




    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "home_main";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addCustomer(HttpSession session, @RequestParam String name,
                       @RequestParam String emailId, @RequestParam String phoneNumber, @RequestParam String password) {
        Customer u = new Customer();
        u.setName(name);
        u.setEmailId(emailId);
        u.setPassword(password);
        u.setPhone(phoneNumber);
        customerRepository.save(u);
        session.setAttribute("user", u);
        return "redirect:/dashboard";
    }
}
