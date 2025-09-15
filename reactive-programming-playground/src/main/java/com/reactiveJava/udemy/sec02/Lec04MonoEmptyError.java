package com.reactiveJava.udemy.sec02;

import com.reactiveJava.udemy.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {

    public static void main(String[] args) {
      //  getUserName(1).subscribe(Util.subscriber());

        /*instead of using default subscriber, let us use the
        consumer string*/
        getUserName(3).subscribe(
                s-> System.out.println(s),
                err ->{}
        );
    }

    private static Mono<String> getUserName(int userId){
        return switch (userId){
            case 1 -> Mono.just("sam");
            case 2 -> Mono.empty(); // Null
            default -> Mono.error(new RuntimeException("Invalid Input"));
        };
    }
}
