package project.clinic.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String name;
    private String surname;
    private Integer age;
    private String pesel;
    private String password;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Visit> visitList = new ArrayList<>();

    public Patient(String email, String name, String surname, Integer age, String pesel, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.pesel = pesel;
        this.password = password;
    }

}
