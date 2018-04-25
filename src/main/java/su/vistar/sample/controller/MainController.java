package su.vistar.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
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

    @RequestMapping(value = "/doctor", method = RequestMethod.GET)
    public ModelAndView doctorPage() {
        ModelAndView model = new ModelAndView("doctor");
        model.addObject("user", getPrincipal());
        return model;
    }

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public ModelAndView clientPage() {
        ModelAndView model = new ModelAndView("client");
        model.addObject("user", getPrincipal());
        return model;
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public ModelAndView accessDeniedPage() {
        ModelAndView model = new ModelAndView("accessDenied");
        model.addObject("user", getPrincipal());
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profilePage() {
        ModelAndView model = new ModelAndView("profile");
        model.addObject("user", getPrincipal());
        return model;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
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
