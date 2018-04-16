package com.app.pbmsystem.service;

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
    @Autowired
    private ControlCabinetRepository controlCabinetRepository;


    public void store(MultipartFile multipartFile) throws IOException {
        File file = convertMulitpartFile(multipartFile);

        try (Reader reader = new FileReader(file)) {
            @SuppressWarnings({"unchecked"})
            CsvToBean<ControlCabinet> cabinetCsvToBean = new CsvToBeanBuilder(reader)
                    .withType(ControlCabinet.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();
            List<ControlCabinet> controlCabinets = cabinetCsvToBean.parse();
            controlCabinets.forEach(c -> {
                c.setArchive(true);
                c.setToValuation(false);
                c.setNotUsedInModel(true);
            });

            controlCabinetRepository.saveAll(controlCabinets);

        }
    }

    private File convertMulitpartFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;
    }
}
