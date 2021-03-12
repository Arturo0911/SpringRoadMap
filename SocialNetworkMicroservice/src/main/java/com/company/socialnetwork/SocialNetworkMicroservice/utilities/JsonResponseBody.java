package com.company.socialnetwork.SocialNetworkMicroservice.utilities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class JsonResponseBody {

    @Getter @Setter
    private int server;

    @Getter @Setter
    private String statusMessage;

    @Getter @Setter
    private Object response;

}
