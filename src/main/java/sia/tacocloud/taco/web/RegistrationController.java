package sia.tacocloud.taco.web;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocloud.taco.data.UserRepository;
import sia.tacocloud.taco.model.RegistrationForm;

/**
 * 用户注册的控制器
 *
 * @date 2024/05/28
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRepo.save(form.toUser(passwordEncoder));

        return "redirect:/login";
    }
}
