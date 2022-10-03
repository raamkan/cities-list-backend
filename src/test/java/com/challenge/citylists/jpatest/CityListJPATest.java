package com.challenge.citylists.jpatest;

import com.challenge.citylists.entity.Cities;
import com.challenge.citylists.repository.CitiesRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CityListJPATest {

    private static final String NEW_NAME="Pune";
    private static final String NEW_URL="https://upload.wikimedia.org/wikipedia/commons_%28China%29.png/500px-Guizhou_%28China%29-newurl.png";
    @Autowired
    CitiesRepository citiesRepository;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void find_all_cities_info_loaded_by_csv(){
        Iterable<Cities> cities =  citiesRepository.findAll();
        System.out.println(StreamSupport.stream(cities.spliterator(), false).count());
        assertTrue(StreamSupport.stream(cities.spliterator(), false).count() == 1000);
    }

    @Test
    public void get_cities_info_of_page_length_twenty(){
        long count = citiesRepository.findCityDetailsWithin(0L, 20L).stream().count();
        assertTrue(count == 20L);
    }

    @Test
    public void update_with_query_exception() throws DataIntegrityViolationException {
        exceptionRule.expect(DataIntegrityViolationException.class);
        citiesRepository.updateCityInfo(1L, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Yuancheng01.jpg/500px-Yuancheng01.jpg" );
    }

    /**
    @Test
    public void update_city_info_name_and_image(){
        int updatedRows = citiesRepository.updateCityInfo(1001L, NEW_NAME, NEW_URL);
        assertEquals(1, updatedRows);
    }
     **/

    @Test
    public void get_all_cities_total_count(){
        int count = (int) citiesRepository.findAll().stream().count();
        assertEquals(1000, count);
    }

    @Test
    public void get_result_as_per_search_test(){
         List<Cities> citiesList = citiesRepository.findCityByText("Bangalo");
         assertEquals("Bangalore", citiesList.get(0).getName());
    }
}
