package com.reactiveJava.udemy.sec04.helper;

import com.reactiveJava.udemy.common.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

/*
* instead of writing all logic in a single method like in Lec01 of Sec04
* we can separate the logic
*
* this class shows that
* */
public class NameGenerator implements Consumer<FluxSink<String>> {

    private FluxSink<String> sink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.sink = stringFluxSink;
    }

    public void generate(){
        this.sink.next(Util.faker().name().firstName());
    }
}
