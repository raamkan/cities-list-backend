package com.challenge.citylists.repository;

import com.challenge.citylists.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CitiesRepository extends JpaRepository<Cities, Integer> {

    @Query(value = "SELECT c from Cities c where c.name like :text%")
    public List<Cities> findCityByText(String text);

    @Modifying
    @Query("update Cities c set c.name = :name, c.cityImageURL = :cityImageURL where c.id = :id")
    int updateCityInfo(@Param("id") Long id, @Param("name") String name, @Param("cityImageURL") String cityImageURL);

    @Query(value = "SELECT c from Cities c where c.id between :startIndex and :lastIndex order by c.id")
    public List<Cities> findCityDetailsWithin(@Param("startIndex") Long startIndex, @Param("lastIndex") Long lastIndex);

}
