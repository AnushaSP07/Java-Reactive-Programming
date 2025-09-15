package com.reactiveJava.udemy.sec02;

import com.reactiveJava.udemy.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec05MonoFromSupplier {

    private static final Logger log = LoggerFactory.getLogger(Lec05MonoFromSupplier.class);

    public static void main(String[] args) {
        var list = List.of(1,2,3);
      /*  Mono.just(sum(list))
                .subscribe(Util.subscriber());*/

       /* if you want to delay the execution until the subscriber is called then you have to go for
            fromSupplier()*/
        Mono.fromSupplier(() -> sum(list))
                .subscribe(Util.subscriber());


    }

    public static int sum(List<Integer> list){
        log.info("finding the sum of {}", list);
        return list.stream().mapToInt(a -> a).sum();
    }
}
