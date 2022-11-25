package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CSVREADWRITE {
    @Id
    private Integer id;
    private String filename;
    private String origin;
    private String metadata;
    private String hash;


}

