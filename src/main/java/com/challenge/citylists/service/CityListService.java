package com.challenge.citylists.service;

import com.challenge.citylists.entity.Cities;
import com.challenge.citylists.model.CityInfo;
import com.challenge.citylists.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityListService {

    @Autowired
    private CitiesRepository citiesRepository;

    public void loadingCSVData(CityInfo cityInfo){
        Cities cities = createCityInfo(cityInfo);
        citiesRepository.save(cities);
    }

    public int getTotalCitiesCount(){
        return (int) citiesRepository.count();
    }
    public void updateCityInfo(Long id, String name, String cityImageURL){
        citiesRepository.updateCityInfo(id, name, cityImageURL);
    }

    public List<CityInfo> getCityDetailsWithin(int startIndex, int lastIndex){
        return toDto(citiesRepository.findCityDetailsWithin((long) startIndex, (long) lastIndex));
    }
    public List<CityInfo> searchCity(String searchText){
        return toDto(citiesRepository.findCityByText(searchText));
    }
    private List<CityInfo> toDto(List<Cities> cities) {
        List<CityInfo> output = cities.stream().map(cityDetail -> {
            CityInfo cityInfo = new CityInfo();
            cityInfo.setId(cityDetail.getId());
            cityInfo.setCityName(cityDetail.getName());
            cityInfo.setCityImage(cityDetail.getCityImageURL());
            return cityInfo;
        }).collect(Collectors.toList());
        return output;
    }

    private Cities createCityInfo(CityInfo cityInfo) {
        Cities cities = new Cities();
        cities.setId(cityInfo.getId());
        cities.setName(cityInfo.getCityName());
        cities.setCityImageURL(cityInfo.getCityImage());
        return cities;
    }

    public void deleteCity(CityInfo cityInfo){
         citiesRepository.delete(new Cities(cityInfo.getId(),cityInfo.getCityName(), cityInfo.getCityImage()));
    }
}
