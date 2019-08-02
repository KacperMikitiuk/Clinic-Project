package project.clinic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.clinic.Model.Patient;
import project.clinic.Model.Visit;
import project.clinic.Repository.PatientRepository;
import project.clinic.Repository.VisitRepository;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @GetMapping("/profile/add")
    public String profile(@ModelAttribute Patient patient, ModelMap map, RedirectAttributes redirectAttributes){
        patientRepository.save(patient);
        return "redirect:/profile/"+patient.getId();
    }
    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Integer id, ModelMap map){
        Patient patient = patientRepository.findById(id).get();
        map.put("patient", patient);
        return "profile";
    }
}
