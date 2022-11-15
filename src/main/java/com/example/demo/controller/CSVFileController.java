package com.example.demo.controller;

import com.example.demo.CSVFileService;
import com.example.demo.model.CSVREADWRITE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CSVFileController {
   @Autowired
    CSVFileService csvFileService;

    @GetMapping("/csvrecords")
    public List<CSVREADWRITE>getCSVFile() throws IOException {
        return  csvFileService.getAllRecords();
    }


    @GetMapping("/csvrecords/{id}")
    public CSVREADWRITE getCSVRecordByName(@PathVariable int id) throws IOException {
        return csvFileService.getRecordById(id);
    }

    @PostMapping("/csvrecords/{id}")
    public void updateCSVRecord(@RequestBody CSVREADWRITE csvreadwrite, @PathVariable int id) {
        csvFileService.updateRecord(csvreadwrite,id);
    }


    }


