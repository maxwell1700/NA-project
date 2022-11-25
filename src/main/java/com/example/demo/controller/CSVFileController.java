package com.example.demo.controller;

import com.example.demo.CSVFileService;
import com.example.demo.Response;
import com.example.demo.model.CSVREADWRITE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CSVFileController {
   @Autowired
    CSVFileService csvFileService;

    @GetMapping("/csvrecords")
    public ResponseEntity<List<CSVREADWRITE>>getCSVFile() throws IOException {


        try {
            List<CSVREADWRITE> csvfile = csvFileService.getAllRecords();

            if (csvfile.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(csvfile, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/csvrecords/{id}")
    public CSVREADWRITE getCSVRecordByName(@PathVariable int id) throws IOException {
        return csvFileService.getRecordById(id);
    }

    @PostMapping("/csvrecords/{id}")
    public ResponseEntity<Response>updateCSVRecord(@RequestBody CSVREADWRITE csvreadwrite, @PathVariable int id) {


        String message = "";
        try{
            csvFileService.updateRecord(csvreadwrite,id);

            message = "Updated the file successfully:  rowsUpdated : 1  csvId :"  + id;
            return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
        } catch (Exception e) {
            message = "Could not update the file";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
        }
    }


    }


