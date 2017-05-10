package ru.kpfu.itis.Gilmanova.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Adel on 28.04.2017.
 */
@Entity
@Table
public class Address implements Serializable {
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
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
