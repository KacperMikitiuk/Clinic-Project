package project.clinic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import project.clinic.Model.Doctor;
import project.clinic.Repository.DoctorRepository;

@Controller
public class DoctorController  {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/")
    public String start(){
        return "index";
    }

    @GetMapping("/personel")
    public String show_personel_priceList(ModelMap map){
        map.put("doctors", doctorRepository.findAll());
        return "personel";
    }
    @GetMapping("/personel/create")
    public String createDoc(ModelMap map){
        map.put("doctor", new Doctor());
        return "personel_create";
    }
    @GetMapping("/personel/add")
    public String addDoc(@ModelAttribute Doctor doctor) {
        doctorRepository.save(doctor);
        return "redirect:/personel";
    }
    @GetMapping("/personel/delete/{id}")
    public String addDoc(@PathVariable Integer id) {
        doctorRepository.deleteById(id);
        return "redirect:/personel";
    }

}
