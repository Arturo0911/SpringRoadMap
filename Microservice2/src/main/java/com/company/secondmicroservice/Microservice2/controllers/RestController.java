package com.company.secondmicroservice.Microservice2.controllers;


import com.company.secondmicroservice.Microservice2.daos.StatisticsDao;
import com.company.secondmicroservice.Microservice2.services.StatisticsServices;
import com.company.secondmicroservice.Microservice2.utilities.JsonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Resource(name="statistics.service")
    StatisticsServices service;

    @CrossOrigin
    @RequestMapping(value="/getStatistics")
    public ResponseEntity<JsonResponseBody> getStatistics(@RequestParam(value ="jwt") String jwt, @RequestParam(value ="email") String email){
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), service.getStatistics(jwt, email)));
    }


    @RequestMapping("/test")
    public String test(){
        return "StatisticsMicroservice works correctly";
    }


}
