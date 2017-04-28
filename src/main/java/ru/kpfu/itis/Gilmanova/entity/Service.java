package ru.kpfu.itis.Gilmanova.entity;

import javax.persistence.*;

/**
 * Created by Adel on 28.04.2017.
 */
@Entity
@Table
public class Service {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer code;

    @Column
    private String name;

    @Column
    private Integer price;
}
