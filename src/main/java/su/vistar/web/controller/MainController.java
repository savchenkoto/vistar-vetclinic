package su.vistar.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import su.vistar.web.dao.impl.AbstractDao;
import su.vistar.web.dao.impl.AnimalDao;
import su.vistar.web.domain.Animal;
import su.vistar.web.service.impl.AbstractService;
import su.vistar.web.service.impl.AnimalService;

@Controller
@RequestMapping("/welcome")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring MVC - Hello, World");
        return "index";
    }

}
