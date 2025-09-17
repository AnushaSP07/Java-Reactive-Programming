package com.reactiveJava.udemy.sec03;

import com.reactiveJava.udemy.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec09FluxIntervals {
    public static void main(String[] args) {

      /*  this code will do emit data for every 500 mili seconds or
                in case of emit one message for every 500 milliseconds
            in that case we can go for this
                */
        Flux.interval(Duration.ofMillis(500))
                .subscribe(Util.subscriber());

      /*  util you cancel externally it will keep on calling the data
                for every 500 ms*/
        Util.sleepSeconds(5);
    }
}
