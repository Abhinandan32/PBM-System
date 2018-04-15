package com.app.pbmsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "offer")
@Data
@NoArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offerer_id")
    private User offerer;

    @ManyToMany(mappedBy = "offers", fetch = FetchType.EAGER)
    private List<ControlCabinet> controlCabinets = new ArrayList<>(); //TODO maybe set?

}