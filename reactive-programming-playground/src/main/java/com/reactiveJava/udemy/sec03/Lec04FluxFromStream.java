package com.reactiveJava.udemy.sec03;

import com.reactiveJava.udemy.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStream {
    public static void main(String[] args) {


        var list = List.of(1,2,3,4,5);
        var stream = list.stream();

        var flux = Flux.fromStream(stream);

        /*if we do subscirbe for each seperatley we will get exception
        * bcz java stream is a one time use
        *
        * Once you create a stream, and once you consumed it, using
        * for each or anything
        * you cannot use the stream again
        *
        * Example
        *
        * stream.forEach(System.out::println);
        * stream.forEach(System.out::println);
        *
        * will also give same illegalStateException
        * */

//        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2"));

        /*to handle that when you have multiple subscribers -
                then we have to create a stream for each single time */
        var flux2 = Flux.fromStream(list::stream);
        flux2.subscribe(Util.subscriber("sub1"));
        flux2.subscribe(Util.subscriber("sub2"));
    }
}
