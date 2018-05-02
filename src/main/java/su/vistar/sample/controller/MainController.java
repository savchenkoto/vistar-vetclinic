package su.vistar.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import su.vistar.sample.dto.ProfileInfoDto;
import su.vistar.sample.service.impl.UserService;

import java.security.Principal;

@Controller
public class MainController {

    final private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView("home");
        model.addObject("greeting", "Hi, Welcome to mysite");
        return model;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage(Principal principal) {
        ModelAndView model = new ModelAndView("admin");
        model.addObject("user", principal);
        return model;
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ModelAndView profilePage(Principal principal) {
        ModelAndView model = new ModelAndView("profile");
        ProfileInfoDto profileInfo = userService.getProfileByEmail(principal.getName());
        model.addObject("profile", profileInfo);
        return model;
    }


}
