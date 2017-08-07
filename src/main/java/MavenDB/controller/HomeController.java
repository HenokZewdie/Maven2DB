package MavenDB.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import MavenDB.config.Handler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MavenDB.model.Contacts;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String insert() {
        return "home";
    }

    @RequestMapping(value = "/signup")
    public ModelAndView signup(HttpServletResponse response) throws IOException {
        return new ModelAndView("signupform", "modelatt", new Contacts());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("modelatt") Contacts contacts, Model model) {
        Handler handler= new Handler();
        handler.insertIntoDB(contacts);
        return "home";
    }
}
