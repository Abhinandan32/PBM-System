package com.app.pbmsystem.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "control_cabinet")
@Getter
@Setter
@NoArgsConstructor
public class ControlCabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @CsvBindByName(column = "TIME")
    @Column(name = "real_time")
    private Long realTime;

    //    @NotNull
    @Column(name = "esitmated_time")
    private Long estimatedTime;

    //    @NotNull
    @Column(name = "valuation_cost")
    private Long valuationCost;

    @NotNull
    @CsvBindByName(column = "PRICE")
    @Column(name = "adjusted_cost")
    private Long adjustedCost;

    @NotNull
    @CsvBindByName(column = "CURRENT")
    @Column(name = "current")
    private Long current;

    @NotNull
    @CsvBindByName(column = "PLC_IN")
    @Column(name = "plc_input")
    private Long plcInput;

    @NotNull
    @CsvBindByName(column = "PLC_OUT")
    @Column(name = "plc_output")
    private Long plcOutput;

    @NotNull
    @CsvBindByName(column = "MOTORS")
    @Column(name = "drive_amount")
    private Long driveAmount;

    @NotNull
    @CsvBindByName(column = "SAFETY")
    @Column(name = "safety")
    private Long safety;

    @NotNull
    @CsvBindByName(column = "Protection")
    @Column(name = "protection_amount")
    private Long protectionAmount;

    @NotNull
    @CsvBindByName(column = "Contactors")
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

    //    @NotNull
    @CsvBindByName(column = "Offerent")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offerer_id")
    private User offerer;

    //    @NotNull
//    @CsvBindByName(column = "Project", required = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
}