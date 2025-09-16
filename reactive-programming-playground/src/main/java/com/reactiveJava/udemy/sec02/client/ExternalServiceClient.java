package com.reactiveJava.udemy.sec02.client;

import com.reactiveJava.udemy.common.AbstractHttpClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

/*
when the method is invoked, we create a MONO which is capable of sending a request.
But the actual HTTP request is sent, only when it is subscribed.
 */
public class ExternalServiceClient extends AbstractHttpClient {

    public Mono<String> getProductName(int productId){
        return this.httpClient.get()
                .uri("/demo01/product/"+productId)
                .responseContent()
                .asString()
                .next();
    }
}
