package com.dgn.resttemplateex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private String name;
    private String dist;
    private String address;
    private String phone;
    private String loc;
}
