package com.app.pbmsystem.service.impl;

import com.app.pbmsystem.model.ControlCabinet;
import com.app.pbmsystem.repository.ControlCabinetRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * Created by dawidbranicki on 13.04.2018.
 */

@Service
public class CsvFileService {

    private ControlCabinetRepository controlCabinetRepository;

    @Autowired
    public CsvFileService(ControlCabinetRepository controlCabinetRepository) {
        this.controlCabinetRepository = controlCabinetRepository;
    }

    public void store(MultipartFile multipartFile) throws IOException {
        File file = convertMultipartFile(multipartFile);

        try (Reader reader = new FileReader(file)) {
            @SuppressWarnings({"unchecked"})
            CsvToBean<ControlCabinet> cabinetCsvToBean = new CsvToBeanBuilder(reader)
                    .withType(ControlCabinet.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();
            List<ControlCabinet> controlCabinets = cabinetCsvToBean.parse();
            controlCabinets.forEach(this::setDefaultVariables);

            controlCabinetRepository.saveAll(controlCabinets);

        }
    }

    private void setDefaultVariables(ControlCabinet controlCabinet) {
        controlCabinet.setArchive(true);
        controlCabinet.setToValuation(false);
        controlCabinet.setEstimatedTime((long) 0);
        controlCabinet.setValuationCost((long) 0);
    }

    private File convertMultipartFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;
    }
}
