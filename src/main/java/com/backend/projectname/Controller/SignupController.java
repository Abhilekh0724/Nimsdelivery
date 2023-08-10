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
    @GetMapping(value = "/food")
    public String food() {
        return "food";
    }
    @GetMapping(value = "/clothing")
    public String clothing() {
        return "clothing";
    }
    @GetMapping(value = "/groceries")
    public String groceries() {
        return "groceries";
    }
    @GetMapping(value = "/electronics")
    public String electronics() {
        return "electronics";
    }


    @PostMapping(value = "/getsignupdata")
    public RedirectView getsignupdata(@RequestParam("fullName") String fullName,@RequestParam("phoneNumber") String phoneNumber,@RequestParam("address") String address,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("confirmPassword") String confirmPassword,@RequestParam("birthday") String birthday){
        if(fullName.length()>2 && phoneNumber.length()>2 && address.length()>2 && email.length()>20 && password.length()>10 && confirmPassword.length()>10 && birthday.length()>5){
            Users user=new Users();
            user.setUser_fullName(fullName);
            user.setPhoneNumber(phoneNumber);
            user.setEmail(email);
            user.setPassword(password);
            user.setConfirmPassword(confirmPassword);
            user.setBirthday(birthday);

            Users savedData=usersRepository.save(user);
            return new RedirectView("/login");
        }else{
            System.out.println("Fill all the character properly.");
        }
        return new RedirectView(null);
    }

}
