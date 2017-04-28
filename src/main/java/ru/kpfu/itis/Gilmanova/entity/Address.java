package ru.kpfu.itis.Gilmanova.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Adel on 28.04.2017.
 */
@Entity
@Table
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String house;

    @Column
    private Integer flat;

    @Column
    private Integer index;

    @Column
    private String area;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public Integer getFlat() {
        return flat;
    }

    public Integer getIndex() {
        return index;
    }

    public String getArea() {
        return area;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
