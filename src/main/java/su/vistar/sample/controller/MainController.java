package su.vistar.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import su.vistar.sample.dto.ProfileInfoDto;
import su.vistar.sample.service.impl.PetServiceImpl;
import su.vistar.sample.service.impl.UserServiceImpl;

import java.security.Principal;

@Controller
public class MainController {

    final private UserServiceImpl userService;

    final private PetServiceImpl petService;

    @Autowired
    public MainController(UserServiceImpl userService, PetServiceImpl petService) {
        this.userService = userService;
        this.petService = petService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ModelAndView profilePage(Principal principal) {
        ModelAndView model = new ModelAndView("clientProfile");
        ProfileInfoDto profile = userService.getProfileByEmail(principal.getName());
        model.addObject("profile", profile);
        return model;
    }

    @RequestMapping(value = "/pets",method = RequestMethod.GET)
    public ModelAndView petsPage() {
        ModelAndView model = new ModelAndView("pets");
        model.addObject("pets", petService.getAll());
        return model;
    }


}
