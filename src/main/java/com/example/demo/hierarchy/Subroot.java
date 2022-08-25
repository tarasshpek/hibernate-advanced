package com.example.demo.hierarchy;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Subroot extends Root {

    private String subrootString;
    
}
