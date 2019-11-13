package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userRoleService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user) {
        userRoleService.addUser(user);
        return "home";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    private String changePassword(
            @RequestParam(value = "passwordLama") String passwordLama, String passwordBaru, String passwordBaruConfirm, String username, Model model) {

        UserModel currentUser = userRoleService.getUserByUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(passwordEncoder.matches(passwordLama, currentUser.getPassword())){
            if(passwordBaru.equals(passwordBaruConfirm)){
                userRoleService.changePassword(currentUser, passwordBaru);
                model.addAttribute("teks","Password berhasil diubah");
            }
            else{
                model.addAttribute("teks", "Password baru tidak sesuai");
            }
        }
        else{
            model.addAttribute("teks", "Password lama salah");
        }

        return "ubah-password";
    }
}
