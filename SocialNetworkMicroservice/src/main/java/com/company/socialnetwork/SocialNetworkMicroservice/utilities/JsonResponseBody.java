package com.company.socialnetwork.SocialNetworkMicroservice.utilities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor @NoArgsConstructor
public class JsonResponseBody {

    @Getter @Setter
    private int server;

    @Getter @Setter
    private Object response;

}
