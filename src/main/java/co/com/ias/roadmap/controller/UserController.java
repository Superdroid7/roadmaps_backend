package co.com.ias.roadmap.controller;

import co.com.ias.roadmap.model.User;
import co.com.ias.roadmap.repository.UserRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserRepository USER_REPOSITORY = new UserRepository();

    @PostMapping("/login")
    public String login(@RequestBody User login){
        User foundUSer = USER_REPOSITORY.authenticateUSer(login.getUsername(), login.getPassword());

        if (foundUSer != null){
            return "Logeado exitosamente! bienvenido" + foundUSer.getUsername();
        }
        else{
            return "paila";
        }
    }

    @PostMapping("/logout")
    public  String logout(){
        return "cerrado de sesion con exito!";
    }
}
