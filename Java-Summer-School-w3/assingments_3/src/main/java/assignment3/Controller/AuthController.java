package assignment3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String getLogin(ModelMap model) {
        return "auth/login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/register")
    public String getRegister(ModelMap model) {
        return "auth/register";
    }
}
