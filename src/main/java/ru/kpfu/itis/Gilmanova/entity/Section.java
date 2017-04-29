package ru.kpfu.itis.Gilmanova.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Adel on 29.04.2017.
 */
@Entity
@Table
public class Section {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "section")
    private List<Service> services;
}
