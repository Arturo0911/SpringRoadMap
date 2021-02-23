package com.company.secondmicroservice.Microservice2.services;

import com.company.secondmicroservice.Microservice2.daos.StatisticsDao;
import com.company.secondmicroservice.Microservice2.entities.Statistics;
import com.company.secondmicroservice.Microservice2.utilities.JsonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;


@Service(value = "statistics.service")
public class StatisticsServicesImpl implements StatisticsServices{

    @Autowired
    StatisticsDao statisticsDao;

    @Override
    public List<Statistics> getStatistics(String jwt, String email){
        //it calls ToDoMicroservice to get data
        List<LinkedHashMap> todos = getNewDataFromToDoMicroservice(jwt);
        //it calculates the statistics
        String statisticsDescr="No statistics available!";
        if(todos !=null && todos.size() > 0){
            int lowPriorityTodos = 0;
            int highPriorityTodos = 0;
            for(int i=0; i<todos.size(); i++){
                LinkedHashMap todo = todos.get(i);
                String priority = (String) todo.get("priority");
                if("low".equals(priority))  lowPriorityTodos++;
                if("high".equals(priority)) highPriorityTodos++;
            }
            statisticsDescr = "You have <b>" + lowPriorityTodos + " low priority </b> ToDos and <b>" + highPriorityTodos + " high priority</b> ToDos.";
        }
        //it saves it into MySql database if date is new
        List<Statistics> statistics = statisticsDao.getLastStatistics(email);
        if(statistics.size()>0){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String lastDate = sdf.format(statistics.get(0).getDate());
            Date now = new Date();
            //diff in msec
            long diff = now.getTime() - statistics.get(0).getDate().getTime();
            //diff in days
            long days = diff / (24 * 60 * 60 * 1000);
            if(days>1){
                //save in database and update local List taken from the DB before
                statistics.add(statisticsDao.save(new Statistics(null, statisticsDescr, new Date(), email)));
            }
        }
        //returns entire list got from MySql database
        return statistics;
    }



    //calls ToDoMicroservice
    private List<LinkedHashMap> getNewDataFromToDoMicroservice(String jwt){

        //preparing the header for the request (adding the jwt)
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("jwt", jwt);
        HttpEntity<?> request = new HttpEntity(String.class, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonResponseBody> responseEntity = restTemplate.exchange("http://localhost:8383/showToDos", HttpMethod.POST, request, JsonResponseBody.class);

        List<LinkedHashMap> todosList = (List) responseEntity.getBody().getResponse();
        return todosList;

    }
}
