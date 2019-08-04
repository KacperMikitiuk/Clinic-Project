package project.clinic.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password")
    @Length(min = 4, message = "*Your password must have at least 4 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "patient_role", joinColumns = @JoinColumn(name = "patient_id_role"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    private String name;
    private String surname;
    private Integer age;
    private String pesel;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Visit> visitList = new ArrayList<>();

    public Patient(String name, String surname, String email, Integer age, String pesel, String password, Set<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.pesel = pesel;
        this.password = password;
        this.roles = roles;
    }

}
