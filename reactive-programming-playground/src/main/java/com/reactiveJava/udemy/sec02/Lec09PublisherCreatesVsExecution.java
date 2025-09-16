package com.reactiveJava.udemy.sec02;

import com.reactiveJava.udemy.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

/* if you have a CompletableFuture already, then we can convert that into a Mono */
public class Lec09PublisherCreatesVsExecution {

    private static final Logger log = LoggerFactory.getLogger(Lec09PublisherCreatesVsExecution.class);

    public static void main(String[] args) {
        getName();
        /* we can call getName () directly, but it will just invoke the method and the actual business logic will not get execute
        until subcriber gets called*/
        //to do that
        getName().subscribe(Util.subscriber());
    }

    private static Mono<String> getName(){
        log.info("entered the method");
        return Mono.fromSupplier(()->{
            log.info("generating name ");
            Util.sleepSeconds(3);
            return Util.faker().name().firstName();
        });
    }
}
