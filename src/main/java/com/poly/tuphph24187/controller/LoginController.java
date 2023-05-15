package com.poly.tuphph24187.controller;


import com.poly.tuphph24187.bean.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    //@RequestMapping(value = "home", method = RequestMethod.GET)
    @GetMapping("login")
    public String getLoginForm()
    {
        return "login/login";
    }


//	@PostMapping("login")
//	public String login(
//		@RequestParam(name="email") String email,
//		@RequestParam(name="password") String password
//	) {
//		System.out.println(email);
//		System.out.println(password);
//		return "login";
//	}

    @PostMapping("login")
    public String login(Login login)
    {
        System.out.println(login.getEmail());
        System.out.println(login.getPassword());
        return "redirect:login";
    }

}
