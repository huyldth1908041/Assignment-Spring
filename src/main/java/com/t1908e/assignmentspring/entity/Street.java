package com.t1908e.assignmentspring.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Date inauguratedAt;
    private int status; //1 in-use 2// under-construction 3//fixing
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "districtId")
    private District district;
    @Column(insertable = false, updatable = false)
    private int districtId;

    public Street(String name, String description, Date inauguratedAt, int status, District district) {
        this.name = name;
        this.description = description;
        this.inauguratedAt = inauguratedAt;
        this.status = status;
        this.district = district;
    }

    public String getStatusString() {
        String status;
        switch (this.status) {
            case 1:
                status = "in use";
                break;
            case 2:
                status = "under construction";
                break;
            case 3:
                status = "fixing";
                break;
            default:
                status ="invalid";
                break;
        }
        return status;
    }
}
