package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
@Builder
public class CSVREADWRITE {
    @Id
    private Integer id;
    private String filename;
    private String origin;
    private String metadata;
    private String hash;
public CSVREADWRITE(){};
    public CSVREADWRITE(Integer id, String filename, String origin, String metadata, String hash) {
        this.id = id;
        this.filename = filename;
        this.origin = origin;
        this.metadata = metadata;
        this.hash = hash;
    }
}

