package com.company.secondmicroservice.Microservice2.services;

import com.company.secondmicroservice.Microservice2.entities.Statistics;
import com.company.secondmicroservice.Microservice2.utilities.JsonResponseBody;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;


@Service
public class StatisticsServicesImpl implements StatisticsServices{

    @Override
    public List<Statistics> getStatistics(String jwt, String email) {
        return null;
    }

    private List<LinkedHashMap> getDataFromToDoMicroservice(String jwt){

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("jwt", jwt);
        HttpEntity<?> request = new HttpEntity(String.class, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonResponseBody> responseEntity = restTemplate.exchange("http://localhost:8383/showtodo", HttpMethod.POST, request,JsonResponseBody.class);
        List<LinkedHashMap> toDoList = (List) responseEntity.getBody().getResponse();

        return toDoList;
    }
}
