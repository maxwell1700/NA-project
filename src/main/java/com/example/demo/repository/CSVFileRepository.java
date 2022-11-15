package com.example.demo.repository;

import com.example.demo.model.CSVREADWRITE;
import org.springframework.data.repository.CrudRepository;

public interface CSVFileRepository extends CrudRepository<CSVREADWRITE, Integer> {
}
