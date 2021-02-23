package com.company.secondmicroservice.Microservice2.daos;

import com.company.secondmicroservice.Microservice2.entities.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatisticsDao extends JpaRepository<Statistics, Integer> {

    @Query(value="SELECT * FROM Latest_statistics WHERE email=:email  ORDER BY DATE DESC LIMIT 10;", nativeQuery = true)
    public List<Statistics> getLastStatistics(@Param("email") String email);

}
