package com.reactiveJava.udemy.sec04;

import com.reactiveJava.udemy.common.Util;
import reactor.core.publisher.Flux;

/*
Sometimes we might have requirement to keep on printing data until meets specific condition
in that case we can go for
fluxSink()
 */
public class Lec01FluxCreate {
    public static void main(String[] args) {

        // this is a generic code
      /*  Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++){
                fluxSink.next(Util.faker().country().name());
            }
            fluxSink.complete();
        }).subscribe(Util.subscriber());*/

      /*  Until we get country name called china keep on run the execution*/
        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            }while (!country.equalsIgnoreCase("japan"));
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
