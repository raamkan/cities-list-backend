package com.challenge.citylists.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CityUpdateModel {

    private Long id;

    private String cityName;

    private String cityImage;
}
