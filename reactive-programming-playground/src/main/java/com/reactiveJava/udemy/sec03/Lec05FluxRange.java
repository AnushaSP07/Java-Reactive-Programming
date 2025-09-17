package com.reactiveJava.udemy.sec03;

import com.reactiveJava.udemy.common.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {
        Flux.range(1,10).subscribe(Util.subscriber());

        //assignment - generate 10 random first names
        Flux.range(1,10)
                .map(i->Util.faker().name().firstName())
                .subscribe(Util.subscriber());
    }
}
