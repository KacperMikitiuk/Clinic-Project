package project.clinic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private Integer age;
    private String title;
    private Integer visitCost;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private List<Visit> visitList = new ArrayList<>();
    public Doctor(String name, String surname, Integer age, String title, Integer visitCost) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.title = title;
        this.visitCost = visitCost;
    }
}
