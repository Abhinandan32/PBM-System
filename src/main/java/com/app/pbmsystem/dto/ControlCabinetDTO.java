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
    private String cabinetName;
    private boolean isValuated;
}
