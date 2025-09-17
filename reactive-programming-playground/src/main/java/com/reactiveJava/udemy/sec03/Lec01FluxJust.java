package com.reactiveJava.udemy.sec03;

import com.reactiveJava.udemy.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxJust {
    public static void main(String[] args) {
        Flux.just(1,2,4,"asp")
                .subscribe(Util.subscriber());
    }
}
