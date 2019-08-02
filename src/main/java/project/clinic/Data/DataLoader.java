package project.clinic.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.clinic.Model.Doctor;
import project.clinic.Model.Patient;
import project.clinic.Repository.DoctorRepository;
import project.clinic.Repository.PatientRepository;

import javax.print.Doc;

@Component
class DataLoader implements CommandLineRunner {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args)  throws Exception{
        if(doctorRepository.count()==0){
            doctorRepository.save(new Doctor("Adam", "Kowalski", 30, "Bacteriology", 150));
            doctorRepository.save(new Doctor("Piotr", "Nowak", 40, "Andrology", 140));
            doctorRepository.save(new Doctor("Anna", "Suzuk", 28, "Cardiology", 160));
            doctorRepository.save(new Doctor("Tomek", "Len", 35, "Hematology", 130));
            doctorRepository.save(new Doctor("Joanna", "Kowalczuk", 38, "Dermatology", 180));
        }
        if(patientRepository.count()==0){
            patientRepository.save(new Patient("Kacper", "Zden", "www@ww.pl", 28, "1235436", "qwerty"));
            patientRepository.save(new Patient("Tomek", "Mien", "asdfd@ww.pl", 25, "1235436", "qwerty"));
            patientRepository.save(new Patient("Ania", "Wrotka", "qrqet@ww.pl", 30, "1235436", "qwerty"));
        }
    }
}