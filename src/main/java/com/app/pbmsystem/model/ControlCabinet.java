package com.app.pbmsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "control_cabinet")
@Data
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
    @Column(name = "current")
    private Long current;

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
    @Column(name = "protection_amount")
    private Long protectionAmount;

    @NotNull
    @Column(name = "contactors_amount")
    private Long contactorsAmount;

    @NotNull
    @Column(name = "is_archive")
    private boolean isArchive;

    @NotNull
    @Column(name = "not_used_in_model")
    private boolean notUsedInModel;

    @NotNull
    @Column(name = "to_valuation")
    private boolean toValuation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offerer_id")
    private User offerer;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
}