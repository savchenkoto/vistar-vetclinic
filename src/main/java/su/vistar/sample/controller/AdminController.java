package su.vistar.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import su.vistar.sample.dto.regular.AnimalDto;
import su.vistar.sample.dto.regular.RoleDto;
import su.vistar.sample.dto.regular.UserDto;
import su.vistar.sample.editors.RoleEditor;
import su.vistar.sample.service.RoleService;
import su.vistar.sample.service.impl.AnimalServiceImpl;
import su.vistar.sample.service.impl.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    final private UserServiceImpl userService;

    final private AnimalServiceImpl animalService;

    private RoleService roleService;

    @Autowired
    public AdminController(UserServiceImpl userService, AnimalServiceImpl animalService, RoleService roleService) {
        this.userService = userService;
        this.animalService = animalService;
        this.roleService = roleService;
    }

    @ModelAttribute("roles")
    public List<RoleDto> populateRoles() {
        return roleService.getAll();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(RoleDto.class, new RoleEditor());
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView usersPage() {
        ModelAndView model = new ModelAndView("users");
        List<UserDto> userDtos = userService.getAll();
        model.addObject("users", userDtos);
        return model;
    }

    @RequestMapping(value = "users/new", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "userForm";
    }

    @RequestMapping(value = "/users/new", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user") @Valid UserDto userDto,
                                 BindingResult result,
                                 WebRequest request,
                                 Errors errors) {
        Integer newUserId = null;
        if (!result.hasErrors()) {
            newUserId = userService.save(userDto);
        }
        if (newUserId == null) {
            result.rejectValue("email", "Duplicate.userForm.email");
        }
        if (result.hasErrors()) {
            return new ModelAndView("userForm", "user", userDto);
        } else {
            return new ModelAndView("redirect:/admin/users");
        }

    }

    @RequestMapping(value = "animals", method = RequestMethod.GET)
    public ModelAndView animalsPage() {
        ModelAndView model = new ModelAndView("animals");
        List<AnimalDto> animalDtos = animalService.getAll();
        model.addObject("animals", animalDtos);
        return model;
    }

    @RequestMapping(value = "animals/new", method = RequestMethod.GET)
    public String showAddAnimalForm(Model model) {
        model.addAttribute("animal", new AnimalDto());
        return "animalForm";
    }

    @RequestMapping(value = "animals/{id}/update", method = RequestMethod.GET)
    public String showUpdateAnimalForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("animal", animalService.getById(id));
        return "animalForm";
    }

    @RequestMapping(value = "animals/save", method = RequestMethod.POST)
    public ModelAndView saveOrUpdateAnimal(@ModelAttribute("animal") @Valid AnimalDto animalDto,
                                           BindingResult result) {
        if (!result.hasErrors()) {
            try{
                animalService.save(animalDto);
                return new ModelAndView("redirect:/admin/animals");
            } catch (AlreadyExistsException e) {
                result.rejectValue("type", "Duplicate.animalForm.type");
            }
        }
        return new ModelAndView("animalForm", "animal", animalDto);
    }
}
