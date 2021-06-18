package kg.megacom.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private List<User> userList;

    @Autowired
    private Long userId;

    @GetMapping("/courier")
    public String showUser(Model model) {
        model.addAttribute("users", userList);
        return "courier";
    }
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userList);
        return "courier";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user, Model model) {
        User user1 = new User();
        model.addAttribute("user", user);
        List<String> courierStatusId = Arrays.asList("Busy", "Free","To_collect","To_drop_off","On_vacation");
        model.addAttribute("courierStatusId", courierStatusId);
        return "add-user";
    }
    @GetMapping("/adminForm")
    public String showAdminForm(Model model) {
        model.addAttribute("users", userList);
        return "adminForm";
    }
    @GetMapping("/signupAdmin")
    public String showSignUpAdmin(User user, Model model) {
        User user1 = new User();
        model.addAttribute("user", user);
        return "add-admin";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-admin";
        }

        user.setId(userId);
        userList.add(user);

        return "redirect:/adminForm";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        user.setId(userId);
        userList.add(user);

        return "redirect:/courier";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userList.stream().filter(u -> u.getId() == id).findFirst().get();
        model.addAttribute("user", user);
        return "update-user";
    }
    @GetMapping("/editNew/{id}")
    public String showUpdateFormAdmin(@PathVariable("id") long id, Model model) {
        User user = userList.stream().filter(u -> u.getId() == id).findFirst().get();
        model.addAttribute("user", user);
        return "update-admin";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@Valid @PathVariable("id") long id, User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-user";
        }

        User user1 = userList.stream().filter(u -> u.getId() == id).findFirst().get();
        userList.remove(user1);
        userList.add(user);
        return "redirect:/index";
    }
    @PostMapping("/updateAdmin/{id}")
    public String updateAdmin(@Valid @PathVariable("id") long id, User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-admin";
        }

        User user1 = userList.stream().filter(u -> u.getId() == id).findFirst().get();
        userList.remove(user1);
        userList.add(user);
        return "redirect:/adminForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userList.stream().filter(u -> u.getId() == id).findFirst().get();
        userList.remove(user);
        return "redirect:/index";
    }
    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable("id") long id, Model model) {
        User user = userList.stream().filter(u -> u.getId() == id).findFirst().get();
        userList.remove(user);
        return "redirect:/adminForm";
    }
}
