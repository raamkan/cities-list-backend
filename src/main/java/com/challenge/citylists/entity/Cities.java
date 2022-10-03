package com.challenge.citylists.entity;

import javax.persistence.*;

@Entity
@Table(name="cities")
public class Cities {
    public Cities(Long id, String name, String cityImageURL) {
        this.id = id;
        this.name = name;
        this.cityImageURL = cityImageURL;
    }

    public Cities() {
    }

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @Column(name = "city_img")
   private String cityImageURL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityImageURL() {
        return cityImageURL;
    }

    public void setCityImageURL(String cityImageURL) {
        this.cityImageURL = cityImageURL;
    }
}
