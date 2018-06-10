package com.app.pbmsystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by dawidbranicki on 21.05.2018.
 */
@Getter
@Setter
@NoArgsConstructor
public class ControlCabinetDTO {
    private Long id;
    private String name;
    private boolean toValuation;
    private Long adjustedCost;
    private Long contactorsAmount;
    private Long current;
    private boolean isArchive;
    private boolean notUsedInModel;
    private Long plcInput;
    private Long plcOutput;
    private Long project_id;
    private Long realTime;
    private Long protectionAmount;
    private Long safety;
    private Long driveAmount;
}
