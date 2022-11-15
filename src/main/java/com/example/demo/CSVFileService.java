package com.example.demo;

import com.example.demo.model.CSVREADWRITE;
import com.example.demo.repository.CSVFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CSVFileService {
    @Autowired
    CSVFileRepository csvFileRepository;

    public List<CSVREADWRITE> getAllRecords(){
        List<CSVREADWRITE> records = new ArrayList<>();
        csvFileRepository.findAll().forEach(records::add);
        return records;
    }

    public CSVREADWRITE getRecordById(int id){
        return csvFileRepository.findById(id).get();
    }
    public CSVREADWRITE updateRecord(CSVREADWRITE csvFile ,int id) {
        CSVREADWRITE updatedCSV = new CSVREADWRITE();
        updatedCSV.setId(id);
        updatedCSV.setFilename(csvFile.getFilename());
        updatedCSV.setOrigin(csvFile.getOrigin());
        updatedCSV.setHash(csvFile.getHash());
        updatedCSV.setMetadata(csvFile.getMetadata());
        return csvFileRepository.save(updatedCSV);

    }
}
