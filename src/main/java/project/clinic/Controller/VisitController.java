package project.clinic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.clinic.Model.Doctor;
import project.clinic.Model.Patient;
import project.clinic.Model.Visit;
import project.clinic.Repository.DoctorRepository;
import project.clinic.Repository.PatientRepository;
import project.clinic.Repository.VisitRepository;

@Controller
public class VisitController {

    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/reservation/{id}")
    public String bookVisit(@PathVariable Integer id, ModelMap map){
        Patient patient = patientRepository.findById(id).get();
        map.put("doctors", doctorRepository.findAll());
        map.put("patient", patient);
        Visit visit = new Visit();
        visit.setPatient(patient);
        map.put("visit", visit);
        return "reservation";
    }

    @PostMapping("/profile/{id}/reservation/add")
    public String addVisit(@PathVariable Integer id, @ModelAttribute Visit visit, @RequestParam Integer idDoctor){
        visit.setDoctor(doctorRepository.findById(idDoctor).get());
        visitRepository.save(visit);
        return "redirect:/profile/"+id;
    }
    @GetMapping("/profile/{id}/delete/{id_visit}")
    public String addDoc(@PathVariable Integer id, @PathVariable Integer id_visit) {
        visitRepository.deleteById(id_visit);
        return "redirect:/profile/"+id;
    }

}
