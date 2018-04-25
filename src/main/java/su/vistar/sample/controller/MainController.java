package su.vistar.sample.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import su.vistar.sample.dto.UserDto;
import su.vistar.sample.service.impl.UserService;
import su.vistar.sample.service.impl.VisitService;

@Controller
public class MainController {

    final private VisitService visitService;
    final private UserService userService;

    @Autowired
    public MainController(UserService userService, VisitService visitService) {
        this.userService = userService;
        this.visitService = visitService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView("home");
        model.addObject("greeting", "Hi, Welcome to mysite");
        return model;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView("admin");
        model.addObject("user", getPrincipal());
        return model;
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ModelAndView profilePage() {
        ModelAndView model = new ModelAndView("profile");
        UserDto user = userService.getUserByEmail(getPrincipal());
        model.addObject("user", user);
        return model;
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
