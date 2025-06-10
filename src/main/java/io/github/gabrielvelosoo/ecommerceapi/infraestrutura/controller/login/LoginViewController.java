package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
