package project.clinic.Model;

import lombok.Data;
import project.clinic.Model.Doctor;
import project.clinic.Model.Patient;

import javax.persistence.*;

@Entity
@Data
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer year;
    private Integer month;
    private Integer day;
    private String purpose;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Doctor doctor;

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
