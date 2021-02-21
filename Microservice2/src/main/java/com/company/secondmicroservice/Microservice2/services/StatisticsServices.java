package com.company.secondmicroservice.Microservice2.services;

import com.company.secondmicroservice.Microservice2.entities.Statistics;

import java.util.List;

public interface StatisticsServices {

    List<Statistics> getStatistics(String jwt, String email);


}
