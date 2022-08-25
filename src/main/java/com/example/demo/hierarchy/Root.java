package com.example.demo.hierarchy;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorColumn(name = "discriminator")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Root {

    @Id
    @GeneratedValue
    public Long id;
    
    private String rootString;

    public String getRootString() {
        return rootString;
    }

    public void setRootString(String rootString) {
        this.rootString = rootString;
    }
}
