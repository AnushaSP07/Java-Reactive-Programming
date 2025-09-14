package com.reactiveJava.udemy.sec02;

/* If we do not have the terminal operators, then stream operators will not execute
*
* Note: Class is not related to ReactingProgramming
*
* Easiest way to create Java Stream ( as Stream is lazy)
* */

import com.sun.source.doctree.SeeTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class Lec01LazyStream {

    private static final Logger log = LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args) {
        /* Stream is said as lazy, bcz it will not execute until any terminal operations
        * are getting called
        *
        * In the below example stream will not execute unless any terminal methods get called
        *
        * This is how the reactive programming is also going to be
        *
        * Until or unless you connect a subscriber or you subscribe, it will not execute
        * */
        Stream.of(1)
                .peek(i -> log.info("received :{} ",1))
                .toList();
    }

}
