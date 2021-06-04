package com.t1908e.assignmentspring.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //relation ship 1 -> n
    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Street> streets;

    public District(String name) {
        this.name = name;
    }

    public void addStreet(Street street) {
        if(this.streets == null){
            this.streets = new HashSet<>();
        }
        this.streets.add(street);
    }
}
