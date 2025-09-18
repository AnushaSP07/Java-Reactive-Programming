package com.reactiveJava.udemy.sec04;

import com.reactiveJava.udemy.common.Util;
import com.reactiveJava.udemy.sec04.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class Lec03FluxSinkThreadSafety {

    private static Logger log = LoggerFactory.getLogger(Lec03FluxSinkThreadSafety.class);

    public static void main(String[] args) {
        demo2ThreadSafe();
    }

    private static void demo1NotThreadSafe(){
        var list = new ArrayList<Integer>();
        Runnable runnable = () ->{
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }
        Util.sleepSeconds(3);
        log.info("list size {} ",list.size());
    }

    /*
    arrayList is not thread safe
    flux sink is thread safe. we get all 10000 items safely into arrayList
     */
    private static void demo2ThreadSafe(){
        var list = new ArrayList<String>();
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(list::add);

        Runnable runnable = () ->{
            for (int i = 0; i < 1000; i++) {
                generator.generate();
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }
        Util.sleepSeconds(3);
        log.info("list size {} ",list.size());
    }
}
