package MavenDB.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
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
        return "redirect:/showall";
    }
    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    public String retrievDB(Model model){
        Contacts contacts = new Contacts();
        SessionFactory sessionFac = new Configuration().configure().buildSessionFactory();
        Session session = sessionFac.openSession();
        session.beginTransaction();

        String hql = "SELECT E.fname FROM Contacts E";
        Query query = session.createQuery(hql);
        List results = query.getResultList();

        contacts = (Contacts) session.get(Contacts.class, 5); // For non-Collection
        model.addAttribute("Username", contacts.getFname());
        model.addAttribute("Password", contacts.getLname());
        model.addAttribute("listofCon", results);
        System.out.println(contacts.getFname() + "  " + contacts.getLname());
        return "display";
    }
}
