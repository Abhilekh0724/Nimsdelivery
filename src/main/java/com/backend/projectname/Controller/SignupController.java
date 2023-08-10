package com.backend.projectname.Controller;


import com.backend.projectname.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.backend.projectname.Repository.UsersRepository;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SignupController {
    @Autowired
    private UsersRepository usersRepository;
    @GetMapping(value = "/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping(value = "/getsignupdata")
    public RedirectView getsignupdata(@RequestParam("fname") String fname, @RequestParam("lname") String lname, @RequestParam("email") String email, @RequestParam("password") String password) {
        if(fname.length()>2 && lname.length()>2 && email.length()>8 && password.length()>5){
            Users user=new Users();
            user.setUser_firstname(fname);
            user.setUser_lastname(lname);
            user.setEmail(email);
            user.setPassword(password);
            Users savedData=usersRepository.save(user);
            return new RedirectView("/login");
        }else{
            System.out.println("Fill all the character properly.");
        }
        return new RedirectView(null);
    }

}
