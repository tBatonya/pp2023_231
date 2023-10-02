package web.controller;

import org.springframework.ui.ModelMap;
import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        model.addAttribute("messages", messages);
        return "index";

    }

    @GetMapping("/users")
    public String listUser(Model model) {
        try {
            List<User> listUser = userService.getAllUser();
            model.addAttribute("listUser", listUser);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "users";
    }

    @GetMapping("/users/{id}")
    public String getUser(Model model, @PathVariable("id") Long id) {
        try {
            User user = userService.userById(id);
            model.addAttribute("user", user);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "get_delete";
    }

    @GetMapping("/create")
    public String createUserForm(User user) {
        return "create";
    }

    @PostMapping("/create")
    public String createUser(User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(Model model, @PathVariable("id") Long id) {
        try {
            User user = userService.userById(id);
            model.addAttribute("user", user);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserForm(Model model, @PathVariable("id") Long id) {
        User user = userService.userById(id);
        model.addAttribute("allowDelete", true);
        model.addAttribute("user", user);
        return "get_delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}