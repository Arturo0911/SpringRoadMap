package com.company.secondmicroservice.Microservice2.utilities;


import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class JsonResponseBody {

    
    @Getter @Setter
    private int server;

    @Getter @Setter
    private Object response;

    public Object getResponse(){
        return response;
    }


}
