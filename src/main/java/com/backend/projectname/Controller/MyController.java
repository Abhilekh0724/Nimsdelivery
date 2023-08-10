package com.backend.projectname.Controller;


import com.backend.projectname.Repository.UsersRepository;
import com.backend.projectname.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MyController {

@Autowired
private UsersRepository usersRepository;

@GetMapping(value = "/home")
public String home(){
    return "home";
}
    @GetMapping(value = "/login")
    public String login(){
       return "login";

    }


        @PostMapping(value = "/getformdata")
    public RedirectView getdata(@RequestParam("email") String email, @RequestParam("password") String password){
            Users user=usersRepository.findByEmail(email);
            System.out.println(user);
            System.out.println(password);
            System.out.println(user.getPassword());
            if(  !user.getPassword().equals(password)){
                return null;
            }

            return new RedirectView("/home");


     }



}
