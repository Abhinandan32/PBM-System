package com.app.pbmsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "control_cabinet")
public class ControlCabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @CsvBindByName(column = "TIME")
    @Column(name = "real_time")
    private Long realTime;

    @Column(name = "esitmated_time")
    private Long estimatedTime = (long) 0;

    @Column(name = "valuation_cost")
    private Long valuationCost = (long) 0;

    @NotNull
    @Size(max = 25)
    @CsvBindByName(column = "NAME")
    @Column(name = "name", unique = true)
    private String name;

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


    @Column(name = "offerer_id", nullable = false)
    @CsvBindByName(column = "Offerent")
    private Long offerer_id;

    @NotNull
    @Column(name = "project_id")
    @CsvBindByName(column = "Project")
    private Long project_id;

}