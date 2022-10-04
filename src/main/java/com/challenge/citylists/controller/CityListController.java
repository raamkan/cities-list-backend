package com.challenge.citylists.controller;

import com.challenge.citylists.common.Constants;
import com.challenge.citylists.model.CityInfo;
import com.challenge.citylists.model.CityUpdateModel;
import com.challenge.citylists.service.CityListService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/rest/api/v1")
public class CityListController {

    @Autowired
    public CityListService cityListService;

    @PostMapping("/upload")
    public void uploadCSV(@RequestParam("file") MultipartFile file) {
    }

    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/update/cityInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateCityInfo(@RequestBody CityUpdateModel cityInfo){
        cityListService.updateCityInfo(cityInfo.getId(), cityInfo.getCityName(), cityInfo.getCityImage());
        return "Success";
    }

    @GetMapping("/getTotalCities")
    public int getTotalCities(){
        return cityListService.getTotalCitiesCount();
    }

    @GetMapping("/customPagination")
    public List<CityInfo> getCityDetailsWithin(@RequestParam(name = "startIndex") int startIndex, @RequestParam(name="lastIndex") int lastIndex){
        return cityListService.getCityDetailsWithin(startIndex, lastIndex);
    }

    @GetMapping("/search")
    public List<CityInfo> searchCity(@RequestParam(name="searchText") String searchText){
        return cityListService.searchCity(searchText);
    }

    @DeleteMapping("/delete")
    public void deleteCity(@RequestBody CityInfo cityInfo){
         cityListService.deleteCity(cityInfo);
    }

    @GetMapping("/uploadFromResource")
    public void uploadCSVFromResource() throws IOException {
        this.getClass().getClassLoader().getResource(Constants.CSV_FILE_PATH);
        List<CityInfo> cityInfos = new CsvToBeanBuilder(new FileReader(this.getClass().getClassLoader().getResource(Constants.CSV_FILE_PATH).getFile()))
                .withType(CityInfo.class)
                .build()
                .parse();

        cityInfos.forEach( cityInfo -> {
            cityListService.loadingCSVData(cityInfo);
        });

    }
}
