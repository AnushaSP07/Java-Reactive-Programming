package com.reactiveJava.udemy.sec02;

import com.reactiveJava.udemy.common.Util;
import com.reactiveJava.udemy.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
To Demo non-blocking IO
ensure that the external service is up and running
 */
public class Lec11NonBlockingIO {

    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {
        var client = new ExternalServiceClient();

        log.info("Starting");
        client.getProductName(1)
                .subscribe(Util.subscriber());
        Util.sleepSeconds(2);
    }

}
