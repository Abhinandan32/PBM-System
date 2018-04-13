package com.app.pbmsystem.model;

import com.app.pbmsystem.model.enums.Role;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usr")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Size(max = 32)
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "offerer", fetch = FetchType.LAZY)
    private List<Offer> offers = new ArrayList<>(); //TODO maybe set?
}