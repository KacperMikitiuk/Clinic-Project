package project.clinic.Model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;
    @Column(name = "role")
    private String role;
}
