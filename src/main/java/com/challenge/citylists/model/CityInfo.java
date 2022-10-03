package com.challenge.citylists.model;

import com.opencsv.bean.CsvBindAndJoinByPosition;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CityInfo {

    @CsvBindByName(column = "id")
    private Long id;

    @CsvBindByName(column = "name")
    private String cityName;

    @CsvBindByName(column = "photo")
    private String cityImage;


}
