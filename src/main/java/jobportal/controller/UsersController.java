package jobportal.controller;

import jakarta.validation.Valid;
import jobportal.entity.Users;
import jobportal.entity.UsersType;
import jobportal.services.UsersService;
import jobportal.services.UsersTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {

    private final UsersService usersService;
    private final UsersTypeService usersTypeService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model){
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users, Model model){
        System.out.println("User: " + users);
        usersService.addNew(users);
//        List<UsersType> usersTypes = usersTypeService.getAll();
//        model.addAttribute("getAllTypes", usersTypes);
//        model.addAttribute("user", new Users());
        return "dashboard";
    }
}
