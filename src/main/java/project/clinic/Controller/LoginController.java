package project.clinic.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import project.clinic.Model.Patient;
import project.clinic.Repository.PatientRepository;
@Controller
public class LoginController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String register(ModelMap map){
        map.put("patient", new Patient());
        return "registration";
    }
}
