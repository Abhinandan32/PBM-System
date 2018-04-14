package com.app.pbmsystem.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "control_cabinet")
@NoArgsConstructor
public class ControlCabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //TODO maybe better option will be create custom generator?
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "real_time")
    private Long realTime;

    @NotNull
    @Column(name = "esitmated_time")
    private Long estimatedTime;

    @NotNull
    @Column(name = "valuation_cost")
    private Long valuationCost;

    @NotNull
    @Column(name = "adjusted_cost")
    private Long adjustedCost;

    @NotNull
    @Column(name = "x_dimension")
    private Long xDimension;

    @NotNull
    @Column(name = "y_dimension")
    private Long yDimension;

    @NotNull
    @Column(name = "amperes")
    private Long amperes;

    @NotNull
    @Column(name = "device_amount")
    private Long deviceAmount;

    @NotNull
    @Column(name = "plc_input")
    private Long plcInput;

    @NotNull
    @Column(name = "plc_output")
    private Long plcOutput;

    @NotNull
    @Column(name = "drive_amount")
    private Long driveAmount;

    @NotNull
    @Column(name = "inventer_amount")
    private Long inverterAmount;

    @NotNull
    @Column(name = "safety")
    private boolean safety;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(name = "offer_control_cabinet",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "control_cabinet_id"))
    private List<Offer> offers = new ArrayList<>(); //TODO maybe set?
}